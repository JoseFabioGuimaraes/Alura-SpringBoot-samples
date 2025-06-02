# APIScreenMatchFrase

REST API built with Java and Spring Boot to provide random quotes from TV shows and movies. This project serves as the backend for the application [3356-java-desafio-front](https://github.com/jacqueline-oliveira/3356-java-desafio-front).

## Description

This project provides an endpoint that returns random quotes from popular TV series and movies, including information such as the title of the work, the character who said the quote, and the URL of the poster.

## Technologies Used

- Java 17
- Spring Boot 3.5.0
- Spring Data JPA
- PostgreSQL
- Maven

## Project Structure

- **Model**: `Frase` entity mapped to the `frases` table in the database
- **DTO**: `FraseDTO` for API data transfer
- **Repository**: `FraseRepository` interface with method to select a random quote
- **Service**: `FraseService` with business logic
- **Controller**: `FraseController` exposing the REST endpoint
- **Config**: CORS configuration to allow requests from the frontend

## Endpoints

- **GET** `/series/frases`: Returns a random quote in the format:

```json
{
  "titulo": "Grey's Anatomy",
  "frase": "We're just people. We make mistakes, we lose our way. Even the best of us have our off days. Still, we move forward.",
  "personagem": "Meredith Grey",
  "poster": "https://m.media-amazon.com/images/M/MV5BODA2Mjk0N2MtNGY0Mi00ZWFjLTkxODEtZDFjNDg4ZDliMGVmXkEyXkFqcGdeQXVyMzAzNTY3MDM@._V1_SX300.jpg"
}
```

## Configuration and Execution

### Prerequisites
- JDK 17
- PostgreSQL
- Maven

### Environment Variables
Configure the following environment variables:
- `SPRING_DATASOURCE_HOST`
- `SPRING_DATASOURCE_NAME`
- `SPRING_DATASOURCE_USERNAME`
- `SPRING_DATASOURCE_PASSWORD`

### Running the Project
1. Clone the repository:
   ```
   git clone https://github.com/JoseFabioGuimaraes/APIScreenMatchFrase.git
   cd APIScreenMatchFrase
   ```

2. Run the application:
   ```
   mvn spring-boot:run
   ```

3. The API will be available at: http://localhost:8080

## Sample Data

The `data.sql` file contains 10 quotes from popular TV shows and movies to initialize the database.

## Frontend

The frontend that consumes this API is available at:
[https://github.com/jacqueline-oliveira/3356-java-desafio-front](https://github.com/jacqueline-oliveira/3356-java-desafio-front)

---

Developed by José Fábio Guimarães