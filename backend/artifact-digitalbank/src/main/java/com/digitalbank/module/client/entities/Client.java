package com.digitalbank.module.client.entities;

import com.digitalbank.module.client.entities.enums.DocType;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name= "doc_type", nullable = false, columnDefinition = "doc_type_options default 'cpf'")
    private DocType doc_type;

    @Column(nullable = false)
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
}
