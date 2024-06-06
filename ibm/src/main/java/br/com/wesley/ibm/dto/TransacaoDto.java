package br.com.wesley.ibm.dto;

import java.math.BigDecimal;

import br.com.wesley.ibm.enuns.TipoTransacao;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransacaoDto {

	@NotNull(message = "Número da conta é obrigatório.")
	private int numeroConta;
	
	@NotNull(message = "Tipo da transação é obrigatório.")
	private TipoTransacao tipo;
	
	@NotNull(message = "Valor da transação é obrigatório.")
	private BigDecimal valor;
}
