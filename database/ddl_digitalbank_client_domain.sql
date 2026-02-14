
-- Projeto Integrador - Digital Bank
-- Script DDL - Domínio de Clientes
-- Autora: Valéria Durães Cruz
-- Data: 2026-02


-- DDL Data Definition Language

-- 1º Create the Database
create database digitalbank;

-- 2º Create the tables
create type doc_type_options as enum ('cpf', 'cnpj', 'passport', 'cnh', 'rg');

create table client(
	id serial primary key,
	name varchar(255) not null,
	doc_type doc_type_options default 'cpf'::doc_type_options not null,
	doc_number varchar(100) unique not null,
	birth_date date not null,
	email varchar(255) unique not null,
	created_at timestamp with time zone not null default now(),
	updated_at timestamp with time zone not null default now(),
	deleted_at timestamp with time zone null
);

create table client_phone(
	id serial primary key,
	phone varchar(30) not null,
	country_code varchar(10) not null,
	created_at timestamp with time zone not null default now(),
	updated_at timestamp with time zone not null default now(),
	deleted_at timestamp with time zone null,
	client_id integer not null,
	constraint fk_client_client_phone foreign key (client_id) references client(id)
);

create table address(
	id serial primary key,
	street varchar(255) not null,
	city varchar(100) not null,
	state varchar(30) not null,
	country varchar(100) not null,
	cep varchar(20) not null check(CHAR_LENGTH(cep) >= 8)
);

create table client_address(
	id serial primary key,
	type varchar(100) not null,
	number varchar(20) not null,
	complement varchar(255),
	created_at timestamp with time zone not null default now(),
	updated_at timestamp with time zone not null default now(),
	deleted_at timestamp with time zone null,
	client_id integer not null,
	address_id integer not null,
	constraint fk_client_address_client foreign key (client_id) references client(id),
	constraint fk_client_address_address foreign key (address_id) references address(id)
);

-- 3º Fiz uma atualização na tabela client incluindo um campo com ativo/inativo
create type client_status as enum ('active', 'inactive');

alter table client add column status client_status default 'active';







