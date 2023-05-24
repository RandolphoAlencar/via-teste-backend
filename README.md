// README.md
# VIA-TESTE-BACKEND

### Introduction
Projeto criado para teste pratico de backend da Via.


### Project Support Features
* CRUD básico de produtos 
* Controle de abastecimento de veículos


### Installation Guide
* Clone esse repositório (https://github.com/RandolphoAlencar/via-teste-backend.git).
* Rode o comando no terminal do Git Bash  "./mvnw spring-boot:run" na pasta do projeto.
* A aplicação está configurada para um banco de dados em memória (H2).

### Usage

* Conecte-se a Web API utilizando a porta 8080.



### API Endpoints
| HTTP Verbs | Endpoints | Action |
| --- 	| --- | --- |
| POST | /api/product | Cria um produto |
| GET | /api | Busca todos os produtos cadastrados |
| GET | /api/{id} | Busca o produto referente ao id do parâmetrô |
| PUT | /api/{id} | Atualiza o produto referente ao id do parâmetrô |
| DELETE | /api/{id} | Deleta o produto referente ao id do parâmetrô |



### Technologies Used
* [Spring Boot](https://spring.io) O Spring Boot é um framework open source usado para facilitar as configurações de uma aplicação. 
* [H2 Database](https://www.h2database.com/html/main.html) H2 é um sistema de gerenciamento de banco de dados relacional escrito em Java. Ele pode ser incorporado em aplicativos Java ou executado no modo cliente-servidor.

### Authors
* [Randolpho Alencar](https://github.com/RandolphoAlencar)


### License
This project is available for use under the MIT License.
