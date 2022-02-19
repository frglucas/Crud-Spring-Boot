package com.frglucas.crudspringboot.model.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.frglucas.crudspringboot.model.dto.ClientDTO;
import com.frglucas.crudspringboot.model.entities.Client;
import com.frglucas.crudspringboot.model.services.exceptions.EntityNotFoundException;
import com.frglucas.crudspringboot.repositories.ClientRepository;

@SpringBootTest
public class ClientServiceTest {

	@MockBean
	private ClientRepository clientRepository;
	
	@Autowired
	private ClientService clientService;
	
	@Test
	void shouldCreateNewClient() {
		Client client = new Client("Carlos", "84837172806", "carlos@email.com", "51987654321");
		ClientDTO clientDTO = clientService.createClient(client);
		assertTrue(clientDTO.getName().equals("Carlos"));
		assertTrue(clientDTO.getEmail().equals(client.getEmail()));
		assertTrue(clientDTO.getPhoneNumber().equals(client.getPhoneNumber()));
	}
			
	@Test
	void shouldCreateNewClient1() {
		Client client = new Client("Carlos", "84837172806", "carlos@email.com", "51987654321");
		ClientDTO clientDTO = clientService.createClient(client);
		assertFalse(clientDTO.getName().equals("Roberto"));
		assertFalse(clientDTO.getEmail().equals("roberto@email.com"));
		assertFalse(clientDTO.getPhoneNumber().equals("51912345678"));
	}
	

	@Test
	void shouldCreateNewClient2() {
		Client client = new Client();
		ClientDTO clientDTO = clientService.createClient(client);
		assertNull(clientDTO.getId());
		assertNull(clientDTO.getName());
		assertNull(clientDTO.getEmail());
		assertNull(clientDTO.getPhoneNumber());
	}
	
	@Test
	void shouldReturnAll() {
		List<ClientDTO> listDTO = clientService.findAll();
		assertTrue(listDTO.isEmpty());
	}
	
	@Test
	void shouldThrowException() {
		assertThrows(EntityNotFoundException.class, () -> clientService.findById(1L));
	}
	
	@Test
	void shouldThrowException2() {
		assertThrows(EntityNotFoundException.class, () -> clientService.deleteById(1L));
	}
}
