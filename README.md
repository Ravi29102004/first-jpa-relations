# 🚀 Spring Boot User Management REST API

A beginner-friendly **Spring Boot REST API** project demonstrating how to build CRUD (Create, Read, Update, Delete) operations using **Java** and **Spring Boot**.

This project focuses on understanding **RESTful API development**, **HTTP methods**, **ResponseEntity**, **Global Exception Handling**, **SLF4J Logging**, and the **Spring Boot application lifecycle**. Instead of using a database, it uses an **in-memory HashMap** to simplify backend learning.

---

# 📌 Project Objectives

- Learn Spring Boot Fundamentals
- Build RESTful APIs
- Understand CRUD Operations
- Learn HTTP Request-Response Lifecycle
- Understand ResponseEntity
- Learn HTTP Status Codes
- Implement Global Exception Handling
- Learn Logging using SLF4J & Logback
- Understand Spring Boot Startup Lifecycle

---

# ✨ Features

- ✅ Create User
- ✅ Update Existing User
- ✅ Delete User
- ✅ Retrieve All Users
- ✅ RESTful API Design
- ✅ ResponseEntity with HTTP Status Codes
- ✅ In-Memory Storage using HashMap
- ✅ Global Exception Handling
- ✅ Custom Exception (UserNotFoundException)
- ✅ SLF4J Logging
- ✅ Logback Integration
- ✅ Parameterized Logging
- ✅ CommandLineRunner Example
- ✅ ApplicationRunner Example
- ✅ Beginner-Friendly Project Structure

---

# 🛠️ Technologies Used

| Technology | Version |
|------------|----------|
| Java | 17+ |
| Spring Boot | 4.x |
| Maven | Latest |
| REST API | HTTP |
| SLF4J | Logging API |
| Logback | Default Logging Framework |
| IntelliJ IDEA | IDE |
| HashMap | In-Memory Database |

---

# 📂 Project Structure

```
src
├── main
│   ├── java
│   │   └── com.demo.first
│   │       ├── FirstApplication.java
│   │       ├── HelloController.java
│   │       ├── AppArgsRunner.java
│   │       ├── AppStartupRunner.java
│   │       └── app
│   │            ├── control
│   │            │     └── UserController.java
│   │            │
│   │            ├── service
│   │            │     └── UserService.java
│   │            │
│   │            ├── model
│   │            │     └── User.java
│   │            │
│   │            └── exceptions
│   │                  ├── GlobalExceptionHandler.java
│   │                  └── UserNotFoundException.java
│   │
│   └── resources
│         └── application.properties
│
└── test
```

---

# 🌐 REST API Endpoints

| HTTP Method | Endpoint | Description |
|-------------|----------|-------------|
| GET | /api/hello | Returns Hello World |
| GET | /user | Get All Users |
| POST | /user | Create User |
| PUT | /user | Update User |
| DELETE | /user/{id} | Delete User |

---

# 📨 Sample JSON Request

### Create User

```json
{
    "id": 1,
    "name": "Ravi",
    "email": "ravi620bd@gmail.com"
}
```

---

# ✅ Sample JSON Response

```json
{
    "id": 1,
    "name": "Ravi",
    "email": "ravi620bd@gmail.com"
}
```

---

# 📖 Spring Boot Concepts Covered

- Spring Boot Starter
- REST Controller
- CRUD Operations
- GET Mapping
- POST Mapping
- PUT Mapping
- DELETE Mapping
- RequestBody
- PathVariable
- ResponseEntity
- HttpStatus
- POJO
- Java Collections (HashMap)
- ApplicationRunner
- CommandLineRunner
- Global Exception Handling
- @ControllerAdvice
- @ExceptionHandler
- Custom Exception
- SLF4J
- Logger
- LoggerFactory
- Logback
- Logging Levels
- Parameterized Logging

---

# 📡 HTTP Status Codes Used

| Status Code | Meaning |
|-------------|----------|
| 200 OK | Request Successful |
| 201 Created | Resource Created |
| 204 No Content | Resource Deleted |
| 400 Bad Request | Invalid Request |
| 404 Not Found | Resource Not Found |
| 500 Internal Server Error | Unexpected Error |

---

# 📜 Logging Example

```java
private static final Logger logger =
        LoggerFactory.getLogger(UserController.class);

logger.info("Fetching all users");

logger.debug("User ID : {}", id);

logger.warn("User not found with ID : {}", id);

logger.error("Unexpected exception occurred", exception);
```

---

# 📊 Logging Levels

| Level | Description |
|--------|-------------|
| TRACE | Detailed execution information |
| DEBUG | Debugging information |
| INFO | General application information |
| WARN | Warning messages |
| ERROR | Error messages |

---


# 🧠 Learning Outcomes

After completing this project, I learned:

- Spring Boot Fundamentals
- REST API Development
- CRUD Operations
- HTTP Methods
- HTTP Status Codes
- ResponseEntity
- Java Collections
- In-Memory Data Management
- ApplicationRunner
- CommandLineRunner
- Global Exception Handling
- Custom Exceptions
- SLF4J Logging
- Logback
- Logger & LoggerFactory
- Logging Best Practices
- Clean Project Structure

---

# 🚀 Future Improvements

- MySQL Integration
- Spring Data JPA
- Hibernate ORM
- Bean Validation
- Spring Security
- JWT Authentication
- Swagger / OpenAPI
- Docker
- JUnit Testing
- Integration Testing
- Pagination & Sorting
- Spring Profiles
- Spring Boot Actuator
- Microservices

---

# 🧪 API Testing

You can test the APIs using:

- Postman
- IntelliJ HTTP Client
- cURL
- Thunder Client (VS Code)

---

# 👨‍💻 Author

## Ravi Ranjan

**Electronics & Communication Engineering Student**

### Skills

- Java
- Spring Boot
- REST APIs
- Maven
- SLF4J
- Logback
- Git & GitHub
- IntelliJ IDEA

---

⭐ **If you found this project useful, consider giving it a Star!**
