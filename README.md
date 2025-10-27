# 🍃 API-MONGO - EcoFactory

API REST desenvolvida em **Spring Boot** para o gerenciamento de dados e funcionalidades do projeto **EcoFactory Calbon**. Esta API utiliza **MongoDB** como banco de dados NoSQL.

A API está hospedada na plataforma **Render**.

[![Status](https://img.shields.io/badge/Status-Live-brightgreen)](#)

### Links de Acesso (Produção)

* **API Base URL:** `https://api-mongo-hi4a.onrender.com/`
* **Documentação (Swagger):** `https://api-mongo-hi4a.onrender.com/swagger-ui.html`

---

## 🚀 Tecnologias Utilizadas

O *stack* principal do projeto é construído em torno do ecossistema Java e Spring, com deploy automatizado no Render.

![Java](https://img.shields.io/badge/Java-17%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
<br/>
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
<br/>
![MongoDB](https://img.shields.io/badge/MongoDB-47A248?style=for-the-badge&logo=mongodb&logoColor=white)
<br/>
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
<br/>
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)
<br/>
![Render](https://img.shields.io/badge/Render-46E3B7?style=for-the-badge&logo=render&logoColor=black)
<br/>
![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=black)

---

## ⚙️ Configuração de Ambiente

O projeto utiliza variáveis de ambiente para configurar a conexão com o banco de dados MongoDB.

### 1. Ambiente de Produção (Render)

No Render, as variáveis de ambiente **não** são lidas de um arquivo `.env`. Elas devem ser configuradas diretamente no dashboard do seu serviço:

1.  Vá para a seção "Environment" do seu serviço no Render.
2.  Adicione a seguinte variável (o Spring Boot irá lê-la automaticamente):
    * `SPRING_DATA_MONGODB_URI`: (A sua string de conexão completa, ex: `mongodb+srv://user:pass@cluster.mongodb.net/database_name?retryWrites=true&w=majority`)

*Nota: Ao usar a URI completa do MongoDB, você não precisa de variáveis `DB_USERNAME` ou `DB_PASSWORD` separadas, pois elas já estão na string de conexão.*

### 2. Ambiente de Desenvolvimento (Local)

Para desenvolvimento local, crie um arquivo `.env` na raiz do projeto. Este arquivo **não deve ser versionado** (`.gitignore`).

**Exemplo de `.env`:**

* `DB_URI=mongodb+srv://sua-Uri`

## 📖 Documentação da API (Endpoints)

Este projeto utiliza Swagger (OpenAPI) para documentação interativa.

### Acesso Local
* **URL:** [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

### Acesso em Produção
* **URL:** [https://api-mongo-hi4a.onrender.com/swagger-ui/index.html](https://api-mongo-hi4a.onrender.com/swagger-ui/index.html)
