
# MusicGem

MusicGem é uma aplicação desenvolvida em Java utilizando Spring Boot, com integração à API Gemini (Google AI) para pesquisa de informações sobre artistas. O objetivo do projeto é permitir o gerenciamento de playlists, cadastro de artistas e músicas, além de buscar dados enriquecidos sobre artistas.

## Funcionalidades

- **Cadastrar Artistas:** Permite cadastrar artistas com nome e tipo (Solo, Dupla ou Banda).
- **Cadastrar Músicas:** Adiciona músicas à playlist associando-as a um artista previamente cadastrado.
- **Acessar Playlist:** Exibe todas as músicas cadastradas na playlist.
- **Buscar Músicas por Artista:** Lista todas as músicas de um artista específico.
- **Pesquisar Dados sobre Artistas:** Realiza consultas sobre artistas utilizando a API Gemini.

## Tecnologias Utilizadas

<div style="display: flex; align-items: center; gap: 20px;">
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" alt="Java" width="60"/>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" alt="Spring Boot" width="60"/>
<img src="https://brandlogos.net/wp-content/uploads/2025/03/gemini_icon-logo_brandlogos.net_bqzeu-512x512.png" alt="Gemini" width="60"/>
</div>

- **Java 17**
- **Spring Boot 3.5.0**
- **Maven**
- **PostgreSQL**
- **LangChain4j (Google AI Gemini)**
- **dotenv-java**

## Pré-requisitos

- **Java 17** ou superior instalado.
- **Maven** instalado.
- Banco de dados **PostgreSQL** configurado.
- Arquivo `.env` com a chave da API Gemini configurada:
  
```
GEMINI_API_KEY=SuaChaveAPI
  ```

## Configuração

1. Clone o repositório:
   ```bash
   git clone https://github.com/JoseFabioGuimaraes/Alura-SpringBoot-samples.git
   ```

2. Configure as variáveis de ambiente no arquivo `.env`:
   ```dotenv
   GEMINI_API_KEY=SuaChaveAPI
   ```

3. Configure o banco de dados no arquivo `application.properties`:
   ```ini
   spring.datasource.url=jdbc:postgresql://<host>/<database>
   spring.datasource.username=<usuario>
   spring.datasource.password=<senha>
   ```

4. Execute o projeto:
   ```bash
   mvn spring-boot:run
   ```

## Uso

Ao iniciar a aplicação, será exibido um menu no terminal com as opções disponíveis. Escolha a opção desejada digitando o número correspondente.

## Estrutura do Projeto

- `src/main/java/br/com/jfabiodev/MusicGem`: Código principal da aplicação.
    - **principal**: Classe principal que gerencia o menu e as interações do usuário.
    - **model**: Classes de modelo (Artista e Musica).
    - **repository**: Interfaces para acesso ao banco de dados.
    - **service**: Serviços auxiliares, como a integração com a API Gemini.
    - **enums**: Enumeração para tipos de artistas.
- `src/main/resources`: Arquivos de configuração, como `application.properties`.

---

## Autor

José Fábio Guimarães