
# Order Management API

A REST API built with Spring Boot for managing orders, products, categories, and suppliers.

## 🛠 Tech Stack

- Java 17
- Spring Boot 3.x
- PostgreSQL
- Spring Data JPA
- Maven
- Hibernate


## 📋 Project Description

This API provides a complete solution for order management with relationships between products, categories and suppliers.

## 🏗 Architecture

### Domain Models

#### Category
```java
- id: Long
- name: String 
- products: List<Product>
```

#### Supplier
```java
- id: Long
- name: String
- products: List<Product>
```

#### Product
```java
- id: Long
- name: String (unique)
- price: Double
- category: Category
- supplier: Supplier
```

#### Order
```java
- id: Long
- orderDate: LocalDate
- products: List<Product>
```

### Entity Relationships

- Product -> Category (N:1)
- Product -> Supplier (N:1)
- Order -> Product (N:N)

## 🔧 Configuration

The application uses environment variables for database configuration:

```properties
SPRING_DATASOURCE_HOST=localhost
SPRING_DATASOURCE_NAME=dbname
SPRING_DATASOURCE_USERNAME=user
SPRING_DATASOURCE_PASSWORD=pass
```

## ⚙️ Key Features

- CRUD operations for all entities
- Automatic data loading for testing through TesteDataLoader
- Validation for duplicate products
- Bidirectional relationships between entities
- Transaction management
- Lazy loading for better performance
- Cascade operations where appropriate

## 🗄️ Repositories

The project implements JPA repositories for all entities:

- `CategoriaRepository`
- `FornecedorRepository`
- `ProdutoRepository`
- `PedidoRepository`

## 🚀 Running the Project

1. Clone the repository
2. Set up environment variables
3. Run:
```bash
mvn clean install
mvn spring-boot:run
```

## 📦 Database Configuration

The application uses PostgreSQL with the following settings:

```properties
spring.jpa.hibernate.ddl-auto=update
spring.datasource.driver-class-name=org.postgresql.Driver
```


## 🔐 Data Validation

- Unique product names
- Required fields validation
- Relationship integrity

## 📚 API Documentation

The API follows REST principles with the following structure:

- `/categorias` - Category management
- `/fornecedores` - Supplier management
- `/produtos` - Product management
- `/pedidos` - Order management

## AUTOR
    José Fábio Guimarães