# TaskFlow API

---

## Descrição da aplicação
Esta aplicação backend desenvolvida com **Spring Boot** e **Spring Data JPA**, utilizando serviço **AWS RDS - MySQL**, **Swagger** e outras tecnologias relacionadas,
permite gerenciar um sistema de projetos e tarefas, permitindo criar, buscar, atualizar e deletar projetos e tarefas associadas.
---

## Principais Funcionalidades
- **Criar projetos e tarefas**: A aplicação cria os projetos e tarefas no banco de dados AWS RDS - MySQL.
- **Buscar projetos**: A busca é realizada com paginação através do ID do projeto e retorna o mesmo e suas respectivas tarefas (quando existir).
- **Atualizar o status das tarefas**: Tarefa é criada com status por padrão "PENDENTE", podendo ser atualizada pelo ID para "EM_ANDAMENTO", "CONCLUIDA" ou "PENDENTE" (caso necessário).
- **Deletar projetos**: A deleção de um projeto e de todas as tarefas associadas a ele. 
- **Relatório de contagem de tarefas**: É feito através dos status das tarefas presentes em um projeto.
- **Buscar projeto pro nome**: Filtro de busca por nome completo ou partes iniciais do primeiro nome.

---

## Estrutura do Projeto
A estrutura do projeto é organizada de forma modular para separar diferentes responsabilidades e facilitar a manutenção e escalabilidade da aplicação:

---

### Diretórios e Arquivos

- **`src/main/java/hugolini.taskflowapi/annotations/`**: Contém anotações customizadas (Swagger) relacionadas aos processos de **projeto** e **tarefas**.
- **`src/main/java/hugolini.taskflowapi/controller/`**:  Controladores REST 
- **`src/main/java/hugolini.taskflowapi/dto/`**: Objetos de transferência de dados para **projetos, tarefas e tarefas por status**.
- **`src/main/java/hugolini.taskflowapi/enums/`**:  Contém valores fixos de status de tarefas. 
- **`src/main/java/hugolini.taskflowapi/exceptions/`**: Exceções personalizadas.
- **`src/main/java/hugolini.taskflowapi/model/`**: Contém as entidades de **projeto** e **tarefas**.
- **`src/main/java/hugolini.taskflowapi/repository/`**: Interface para persistência de dados.
- **`src/main/java/hugolini.taskflowapi/service/`**: Lógica de négocios

---

### Outros Arquivos

- **`pom.xml`**: Arquivo de configuração do **Maven**, que define as dependências, plugins e outras configurações do projeto.
- **`application.properties`**: Arquivo para armazenar propriedades de escopo da aplicação.

---

## Requisitos
- **Java 17+**: A aplicação é desenvolvida em Java e requer o Java 17 ou superior.
- **Maven**: Gerenciamento de dependências. 
- **Spring Boot 2.7+** A aplicação é desenvolvida com framework e requer verão 2.7 ou superior.
- **Spring Data JPA**: Persistencia e acesso de dados.
- **Swagger (OpenAPI 3.0)**: Descrição, consumo e visualização da API.
- **Banco de Dados MySQL**: Banco de dados versão 8.0 ou superior. 
- **Acesso à AWS**: A aplicação depende de um banco de dados RDS - MySQL chamado `database-1` para armazenar os dados.



