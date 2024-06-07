package br.com.wesley.ibm.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wesley.ibm.dto.ClienteDto;
import br.com.wesley.ibm.dto.TransacaoDto;
import br.com.wesley.ibm.entity.Transacao;
import br.com.wesley.ibm.enuns.TipoTransacao;
import br.com.wesley.ibm.service.TransacaoService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;

@RestController("Transação")
@RequestMapping("/v1/transacao")
public class TransacaoControler {

	@Resource
	private TransacaoService transacaoService;
	
	@PostMapping
    public ResponseEntity<ClienteDto> novaTransacao(@RequestBody @Valid TransacaoDto transacaoDto) {
        final Integer id = transacaoService.novaTransacao(transacaoDto);
        return ResponseEntity.created(URI.create("/v1/transacao/" + id.toString())).build();
    }
	
	@GetMapping("/{numeroConta}")
	public ResponseEntity<List<Transacao>> buscarTodasTransacoesDaConta(@PathVariable("numeroConta") Integer numeroConta){
		final List<Transacao> transacoes =transacaoService.buscarTodasTransacoesDaConta(numeroConta);
		return ResponseEntity.ok(transacoes);
	}
	
	@GetMapping("/tipo")
	public ResponseEntity<List<TipoTransacao>> buscarTipoTransacoes(){
		final List<TipoTransacao> tipoTransacoes =transacaoService.buscarTipoTransaoes();
		return ResponseEntity.ok(tipoTransacoes);
	}
}