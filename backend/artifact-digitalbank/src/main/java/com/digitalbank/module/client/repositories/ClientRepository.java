package com.digitalbank.module.client.repositories;

import com.digitalbank.module.client.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
