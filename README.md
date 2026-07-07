# Library-API-REST
Proyecto backend sencillo usando Java + Spring Boot para gestionar libros de una biblioteca.

## Herramientas
 * Java 21
 * Gradle 9
 * Spring Boot 4
 * IntelliJ IDEA
 * Postman

## Conocimientos practicados
 * Arquitecturas: REST, MVC
 * Patrones: DTO, Repository
 * Protocolo HTTP
 * Spring-boot-starter-webmvc
 * Spring-boot-starter-validation

## Endpoints

Fuente base: `/books`

| Endpoint | Descripción |
| :--- | :--- |
| `GET /books?sort=...` | Devuelve una lista de todos los libros. |
| `GET /books/{id}` | Devuelve un solo libro. |
| `GET /books/search?author=...&title=...&availability=...` | Buscar libros a partir de unos filtros. |
| `POST /books` | Crear un nuevo libro. |
| `PUT /books/{id}` | Actualización total de un libro. |
| `PATCH /books/{id}?available=...` | Actualización parcial de un libro |
| `DELETE /books/{id}` | Borrar un libro específico. |
