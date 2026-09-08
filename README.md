# API de Empleados

API REST desarrollada con Spring Boot para gestionar empleados de forma temporal en memoria.

La aplicación permite:

- Listar empleados.
- Buscar empleados por ID.
- Registrar empleados.
- Actualizar empleados.
- Eliminar empleados.
- Validar los datos recibidos.
- Manejar respuestas HTTP `200`, `201`, `400` y `404`.

## Tecnologías utilizadas

- Java 21
- Spring Boot
- Spring Web
- Validation
- Lombok
- Maven
- Postman

## Endpoints

| Método | Endpoint | Acción |
|---|---|---|
| GET | `/api/empleados` | Listar empleados |
| GET | `/api/empleados/{id}` | Buscar empleado por ID |
| POST | `/api/empleados` | Registrar empleado |
| PUT | `/api/empleados/{id}` | Actualizar empleado |
| DELETE | `/api/empleados/{id}` | Eliminar empleado |

## Evidencias de pruebas

Las pruebas realizadas en Postman, incluyendo la solicitud, código HTTP y respuesta JSON, se encuentran en el siguiente documento:

[Ver Pruebas de Endpoints](./Pruebas%20de%20Endpoints.pdf)

---

# Preguntas de cierre

## 1. ¿Qué diferencia existe entre `@Controller` y `@RestController`?

`@Controller` se utiliza normalmente en controladores que pueden retornar vistas, mientras que `@RestController` devuelve directamente los datos en el cuerpo de la respuesta, generalmente en formato JSON.

En esta API se utiliza `@RestController` porque los endpoints devuelven datos JSON y no páginas HTML.

## 2. ¿Qué función cumple `@RequestBody`?

`@RequestBody` permite convertir el JSON enviado por el cliente en un objeto Java.

Por ejemplo, el JSON enviado en una solicitud POST se convierte automáticamente en un objeto `EmpleadoDTO`.

## 3. ¿Por qué se utiliza `@Valid` junto al DTO?

`@Valid` hace que Spring ejecute las reglas de validación definidas en el DTO antes de procesar la solicitud.

Entre las validaciones utilizadas se encuentran:

- `@NotBlank`
- `@NotNull`
- `@Size`
- `@DecimalMin`

Si los datos no cumplen las reglas, la API devuelve un código `400 Bad Request` con los errores encontrados.

## 4. ¿Qué código HTTP debe devolver un registro creado correctamente?

Debe devolver:

`201 Created`

Este código indica que el recurso fue creado correctamente.

## 5. ¿Cómo interviene Jackson en las respuestas de la API?

Jackson se encarga de convertir automáticamente los objetos Java a JSON y los datos JSON recibidos a objetos Java.

Por ejemplo:

JSON → `EmpleadoDTO`

y al enviar una respuesta:

`EmpleadoDTO` → JSON

Esto permite trabajar con objetos Java dentro de la aplicación mientras el cliente recibe y envía información en formato JSON.