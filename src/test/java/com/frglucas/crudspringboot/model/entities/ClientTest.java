package com.frglucas.crudspringboot.model.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClientTest {

	

	@Test
	void shouldCreateNewClient() {
		Client client = new Client("Carlos", "84837172806", "carlos@email.com", "51987654321");
		assertEquals(client.getName(), "Carlos");
		assertEquals(client.getCpf(), "84837172806");
		assertEquals(client.getEmail(), "carlos@email.com");
		assertEquals(client.getPhoneNumber(), "51987654321");
	}
	
	@Test
	void shouldReturnId() {
		Client client = new Client();
		assertNull(client.getId());
	}
	
	@Test
	void shouldReturnId1() {
		Client client = new Client();
		client.setId(1L);
		assertTrue(client.getId().equals(1L));;
	}
	
	@Test
	void shouldReturnId2() {
		Client client = new Client();
		client.setId(1L);
		assertFalse(client.getId().equals(2L));
	}
	
	@Test
	void shouldReturnName() {
		Client client = new Client();
		assertNull(client.getName());
	}
	
	@Test
	void shouldReturnName1() {
		Client client = new Client();
		client.setName("Carlos");
		assertTrue(client.getName().equals("Carlos"));
	}
	
	@Test
	void shouldReturnName2() {
		Client client = new Client();
		client.setName("Carlos");
		assertFalse(client.getName().equals("Roberto"));
	}
	
	@Test
	void shouldReturnCpf() {
		Client client = new Client();
		assertNull(client.getCpf());
	}
	
	@Test
	void shouldReturnCpf1() {
		Client client = new Client();
		client.setCpf("82353258026");
		assertTrue(client.getCpf().equals("82353258026"));
	}
	
	@Test
	void shouldReturnCpf2() {
		Client client = new Client();
		client.setCpf("82353258026");
		assertFalse(client.getCpf().equals("63403318826"));
	}
	
	@Test
	void shouldReturnEmail() {
		Client client = new Client();
		assertNull(client.getEmail());
	}
	
	@Test
	void shouldReturnEmail1() {
		Client client = new Client();
		client.setEmail("carlos@email.com");
		assertTrue(client.getEmail().equals("carlos@email.com"));
	}
	
	@Test
	void shouldReturnEmail2() {
		Client client = new Client();
		client.setEmail("carlos@email.com");
		assertFalse(client.getEmail().equals("roberto@email.com"));
	}
	
	@Test
	void shouldReturnPhoneNumber() {
		Client client = new Client();
		assertNull(client.getPhoneNumber());
	}
	
	@Test
	void shouldReturnPhoneNumber1() {
		Client client = new Client();
		client.setPhoneNumber("51987654321");
		assertTrue(client.getPhoneNumber().equals("51987654321"));
	}
	
	@Test
	void shouldReturnPhoneNumber2() {
		Client client = new Client();
		client.setPhoneNumber("51987654321");
		assertFalse(client.getPhoneNumber().equals("51912345678"));
	}
	
	@Test
	void shouldReturnDeleted() {
		Client client = new Client();
		assertFalse(client.isDeleted());
	}
	
	@Test
	void shouldReturnDeleted1() {
		Client client = new Client();
		client.setDeleted(true);
		assertTrue(client.isDeleted());
	}
}
