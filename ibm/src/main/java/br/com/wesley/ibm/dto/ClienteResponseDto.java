package br.com.wesley.ibm.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteResponseDto {
	
	private String nome;	
	private Integer idade;	
	private String email;
	private ContaDto Conta;
}