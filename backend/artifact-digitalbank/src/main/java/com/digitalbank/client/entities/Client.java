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
    private DocType doc_type = DocType.cpf;

    @Column(nullable = false, unique = true)
    private String doc_number;

    @Column(nullable = false)
    private LocalDateTime birth_date;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private LocalDateTime created_at;

    @Column(nullable = false)
    private LocalDateTime updated_at;

    private LocalDateTime deleted_at;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ClientStatus status = ClientStatus.active;

    @OneToMany(mappedBy = "client")
    private List<Account> accounts;
}
