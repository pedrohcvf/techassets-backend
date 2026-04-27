# 🏢 TechAssets — Backend

> API RESTful para gerenciamento de patrimônio e estoque de startups de tecnologia, tudo em um só lugar.

---

## 📌 Sobre o Projeto

O **TechAssets** é um sistema interno desenvolvido com Java e Spring Boot para startups de TI que precisam organizar seus ativos e suprimentos de forma centralizada e eficiente. A API oferece dois módulos principais:

- 📦 **Módulo Estoque** — Controle de produtos e movimentações de entrada e saída
- 🖥️ **Módulo Patrimônio** *(em desenvolvimento)* — Gestão de ativos físicos da empresa

---

## ✨ Funcionalidades

### 📦 Estoque
- ✅ Cadastro e listagem de produtos
- ✅ Busca de produto por ID
- ✅ Atualização e remoção de produtos
- ✅ Registro de movimentações (entrada/saída)
- ✅ Validação de estoque na saída (regra de negócio)
- ✅ Cálculo automático de estoque disponível

### 🖥️ Patrimônio — Itens
- ✅ Cadastro e listagem de itens de patrimônio
- ✅ Busca de item por ID
- ✅ Atualização e remoção de itens
- ✅ Filtro por colaborador responsável
- ✅ Filtro por status do item (Alocado, Disponível, Manutenção, Baixado)
- ✅ Vinculação de item a colaborador

### 👥 Patrimônio — Colaboradores
- ✅ Cadastro e listagem de colaboradores
- ✅ Busca de colaborador por ID
- ✅ Atualização e remoção de colaboradores
- ✅ Controle de status ativo/inativo


---

## 🛠️ Tecnologias Utilizadas

| Tecnologia       | Descrição                              |
|------------------|----------------------------------------|
| Java 17          | Linguagem principal                    |
| Spring Boot 3    | Framework para criação da API REST     |
| Spring Data JPA  | Abstração de acesso a dados            |
| PostgreSQL       | Banco de dados relacional              |
| Maven            | Gerenciador de dependências            |
| Docker           | Containerização do banco de dados      |

---

## 📁 Estrutura do Projeto

```
src/main/java/com/techassets/techassets/
├── estoque/
│   ├── movimentacao/
│   │   ├── controller/
│   │   ├── dto/
│   │   ├── entity/
│   │   ├── enums/
│   │   ├── repository/
│   │   └── service/
│   └── produto/
│       ├── controller/
│       ├── dto/
│       ├── entity/
│       ├── repository/
│       └── service/
├── patrimonio/
│   ├── colaborador/
│   │   ├── controller/
│   │   ├── dto/
│   │   ├── entity/
│   │   ├── repository/
│   │   └── service/
│   └── item/
│       ├── controller/
│       ├── dto/
│       ├── entity/
│       ├── enums/
│       ├── repository/
│       └── service/
├── exception/
└── TechassetsApplication.java
```

---

## 📡 Endpoints

### 🛒 Produtos

| Método   | Endpoint          | Descrição                     |
|----------|-------------------|-------------------------------|
| `GET`    | `/produtos`       | Lista todos os produtos       |
| `GET`    | `/produtos/{id}`  | Busca um produto por ID       |
| `POST`   | `/produtos`       | Cadastra um novo produto      |
| `PUT`    | `/produtos/{id}`  | Atualiza um produto existente |
| `DELETE` | `/produtos/{id}`  | Remove um produto             |

### 🔄 Movimentações

| Método   | Endpoint             | Descrição                          |
|----------|----------------------|------------------------------------|
| `GET`    | `/movimentacoes`     | Lista todas as movimentações       |
| `GET`    | `/movimentacoes/{id}`| Busca uma movimentação por ID      |
| `POST`   | `/movimentacoes`     | Registra uma nova movimentação     |

### 🖥️ Itens de Patrimônio

