# Teste MaxSoft


---


---

- [Getting started](#getting-started)
    - [Introdução](#introdução)
    - [Build configuration](#build-configuration)
    - [Como baixar ? ](#como-baixar-e-rodar-este-projeto)
 

## Introdução

Gostaria de apresentar o projeto SumaxSoft desenvolvido para o teste tecnico para a empresa MaxSoft, que permite gerenciar os clientes e serviços prestados de uma empresa. Com ela, é possível realizar as seguintes operações:

* Criar, ler, atualizar e excluir clientes;
* Criar, ler serviços prestados;
* Associar um serviço prestado a um cliente.

Foi utilizado uma arquitetura REST e os métodos HTTP padrão 
(GET, POST, PUT e DELETE) para disponibilizar essas funcionalidades. 

O modelo de dados dessa API inclui dois tipos de recursos: clientes e serviços prestados. Cada cliente possui um ID único, nome, sobrenome, cpf, cidade, telefone e celular.  Já os serviços prestados possuem um ID único, uma descrião, um cliente associado, valor do serviço prestado e a data.

API  possui um relacionamento de entidade entre os recursos de clientes (clients) e serviços prestados (ServiceProvided).

Para garantir a qualidade dos dados, foi incluído validações e máscaras em alguns campos, como email e o CPF/CNPJ e validação em todos os demais campos. Além disso, foi utilizado o padrão REST e o framework Spring Boot para desenvolver a API de forma eficiente e seguindo os princípios SOLID.

Para facilitar o uso da API, também foi incluído paginação e filtros nas consultas através do método GET. Também foi versionado o código da aplicação no GitHub. Por fim, foi utilizado um banco de dados em memória para armazenar os dados(H2).

Alguns serviços que foi adicionado no projeto

* Sistema de cache
* Validação e máscaras para input
* Tratamento de Exceptions
* Foi feita a documentação da Api com Swagger.
para acessar a doc após baixar o projeto entrar no endereço http://localhost:8080/swagger-ui.html
previa da Documentação da API.
![image](https://user-images.githubusercontent.com/75391803/214849578-4e8409bd-2e91-4712-a6cc-3c19f0f4834d.png)


## Build configuration

Dependências

| Dependência               | Grupo                        | Artefato                                  | Versão | Escopo      | Opcional |
|---------------------------|-------------------------------|--------------------------------------------|--------|------------|----------|
| spring-boot-starter-data-jpa | org.springframework.boot    | spring-boot-starter-data-jpa               |        |            |          |
| spring-boot-starter-web     | org.springframework.boot    | spring-boot-starter-web                   |        |            |          |
| spring-boot-devtools        | org.springframework.boot    | spring-boot-devtools                      |        | runtime    | true     |
| h2                         | com.h2database              | h2                                        |        |            |          |
| modelmapper                 | org.modelmapper             | modelmapper                               | 3.1.0  |            |          |
| spring-boot-starter-validation | org.springframework.boot | spring-boot-starter-validation            |        |            |          |
| springfox-boot-starter     | io.springfox                | springfox-boot-starter                    | 3.0.0  |            |          |
| javax.servlet-api          | javax.servlet               | javax.servlet-api                         | 4.0.1  | provided   |          |
| validation-api             | javax.validation           | validation-api                            | 2.0.1.Final |          |          |
| spring-boot-starter-cache  | org.springframework.boot    | spring-boot-starter-cache                 |          |            |          |

## Como baixar e rodar este projeto

Para baixar e rodar o projeto Java, siga os passos abaixo:

1. Faça o clone do projeto no GitHub:

`git@github.com:CarolinaCedro/SumaxSoft.git`

2. Entre na pasta do projeto:

``cd SumaxSoft``

3. Execute o comando abaixo para baixar as dependências do Maven:

``mvn clean install``

4. Execute o projeto com o comando abaixo:

``mvn spring-boot:run``

5. Acesse a aplicação em seu navegador pelo endereço: `http://localhost:8080`



