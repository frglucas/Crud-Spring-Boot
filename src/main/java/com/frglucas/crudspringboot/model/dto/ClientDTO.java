package com.frglucas.crudspringboot.model.dto;

import com.frglucas.crudspringboot.model.entities.Client;

public class ClientDTO {

	private Long id;
	private String name;
	private String email;
	private String phoneNumber;
	
	public ClientDTO() {
	}

	public ClientDTO(Long id, String name, String email, String phoneNumber) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public ClientDTO(Client client) {
		id = client.getId();
		name = client.getName();
		email = client.getEmail();
		phoneNumber = client.getPhoneNumber();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}
