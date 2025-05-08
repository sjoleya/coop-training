markdown
Copy
Edit
# Spring Boot REST API with In-Memory Storage

## 📌 Objective

This project is a simple Spring Boot REST API that demonstrates CRUD operations on an in-memory `User` entity without using any database. It helps in understanding Spring Boot, REST principles, Java collections, and service-layer design.

## 🚀 Features

- Full CRUD support (Create, Read, Update, Delete)
- In-memory data storage using Java `Map`
- Clean project structure: Model, Service, Controller layers
- Exception handling for common error cases
- **Swagger UI integrated** for interactive API documentation & testing

## 🧾 Entity: User

Each `User` has the following fields:
- `id`: Integer (auto-generated)
- `name`: String
- `email`: String

## 🛠️ Endpoints

| Method | Endpoint      | Description             |
|--------|---------------|-------------------------|
| POST   | `/api/user`      | Create a new user       |
| GET    | `/api/user`      | Get all users           |
| GET    | `/api/user/{id}` | Get user by ID          |
| PUT    | `/api/user/{id}` | Update user by ID       |
| DELETE | `/api/user/{id}` | Delete user by ID       |

- **Swagger UI integrated** can be accessed at `http://localhost:8080/swagger-ui/index.html`