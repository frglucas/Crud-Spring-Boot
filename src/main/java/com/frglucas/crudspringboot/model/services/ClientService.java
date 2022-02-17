package com.frglucas.crudspringboot.model.services;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frglucas.crudspringboot.model.dto.ClientDTO;
import com.frglucas.crudspringboot.model.entities.Client;
import com.frglucas.crudspringboot.model.services.exceptions.EntityNotFoundException;
import com.frglucas.crudspringboot.repositories.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	public Client createClient(Client client) {
		return clientRepository.save(client);
	}
	
	public Client saveClient(Client client) {
		if(client.getId() != null && clientRepository.existsById(client.getId()) == true) {
			return clientRepository.save(client);
		} else throw new EntityNotFoundException("Client not found");
	}
	
	public List<Client> findAll() {
		return new ArrayList<>(clientRepository.findAll());
	}
	
	public ClientDTO findById(@Valid Long id) {
		return new ClientDTO(clientRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("ID not found " + id)));
	}
	
	public void deleteById(@Valid Long id) {
		if(clientRepository.existsById(id) == true) {
			clientRepository.deleteById(id);
		} else throw new EntityNotFoundException("ID not found " + id);
	}
}
