# TaskFlow API

---

## Descrição da aplicação
- Aplicação backend desenvolvida com **Spring Boot** e **Spring Data JPA**, utilizando serviço **AWS RDS - MySQL** para persistência de dados. 
- A aplicação gerencia projetos e tarefas, permitindo realizar operações como criação, busca, atualização, deleção e geração de relatórios. 
- A API também oferece uma interface de documentação interativa via Swagger para facilitar o consumo e a visualização das operações disponíveis.

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
- **`src/main/java/hugolini.taskflowapi/controller/`**:  Controladores REST responsáveis por expor as APIs da aplicação.
- **`src/main/java/hugolini.taskflowapi/dto/`**: Objetos de transferência de dados para **projetos, tarefas e tarefas por status**.
- **`src/main/java/hugolini.taskflowapi/enums/`**:  Contém valores fixos de status de tarefas. 
- **`src/main/java/hugolini.taskflowapi/exceptions/`**: Exceções personalizadas.
- **`src/main/java/hugolini.taskflowapi/model/`**: Contém as entidades de **projeto** e **tarefas**.
- **`src/main/java/hugolini.taskflowapi/repository/`**: Interface para persistência de dados que conectam a aplicação com o banco de dados **MySQL**.
- **`src/main/java/hugolini.taskflowapi/service/`**: Lógica de négocios.

---

### Outros Arquivos

- **`pom.xml`**: Arquivo de configuração do **Maven**, que define as dependências, plugins e outras configurações do projeto.
- **`application.properties`**: Arquivo para armazenar propriedades de escopo da aplicação.

---

## Configuração de Propriedades da Aplicação

- `spring.application.name=taskflow-api`: Nome da aplicação
- `spring.datasource.url=jdbc:mysql://database-1.ch6e888y67e2.us-east-1.rds.amazonaws.com:3306/database-1`: Configurações de conexão com o banco de dados utilizando URL de conexão com o banco de dados MySQL hospedado no serviço AWS RDS.
- `spring.datasource.username=admin`: Nome de usuário para autenticação no banco de dados.
- `spring.datasource.password=senha`: Senha para autenticação no banco de dados.
- `spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver`: Driver JDBC utilizado para conexão com o banco MySQL.

- `spring.jpa.hibernate.ddl-auto=none`: Define que nenhuma ação será realizada automaticamente no esquema do banco de dados (criação/alteração de tabelas).
- `spring.jpa.show-sql=true`: Habilita a exibição das consultas SQL geradas pelo Hibernate no console.
- `spring.jpa.properties.hibernate.format_sql=true`: Formata as consultas SQL geradas para facilitar a leitura.

- `spring.datasource.hikari.maximum-pool-size=10`: Define o número máximo de conexões no pool de conexões HikariCP.
- `spring.datasource.hikari.pool-name=HikariCP`: Nome do pool de conexões configurado.

- `spring.jpa.open-in-view=false`: Desabilita a estratégia "open-in-view" para evitar problemas de desempenho e vazamento de recursos.
- `spring.jpa.properties.hibernate.use_sql_comments=true`: Habilita comentários nas consultas SQL geradas pelo Hibernate para maior clareza.
- `spring.jpa.properties.hibernate.cache.use_second_level_cache=false`: Desabilita o cache de segundo nível do Hibernate.
- `spring.jpa.properties.hibernate.cache.use_query_cache=false`: Desabilita o cache de consultas do Hibernate.

---

## Requisitos
- **Java 17+**: A aplicação é desenvolvida em Java e requer o Java 17 ou superior.
- **Maven**: Gerenciamento de dependências. 
- **Spring Boot 3.4** A aplicação é desenvolvida com framework e requer verão 3.4 ou superior.
- **Spring Data JPA**: Persistencia e acesso de dados.
- **Swagger (OpenAPI 3.0)**: Descrição, consumo e visualização da API.
- **Banco de Dados MySQL**: Banco de dados versão 8.0 ou superior. 
- **Acesso à AWS**: A aplicação depende de um banco de dados RDS - MySQL chamado `database-1` para armazenar os dados.

---

## Swagger - Documentação Interativa

A aplicação fornece uma interface interativa de documentação e testes para as APIs utilizando o **Swagger**.

### **Acesso ao Swagger**
- O Swagger UI está disponível no endpoint:  
  **`http://localhost:8080/swagger-ui/index.html`** (em ambiente local).

### **Funcionalidades Disponíveis**
No Swagger, é possível:
- Visualizar todas as rotas da API.
- Testar requisições diretamente pelo navegador.
- Ver os parâmetros esperados, exemplos de respostas e códigos HTTP.



