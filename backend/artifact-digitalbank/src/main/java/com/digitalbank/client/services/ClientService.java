package com.digitalbank.client.services;

import com.digitalbank.client.entities.Client;
import com.digitalbank.client.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;

    // Create
    public Client createClient(Client client){
        if(repository.existsByDocNumber(client.getDoc_number())){
            throw new RuntimeException("A client with this document number already exists!");
        }
        return repository.save(client);
    }

    // Get by id
    public Client getClientById(Long id){
        return repository.findById(id).orElseThrow(
                () -> new RuntimeException("Client not found with id:" + id));
    }

    // Get by cpf
    public Optional<Client> getClientByCpf(String docNumber){
        Optional<Client> cpf = repository.findByDocNumber(docNumber);

        if(cpf.isPresent()){
            return cpf;
        } else {
            throw new RuntimeException("No client was found for this id: " + docNumber);
        }
    }

    // Delete
    public void deleteClientById(Long id){
        repository.deleteById(id);
    }

    // Update
    public Client updateClientByCpf(String docNumber, Client updatedClient){
        Client existingClient = repository.findByDocNumber(docNumber).orElseThrow(
                () -> new RuntimeException("Client not found with document: " + docNumber));

        existingClient.setName(updatedClient.getName());
        existingClient.setDoc_type(updatedClient.getDoc_type());
        existingClient.setBirth_date(updatedClient.getBirth_date());
        existingClient.setEmail(updatedClient.getEmail());

        return repository.save(existingClient);
    }

}



// 🔹 1️⃣ Pode criar cliente sem documento?
//Mesmo sendo NOT NULL, o ideal é:
//Validar antes de salvar
//Retornar erro claro
//Não deixar estourar exceção de banco
//Porque exceção de banco vira erro 500.
//E banco digital não pode devolver 500 por validação simples.


