package com.frglucas.crudspringboot.model.services.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EntityNotFoundExceptionTest {

	@Test
	void shouldThrowException1() {
		Throwable exception = assertThrows(EntityNotFoundException.class, () -> {
			throw new EntityNotFoundException("ID not found");
		});
		assertEquals(exception.getMessage(), "ID not found");
	}
}
