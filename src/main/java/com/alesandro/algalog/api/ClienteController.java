package com.alesandro.algalog.api;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.alesandro.algalog.domain.model.Cliente;
import com.alesandro.algalog.repository.ClienteRepository;

//@AllArgsConstructor
@RestController
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/clientes")
	public List<Cliente> listar() {
		
		return clienteRepository.findAll();
	
	}
	
	@GetMapping("/clientes/{clienteId}")
	public Cliente buscar(@PathVariable Long clienteId) {
		
		Optional <Cliente> cliente = clienteRepository.findById(clienteId);
		
		return cliente.orElse(null);
	
	}

}
