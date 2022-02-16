package com.frglucas.crudspringboot.model.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.frglucas.crudspringboot.model.entities.Client;
import com.frglucas.crudspringboot.model.services.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
	public ResponseEntity<Client> saveClient(Client client) {
		clientService.saveClient(client);
		return ResponseEntity.ok().body(client);
	}
	
	@GetMapping
	public ResponseEntity<List<Client>> findAll(){
		return ResponseEntity.ok().body(clientService.findAll());
	}
	
	@GetMapping("/search")
	public ResponseEntity<Client> findById(@RequestParam(name = "id") Long id){
		return ResponseEntity.ok().body(clientService.findById(id));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteById(@RequestParam(name = "id") Long id) {
		clientService.deleteById(id);
		return ResponseEntity.ok().body("Client deleted");
	}
}
