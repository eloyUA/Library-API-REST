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

## Endpoints

Fuente base: `/books`

| Endpoint | Description |
| :--- | :--- |
| `GET /books?sort=...` | Retrieve a list of all books. |
| `GET /books/{id}` | Retrieve details of a specific book. |
| `GET /books/search?author=...&title=...&availability=...` | Search books with advanced filters. |
| `POST /books` | Create a new book. |
| `PUT /books/{id}` | Fully replace an existing book. |
| `PATCH /books/{id}?available=...` | Partially update a book (e.g., availability). |
| `DELETE /books/{id}` | Delete a specific book. |
