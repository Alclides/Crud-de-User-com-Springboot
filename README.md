# 🧑‍💻 Projeto CRUD de Usuários - Spring Boot

Este projeto é um exemplo de **CRUD (Create, Read, Update, Delete)** desenvolvido em **Spring Boot**.\
O objetivo é demonstrar como implementar operações básicas de cadastro, listagem, atualização e remoção de usuários em uma API RESTful.

---

## 🚀 Tecnologias utilizadas

- **Java 17+**
- **Spring Boot 3+**
- **Spring Data JPA**
- **Hibernate**
- **PostgreSQL** (pode trocar para MySQL ou outro banco relacional)
- **Maven**
- **Postman / Insomnia** (para testes da API)

---

## 📌 Funcionalidades

- **Criar usuário** → `POST /users`
- **Listar todos os usuários** → `GET /users`
- **Buscar usuário por ID** → `GET /users/{email}`
- **Atualizar usuário** → `PUT /users/{email}`
- **Deletar usuário** → `DELETE /users/{email}`

---

## 📂 Estrutura do Projeto

```
src/main/java/com/seuprojeto
 ┣ 📂 controller   # Camada responsável pelos endpoints da API
 ┣ 📂 model        # Entidades (User)
 ┣ 📂 repository   # Interfaces do Spring Data JPA
 ┣ 📂 service      # Regras de negócio
 ┗ 📜 Application  # Classe principal do Spring Boot
```

---

## 🛠️ Como rodar o projeto localmente

1. Clone este repositório:
   ```bash
   git clone https://github.com/seuusuario/seu-projeto-crud.git
   ```
2. Acesse a pasta do projeto:
   ```bash
   cd seu-projeto-crud
   ```
3. Configure o **application.properties**:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/nome_do_banco
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   spring.jpa.hibernate.ddl-auto=update
   ```
4. Execute o projeto:
   ```bash
   mvn spring-boot:run
   ```

[http://localhost:8080/users](http://localhost:8080/users)

````

---

## 📬 Exemplos de requisições

### ➕ Criar usuário
```json
POST /users
{
  "nome": "João Silva",
  "email": "joao@email.com",
  "senha": "123456"
  "tipo" : "PESSOA"
}
````

### 🔍 Buscar usuário por ID = VIA REQUEST PARAM 

```
GET /users/{email}
```

### ✏️ Atualizar usuário = VIA REQUEST PARAM

```json
PUT /users/{email}
{
  "nome": "João Souza",
  "email": "joao@email.com",
  "senha": "654321"
  "tipo" : "EMPRESA"
}
```

### ❌ Deletar usuário = VIA REQUEST PARAM

```
DELETE /users/{email}
```

---

## 📄 Licença

Este projeto é apenas para fins de estudo e demonstração.\
Sinta-se à vontade para usar e modificar como quiser 🚀

