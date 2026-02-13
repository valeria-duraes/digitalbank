package com.digitalbank.client.repositories;

import com.digitalbank.client.entities.Client;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    boolean existsByDocNumber(String docNumber);

    Optional<Client> findByDocNumber(String docNumber);

}
