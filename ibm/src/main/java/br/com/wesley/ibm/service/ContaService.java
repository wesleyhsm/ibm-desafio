package br.com.wesley.ibm.service;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.wesley.ibm.entity.Conta;
import br.com.wesley.ibm.exceptionhandler.NegocioException;
import br.com.wesley.ibm.repository.ContaRepository;
import jakarta.annotation.Resource;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ContaService {

	@Resource
	private ContaRepository contaRepository;
			
	public Conta salvar(Conta conta) {
		return contaRepository.save(conta);
	}
				
	public Conta criandoNovaConta(final Integer numero) {
		try {
			final Conta conta = Conta.builder()
					.numero(numero)
					.saldo(new BigDecimal(0))
					.dataAtualizacao(new Date())				
					.build();
			
			return salvar(conta);
		}catch (Exception e) {
			log.error("Erro ao salvar conta.");
			throw new NegocioException(e.getMessage());			
		}	
	}
}
