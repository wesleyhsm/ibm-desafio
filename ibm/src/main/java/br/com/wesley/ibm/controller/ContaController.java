package br.com.wesley.ibm.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wesley.ibm.entity.Conta;
import br.com.wesley.ibm.service.ClienteService;
import br.com.wesley.ibm.service.ContaService;
import jakarta.annotation.Resource;

@RestController("Conta")
@RequestMapping("/v1/conta")
public class ContaController {

	@Resource
	private ContaService contaService;
	
	@Resource
	private ClienteService clienteService;
	
	@GetMapping("/{numero}")
    public ResponseEntity<Conta> buscarSaldoConta(@PathVariable("numero") Integer numero) {
    	final Conta conta = clienteService.buscarClientePorNumeroConta(numero).getConta();

        if (conta != null) {
            return ResponseEntity.ok(conta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
