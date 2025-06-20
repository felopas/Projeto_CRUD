Agenda de Contatos com Java e JDBC
📖 Sobre o Projeto
Este projeto é uma aplicação de console desenvolvida como parte da disciplina de Programação Orientada a Objetos em Java (ARA0075). O objetivo principal é demonstrar a aplicação prática dos conceitos de persistência de dados utilizando a API JDBC (Java Database Connectivity) para realizar as quatro operações básicas (CRUD - Create, Read, Update, Delete) em uma agenda de contatos.

A aplicação é estruturada seguindo o padrão arquitetural MVC (Model-View-Controller) para garantir a separação de responsabilidades e a organização do código.

---

🛠️ Tecnologias Utilizadas
Linguagem: Java 11 (ou superior)

Banco de Dados: PostgreSQL

Conectividade: JDBC Driver para PostgreSQL

Gerenciamento de Banco: DBeaver

IDE de Desenvolvimento: IntelliJ IDEA

---

⚙️ Configuração e Instalação
Siga os passos abaixo para configurar e executar o projeto em sua máquina local.

PostgreSQL: Tenha uma instância do PostgreSQL rodando.

IDE Java: Eclipse, IntelliJ IDEA ou outra de sua preferência.

. Configuração do Banco de Dados
Abra o DBeaver ou o pgAdmin e crie um novo banco de dados chamado agenda_db.

Execute o seguinte script SQL para criar as tabelas necessárias:

-- Cria a tabela para armazenar os contatos
CREATE TABLE contato (
    id_contato SERIAL PRIMARY KEY,
    nome_contato VARCHAR(100) NOT NULL
);

-- Cria a tabela para armazenar os telefones
CREATE TABLE telefone (
    id_telefone SERIAL PRIMARY KEY,
    id_contato INT NOT NULL,
    numero_telefone VARCHAR(20) NOT NULL,
    whatsapp BOOLEAN,
    telegram BOOLEAN,
    CONSTRAINT fk_contato
      FOREIGN KEY(id_contato)
	  REFERENCES contato(id_contato)
);

. Importe o projeto na sua IDE Java.

Adicione o Driver JDBC do PostgreSQL ao seu projeto.

altere a senha do banco de dados para a senha que você configurou:

// Altere a senha aqui
private static final String PASSWORD = "sua_senha_aqui";

---

▶️ Como Usar
Após configurar o projeto, encontre a classe Main.java no pacote br.com.agenda.view.

Execute o método main() desta classe.

O menu interativo será exibido no console, permitindo que você execute as operações de CRUD:
Cadastrar um novo contato.
Listar todos os contatos.
Atualizar o nome de um contato existente.
Deletar um contato pelo seu ID.


---
🏛️ Estrutura do Projeto
O código está organizado da seguinte forma:

br.com.agenda.factory: Contém a classe ConnectionFactory, responsável por criar e gerenciar as conexões com o banco de dados.

Contato.java: POJO (Plain Old Java Object) que representa a entidade Contato.

ContatoDAO.java: DAO (Data Access Object) que encapsula toda a lógica de acesso aos dados (operações CRUD).

br.com.agenda.view: Contém a classe Main, que serve como a interface do usuário (View) e o ponto de entrada da aplicação.
