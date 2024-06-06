package br.com.wesley.ibm.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.wesley.ibm.dto.ClienteDto;
import br.com.wesley.ibm.dto.ClienteResponseDto;
import br.com.wesley.ibm.dto.ContaDto;
import br.com.wesley.ibm.entity.Cliente;
import br.com.wesley.ibm.entity.Conta;

@Component
public class ClienteMapper {

	public ClienteResponseDto toDto(Cliente cliente) {
		
		final ContaDto contaDto = ContaDto.builder()
				.dataAtualizacao(cliente.getConta().getDataAtualizacao())
				.numero(cliente.getConta().getNumero())
				.saldo(cliente.getConta().getSaldo())
				.build();
		
		final ClienteResponseDto clienteResponseDto = ClienteResponseDto.builder().nome(cliente.getNome()).idade(cliente.getIdade())
				.email(cliente.getEmail()).Conta(contaDto).build();
		
		return clienteResponseDto;
	}

	public List<ClienteResponseDto> listToDto(List<Cliente> clientes) {
		List<ClienteResponseDto> clienteResponseDtos = new ArrayList<ClienteResponseDto>();
		
		clientes.forEach(cliente -> {
			ClienteResponseDto clienteResponseDto = toDto(cliente);			
			clienteResponseDtos.add(clienteResponseDto);
		});

		return clienteResponseDtos;
	}

	public Cliente fromDto(ClienteDto clienteDto, Conta conta) {
		return Cliente.builder().nome(clienteDto.getNome()).idade(clienteDto.getIdade()).email(clienteDto.getEmail()).conta(conta).build();
	}
}