package com.frglucas.crudspringboot.model.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.frglucas.crudspringboot.model.dto.ClientDTO;
import com.frglucas.crudspringboot.model.entities.Client;
import com.frglucas.crudspringboot.model.services.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@PostMapping
	public ResponseEntity<Client> createClient(@RequestBody @Valid Client client) {
		return ResponseEntity.ok().body(clientService.createClient(client));
	}

	@PutMapping
	public ResponseEntity<Client> saveClient(@Valid Client client) {
		return ResponseEntity.ok().body(clientService.saveClient(client));
	}
	
	@GetMapping
	public ResponseEntity<List<Client>> findAll(){
		return ResponseEntity.ok().body(clientService.findAll());
	}
	
	@GetMapping("/search")
	public ResponseEntity<ClientDTO> findById(@RequestParam(name = "id") Long id){
		return ResponseEntity.ok().body(clientService.findById(id));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteById(@RequestParam(name = "id") Long id) {
		clientService.deleteById(id);
		return ResponseEntity.ok().body("Client deleted");
	}
}
