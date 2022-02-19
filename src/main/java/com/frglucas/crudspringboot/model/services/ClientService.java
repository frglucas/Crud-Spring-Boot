package com.frglucas.crudspringboot.model.services;

import java.util.List;
import java.util.stream.Collectors;

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
	
	public ClientDTO createClient(Client client) {
		client.setId(null);
		clientRepository.save(client);
		return new ClientDTO(client);
	}
	
	public ClientDTO saveClient(Client client) {
		if(client.getId() != null && clientRepository.existsById(client.getId()) == true) {
			clientRepository.save(client);
			return new ClientDTO(client);
		} else throw new EntityNotFoundException("Client not found");
	}
	
	public List<ClientDTO> findAll() {
		List<Client> listClient = clientRepository.findAll();
		List<ClientDTO> listClientDto = listClient.stream()
				.map(c -> new ClientDTO(c))
				.collect(Collectors.toList());
		return listClientDto;
	}
	
	public ClientDTO findById(Long id) {
		return new ClientDTO(clientRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("ID not found " + id)));
	}
	
	public void deleteById(Long id) {
		if(clientRepository.existsById(id) == true) {
			clientRepository.deleteById(id);
		} else throw new EntityNotFoundException("ID not found " + id);
	}
}
