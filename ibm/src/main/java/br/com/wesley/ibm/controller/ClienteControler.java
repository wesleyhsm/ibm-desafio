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
import br.com.wesley.ibm.dto.ClienteResponseDto;
import br.com.wesley.ibm.entity.Cliente;
import br.com.wesley.ibm.service.ClienteService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;

@RestController("Cliente")
@RequestMapping("/v1/cliente")
public class ClienteControler {

	@Resource
	private ClienteService clienteService;
	
	@PostMapping
    public ResponseEntity<ClienteDto> cadastroCliente(@RequestBody @Valid ClienteDto clienteDto) {
        final Integer id = clienteService.cadastro(clienteDto);        
        return ResponseEntity.created(URI.create("/v1/cliente/" + id.toString())).build();
    }
    
    @GetMapping
    public ResponseEntity<List<ClienteResponseDto>> bustarTodosCliente() {
    	final List<ClienteResponseDto> clienteResponseDtos = clienteService.buscarTodos();
        return ResponseEntity.ok(clienteResponseDtos);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDto> buscarClientePorId(@PathVariable("id") Integer id) {
    	final ClienteResponseDto clienteResponseDto = clienteService.buscarClientePorId(id);

        if (clienteResponseDto != null) {
            return ResponseEntity.ok(clienteResponseDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/{numeroConta}")
    public ResponseEntity<Cliente> buscarSaldoConta(@PathVariable("numeroConta") Integer numeroConta) {
    	final Cliente cliente = clienteService.buscarClientePorNumeroConta(numeroConta);

        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}