package com.frglucas.crudspringboot.model.services.exceptions;

public class ClientsNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ClientsNotFoundException(String msg) {
		super(msg);
	}
}
