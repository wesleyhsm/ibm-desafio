package br.com.wesley.ibm.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContaDto {
			
	private Integer numero;
	private BigDecimal saldo;
	private Date dataAtualizacao;	
}