| Método | Endpoint | Descrição |
|---|---|---|
| `GET` | `/itens` | Lista todos os itens |
| `GET` | `/itens/{id}` | Busca um item por ID |
| `GET` | `/itens/colaborador/{id}` | Lista itens por colaborador |
| `GET` | `/itens/status/{status}` | Lista itens por status |
| `POST` | `/itens` | Cadastra um novo item |
| `PUT` | `/itens/{id}` | Atualiza um item existente |
| `DELETE` | `/itens/{id}` | Remove um item |

### 👥 Colaboradores

| Método | Endpoint | Descrição |
|---|---|---|
| `GET` | `/colaboradores` | Lista todos os colaboradores |
| `GET` | `/colaboradores/{id}` | Busca um colaborador por ID |
| `POST` | `/colaboradores` | Cadastra um novo colaborador |
| `PUT` | `/colaboradores/{id}` | Atualiza um colaborador existente |
| `DELETE` | `/colaboradores/{id}` | Remove um colaborador |

---

---

## ⚙️ Configuração

Configure o arquivo `src/main/resources/application.properties` com suas credenciais do PostgreSQL:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/techassets
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 🚀 Como Rodar o Projeto

### Pré-requisitos
- Java 21 ou superior
- PostgreSQL instalado e rodando
- Maven instalado (ou usar o Maven Wrapper incluso)

### Passo a passo

**1️⃣ Clone o repositório**
```bash
git clone https://github.com/pedrohcvf/techassets-backend.git
cd techassets-backend
```

**2️⃣ Crie o banco de dados**
```sql
CREATE DATABASE techassets;
```

**3️⃣ Configure suas credenciais**

Edite o arquivo `src/main/resources/application.properties` com seu usuário e senha do PostgreSQL.

**4️⃣ Execute a aplicação**

Com Maven Wrapper:
```bash
./mvnw spring-boot:run
```

Ou com Maven instalado:
```bash
mvn spring-boot:run
```

**5️⃣ Acesse a API**
```
http://localhost:8080
```

---

## 📦 Exemplos de Requisição

**POST** `/produtos` — Cadastrar um produto:
```json
{
  "nome": "Teclado Mecânico",
  "descricao": "Teclado mecânico switch red, ABNT2",
  "quantidade": 10,
  "preco": 299.90
}
```

**Resposta** `201 Created`:
```json
{
  "id": 1,
  "nome": "Teclado Mecânico",
  "descricao": "Teclado mecânico switch red, ABNT2",
  "quantidade": 10,
  "preco": 299.90
}
```

---

**POST** `/movimentacoes` — Registrar uma movimentação de saída:
```json
{
  "produtoId": 1,
  "quantidade": 3,
  "tipo": "SAIDA"
}
```

**Resposta** `201 Created`:
```json
{
  "id": 1,
  "produtoId": 1,
  "quantidade": 3,
  "tipo": "SAIDA",
  "dataMovimentacao": "2026-04-05T14:30:00"
}
```

---

**POST** `/itens` — Cadastrar um item de patrimônio:
```json
{
  "nome": "Notebook Dell XPS 15",
  "numeroSerie": "SN-001-DELL",
  "categoria": "Hardware",
  "colaboradorId": 1,
  "statusItem": "ALOCADO",
  "fornecedor": "Dell"
}
```

**Resposta** `201 Created`:
```json
{
  "id": 1,
  "nome": "Notebook Dell XPS 15",
  "numeroSerie": "SN-001-DELL",
  "categoria": "Hardware",
  "colaborador": "Carlos Mendes",
  "statusItem": "ALOCADO",
  "fornecedor": "Dell"
}
```

---

## 🔗 Repositório do Frontend

Este backend é consumido pelo [TechAssets Frontend](https://github.com/pedrohcvf/techassets-frontend) — desenvolvido com React e TypeScript.

---

## 👤 Autor

**Pedro Carvalho**

[![GitHub](https://img.shields.io/badge/GitHub-pedrohcvf-181717?style=flat&logo=github)](https://github.com/pedrohcvf/techassets-backend)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-pcarvalhof-0A66C2?style=flat&logo=linkedin)](https://linkedin.com/in/pcarvalhof)
