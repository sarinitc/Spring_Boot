# Spring Boot CRUD Operation

This project is a simple **Spring Boot REST API** that demonstrates basic CRUD operations.

CRUD means:

* **C**reate – Add new data
* **R**ead – Get existing data
* **U**pdate – Change existing data
* **D**elete – Remove data

At this stage, the project is **not connected to a database**. The data is stored temporarily in a Java `ArrayList`.

When the application stops or restarts, all stored data will be deleted.

## Technologies Used

* Java
* Spring Boot
* Spring Web
* Maven
* ArrayList
* Swagger / OpenAPI
* IntelliJ IDEA

## Project Structure

```text
src
└── main
    └── java
        └── student
            ├── Student.java
            ├── StudentController.java
            ├── StudentService.java
            └── SpringDemoApplication.java
```

### Student

The `Student` class represents the student data.

Example fields:

```java
private Long id;
private String name;
private String gender;
private Double score;
```

### StudentService

The `StudentService` class contains the business logic.

It uses an `ArrayList` to temporarily store student data.

```java
private final List<Student> students = new ArrayList<>();
```

The service handles operations such as:

* Add a student
* Get all students
* Get a student by ID
* Update a student
* Delete a student

### StudentController

The `StudentController` receives HTTP requests from the client and calls methods from `StudentService`.

The controller uses the following base URL:

```text
/api/students
```

## CRUD API Endpoints

### 1. Create a Student

```http
POST /api/students
```

Example request body:

```json
{
  "name": "Sarin",
  "gender": "Male",
  "score": 90
}
```

This endpoint adds a new student to the `ArrayList`.

### 2. Get All Students

```http
GET /api/students
```

This endpoint returns all students stored in the `ArrayList`.

Example response:

```json
[
  {
    "id": 1,
    "name": "Sarin",
    "gender": "Male",
    "score": 90
  }
]
```

### 3. Get Student by ID

```http
GET /api/students/{id}
```

Example:

```http
GET /api/students/1
```

This endpoint finds and returns one student using the student ID.

### 4. Update a Student

```http
PUT /api/students/{id}
```

Example:

```http
PUT /api/students/1
```

Example request body:

```json
{
  "name": "Cheav Sarin",
  "gender": "Male",
  "score": 95
}
```

This endpoint updates the information of an existing student.

### 5. Delete a Student

```http
DELETE /api/students/{id}
```

Example:

```http
DELETE /api/students/1
```

This endpoint removes a student from the `ArrayList`.

## Request Flow

The request follows this flow:

```text
Client
   ↓
StudentController
   ↓
StudentService
   ↓
ArrayList
   ↓
Response
```

Example for creating a student:

```text
POST request
   ↓
StudentController receives @RequestBody
   ↓
StudentService adds the student
   ↓
Student is stored in ArrayList
   ↓
Created student is returned
```

## Run the Project

Clone the repository:

```bash
git clone https://github.com/sarinitc/Spring_Boot.git
```

Open the project folder:

```bash
cd Spring_Boot
```

Run the application with Maven:

```bash
mvn spring-boot:run
```

The application will run on:

```text
http://localhost:8080
```

## Swagger UI

After running the application, open Swagger UI:

```text
http://localhost:8080/swagger-ui.html
```

You can use Swagger to test:

* POST
* GET
* PUT
* DELETE

## Important Note

This project currently uses:

```java
ArrayList<Student>
```

It does not use:

* PostgreSQL
* MySQL
* Spring Data JPA
* Repository
* Database tables

Because the data is stored in memory, it will disappear whenever the application restarts.

## Future Improvements

The next step is to connect the project to a real database.

Future improvements may include:

* Connect PostgreSQL
* Add Spring Data JPA
* Create `StudentRepository`
* Use database-generated IDs
* Add validation
* Add exception handling
* Add pagination
* Improve API responses

## Author

**Cheav Sarin**

Spring Boot CRUD learning project.
