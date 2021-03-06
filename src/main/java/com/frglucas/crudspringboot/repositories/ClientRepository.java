package com.frglucas.crudspringboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.frglucas.crudspringboot.model.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
