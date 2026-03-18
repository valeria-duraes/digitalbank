package com.digitalbank.module.client.controllers;

import com.digitalbank.client.entities.Client;
import com.digitalbank.client.services.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ClientController {
    private final ClientService service;

    // Injeção de dependência via construtor
    public ClientController(ClientService clientService){
        this.service = clientService;
    }

    // Create
    @PostMapping("/client")
    public ResponseEntity<Client> createClient(@RequestBody Client client){
        Client newClient = service.createClient(client);
        return ResponseEntity.ok(newClient);
    }

    // Get by id
    @GetMapping("/client/{clientId}")
    public ResponseEntity<Client> getClientById(@PathVariable Long clientId){
        Client client = service.getClientById(clientId);
        return ResponseEntity.ok(client);
    }

    // Get by cpf
    @GetMapping("/client/{clientDoc}")
    public ResponseEntity<Optional<Client>> getClientByCpf(@PathVariable String clientDoc){
        Optional<Client> client = service.getClientByDocNumber(clientDoc);
        return ResponseEntity.ok(client);
    }

    // Get all clients
    @GetMapping("/clients")
    public ResponseEntity<List<Client>> getAllClients(){
        List<Client> clients = Collections.singletonList(service.getAllClients());
        return ResponseEntity.ok(clients);
    }

    // Delete

    // Update

}


