package br.com.wesley.ibm.enuns;

import java.util.Arrays;
import java.util.List;

public enum TipoTransacao {
	CREDITO("Crédito"),
	DEBITO("Débito");
	
	private String descricao;
	
	TipoTransacao(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public List<TipoTransacao> getTransacoes (){
		return Arrays.asList(TipoTransacao.values());
	}
}