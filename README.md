# Okena

Okena é uma API web em desenvolvimento para monitoramento urbano com abordagem colaborativa. A plataforma permite que usuários registrem, acompanhem e interajam com ocorrências da cidade em tempo real.

Inspirado no conceito de redes sociais, o sistema substitui publicações tradicionais por reports, possibilitando que moradores compartilhem problemas urbanos e contribuam para uma rede colaborativa de informações.

---

## 🎯 Objetivo do Projeto

O Okena foi desenvolvido com o propósito de facilitar a comunicação entre cidadãos e problemas urbanos, centralizando informações e promovendo colaboração social.

A plataforma busca tornar mais visíveis as demandas da população, contribuindo para uma resposta mais rápida e eficiente por parte da sociedade e órgãos responsáveis.

---

## 🚀 Funcionalidades

- 📍 Registro de ocorrências urbanas
- 🧭 Visualização de ocorrências por localização
- 👥 Interação entre usuários (modelo social)
- 🔄 Atualização e exclusão de reports
- 📊 Acompanhamento em tempo real
- 🔎 Filtros e organização de dados

---

## 🛠️ Tecnologias utilizadas

#### Backend
- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Lombok (redução de boilerplate: getters, construtores, etc.)
- Flyway (versionamento e migração de banco de dados)

#### Banco de Dados
- MySQL

#### Ferramentas e Outros
- API REST
- JSON
- Postman (testes e validação dos endpoints)

---

## 🧠 Arquitetura

O projeto segue uma arquitetura baseada em:

- Controller → responsável pelas requisições HTTP
- Entity → representação das entidades e mapeamento objeto-relacional (ORM)
- Service → regras de negócio
- Repository → acesso ao banco de dados
- DTOs → transferência de dados entre camadas

---

## ⚙️ Como executar o projeto

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/okena.git

# Crie variaveis de ambiente para conexão com banco de dados em properties:
spring.application.name=Okena
spring.datasource.url=jdbc:mysql://localhost:3306/okena
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA

# Acesse a pasta
cd okena

# Execute a aplicação
./mvnw spring-boot:run
```

## 👨‍💻 Autor

Desenvolvido por Arthur Trindade  

---
