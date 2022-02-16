package com.frglucas.crudspringboot.model.services;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frglucas.crudspringboot.model.entities.Client;
import com.frglucas.crudspringboot.model.services.exceptions.ClientsNotFoundException;
import com.frglucas.crudspringboot.model.services.exceptions.EntityNotFoundException;
import com.frglucas.crudspringboot.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	public Client saveClient(@Valid Client client) {
		clientRepository.save(client);
		return client;
	}
	
	public List<Client> findAll() {
		if(clientRepository.count() > 0) {
			return new ArrayList<>(clientRepository.findAll());	
		} else throw new ClientsNotFoundException("Clients not found");
		
	}
	
	public Client findById(@Valid Long id) {
		return clientRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("ID not found " + id));
	}
	
	public void deleteById(@Valid Long id) {
		if(clientRepository.existsById(id) == true) {
			clientRepository.deleteById(id);
		} else throw new EntityNotFoundException("ID not found " + id);
	}
}
