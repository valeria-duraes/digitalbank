package com.digitalbank.client.entities;

import com.digitalbank.account.entities.Account;
import com.digitalbank.client.entities.enums.ClientStatus;
import com.digitalbank.client.entities.enums.DocType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "client")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name= "doc_type", nullable = false)
    private DocType docType = DocType.cpf;

    @Column(name = "doc_number", nullable = false, unique = true)
    private String docNumber;

    @Column(name= "birth_date", nullable = false)
    private LocalDateTime birthDate;

    @Column(nullable = false)
    private String email;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ClientStatus status = ClientStatus.active;

    @OneToMany(mappedBy = "client")
    private List<Account> accounts;
}
