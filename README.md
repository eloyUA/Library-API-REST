# Library-API-REST
Proyecto backend sencillo usando Java + Spring Boot para gestionar libros de una biblioteca.

## Herramientas
 * Java 21
 * Gradle 9
 * Spring Boot 4
 * IntelliJ IDEA

## Conocimientos practicados
 * Arquitecturas: REST, MVC
 * Patrones: DTO, Repository
 * Protocolo HTTP
 * Spring-boot-starter-webmvc
 * Spring-boot-starter-validation

## 📚 Endpoints: Books

Base resource: `/books`

### 📥 GET

| Endpoint | Description | Query Parameters |
| :--- | :--- | :--- |
| `/books` | Retrieve a list of all books. | `sort`: `TITLE`, `PRICE` |
| `/books/{id}` | Retrieve details of a specific book. | - |
| `/books/search` | Search books with advanced filters. | `author`, `availability`, `maxPrice` |

### 📤 POST

| Endpoint | Description | Body |
| :--- | :--- | :--- |
| `/books` | Create a new book. | Book object |

### 🔄 PUT

| Endpoint | Description | Body |
| :--- | :--- | :--- |
| `/books/{id}` | Fully replace an existing book. | Complete Book object |

### 🛠️ PATCH

| Endpoint | Description | Body |
| :--- | :--- | :--- |
| `/books/{id}` | Partially update a book (e.g., availability). | Fields to update (e.g., `{ "available": true }`) |

> **Note**: The `PATCH` endpoint requires the `{id}` in the URL path. Update fields should be sent in the request body, not as query parameters.

### 🗑️ DELETE

| Endpoint | Description |
| :--- | :--- |
| `/books/{id}` | Delete a specific book. |
