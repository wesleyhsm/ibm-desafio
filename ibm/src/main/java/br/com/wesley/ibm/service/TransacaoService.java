package br.com.wesley.ibm.service;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.wesley.ibm.dto.TransacaoDto;
import br.com.wesley.ibm.entity.Cliente;
import br.com.wesley.ibm.entity.Transacao;
import br.com.wesley.ibm.enuns.TipoTransacao;
import br.com.wesley.ibm.exceptionhandler.NegocioException;
import br.com.wesley.ibm.repository.TransacaoRepository;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class TransacaoService {

	@Resource
	private TransacaoRepository transacaoRepository;
	
	@Resource
	private ClienteService clienteService;
	
	@Resource
	private ContaService contaService;
	
	private Transacao salvar(Transacao transacao) {
		return transacaoRepository.save(transacao);
	}
	
	@Transactional
	public int novaTransacao(TransacaoDto transacaoDto) {
		try {
			final BigDecimal zero = new BigDecimal(0);
					
			Cliente cliente = clienteService.buscarClientePorNumeroConta(transacaoDto.getNumeroConta());
			if(cliente == null) {
				log.error("Erro cliente não encontrado");
				throw new NegocioException("Erro cliente não encontrado");
			}
			
			log.info("Validando tipo da transação");
			if(transacaoDto.getTipo() == TipoTransacao.CREDITO) {
				log.info("transação tipo crédito");			
				
				if(transacaoDto.getValor().compareTo(zero) == 1) {
					log.info("transação valor: {} maior que 0", transacaoDto.getValor());
					
					final BigDecimal valorTotal = cliente.getConta().getSaldo().add(transacaoDto.getValor());
					
					cliente.getConta().setSaldo(valorTotal);
					contaService.salvar(cliente.getConta());
					
					final Transacao transacao = Transacao.builder()
												.tipo(transacaoDto.getTipo())
												.data(new Date())
												.valor(transacaoDto.getValor())
												.cliente(cliente)
												.build();
									
					log.info("transação salva com sucesso");
					return salvar(transacao).getId();
					
				}else {
					log.error("Erro valor da transação inválida");
					throw new NegocioException("Erro valor da transação inválida");
				}
				
			}else if(transacaoDto.getTipo() == TipoTransacao.DEBITO) {
				log.info("transação tipo débito");
				
				if(cliente.getConta().getSaldo().compareTo(transacaoDto.getValor()) == 0 
						|| cliente.getConta().getSaldo().compareTo(transacaoDto.getValor()) == 1) {
					
					log.info("transação valor: {} maior que saldo: {}", transacaoDto.getValor(), cliente.getConta().getSaldo());
					final BigDecimal valorTotal = cliente.getConta().getSaldo().subtract(transacaoDto.getValor());
					
					cliente.getConta().setSaldo(valorTotal);
					contaService.salvar(cliente.getConta());
					
					final Transacao transacao = Transacao.builder()
												.tipo(transacaoDto.getTipo())
												.data(new Date())
												.valor(transacaoDto.getValor())
												.cliente(cliente)
												.build();
					
					log.info("transação salva com sucesso");
					return salvar(transacao).getId();
				}else {
					log.error("Erro saldo da transação inválida");
					throw new NegocioException("Erro saldo da transação inválida");
				}
			}else {
				log.error("Erro transação inválida");
				throw new NegocioException("Erro transação inválida");
			}	
		}catch (Exception e) {
			log.error("Erro transação inválida");
			throw new NegocioException(e.getMessage());			
		}
	}
}
