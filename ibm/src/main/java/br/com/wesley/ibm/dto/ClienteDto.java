package br.com.wesley.ibm.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDto {
		
	@NotBlank(message = "Nome é obrigatório.")
	private String nome;
	
	@NotNull(message = "Idade é obrigatório.")
	private Integer idade;
	
	@NotBlank(message = "E-mail é obrigatório.")
	@Email(message = "E-mail inválido")
	private String email;
	
	@NotNull(message = "Número da conta é obrigatório.")
	private Integer numeroConta;
}