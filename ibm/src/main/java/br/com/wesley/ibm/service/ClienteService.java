package br.com.wesley.ibm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.wesley.ibm.dto.ClienteDto;
import br.com.wesley.ibm.dto.ClienteResponseDto;
import br.com.wesley.ibm.entity.Cliente;
import br.com.wesley.ibm.entity.Conta;
import br.com.wesley.ibm.exceptionhandler.NegocioException;
import br.com.wesley.ibm.mapper.ClienteMapper;
import br.com.wesley.ibm.repository.ClienteRepository;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ClienteService {

	@Resource
	private ClienteRepository clienteRepository;
	
	@Resource
	private ContaService contaService;
	
	@Resource
	private ClienteMapper clienteMapper;
	
	private Cliente salvar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public List<ClienteResponseDto> buscarTodos() {
		log.info("Buscando todos os clientes");
		final List<Cliente> clientes = clienteRepository.findAll();
		return clienteMapper.listToDto(clientes);
	}
	
	@Transactional
	public Integer cadastro(ClienteDto clienteDto) {
		try {
			log.info("cadastrando nova conta");
			Conta conta = contaService.criandoNovaConta(clienteDto.getNumeroConta());
			
			log.info("cadastrando novo cliente");
			Cliente cliente = clienteMapper.fromDto(clienteDto, conta);		
			cliente = salvar(cliente);	
			
			return cliente.getId();
		}catch (Exception e) {
			log.error("Erro ao salvar cliente.");
			throw new NegocioException(e.getMessage());			
		}	
	}
	
	public ClienteResponseDto buscarClientePorId(final Integer id) {
		try {
			log.info("Buscando cliente por id");
			Cliente cliente = clienteRepository.findById(id).get();
			return clienteMapper.toDto(cliente);
		}catch (Exception e) {
			log.error("Erro id cliente inválido.");
			throw new NegocioException(e.getMessage());			
		}
	}
	
	public Cliente buscarClientePorNumeroConta(final Integer numeroConta) {
		try {
			log.info("bucando cliente pelo número da conta");
			return clienteRepository.buscarClientePorNumeroConta(numeroConta);
		}catch (Exception e) {
			log.error("Erro número conta inválido.");
			throw new NegocioException(e.getMessage());			
		}
	}
}