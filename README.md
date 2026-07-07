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
 * /books

 ```GET /books?sort=[TITLE, PRICE]```

 ```GET /books/{id}```

 ```GET /books/search?author=...&availability=...&maxPrice=...```

 ```POST /books```

 ```PUT /books/{id}```

 ```PATCH /books?available=...{id}```

 ```DELETE /books/{id}```
