# Spring JDBC Employee CRUD Example

This project is a simple Spring Boot application demonstrating basic CRUD (Create, Read, Update, Delete) operations on an `Employee` table using **Spring JDBC (JdbcTemplate)** with a **MySQL** database.

## Features

- Spring Boot 3.x with Java 21
- Spring JDBC for database access
- MySQL database integration
- Basic CRUD operations on `Employee`
- Command-line runner for demo operations
- Docker support

## Project Structure

- [`src/main/java/com/rajesh/model/Employee.java`](src/main/java/com/rajesh/model/Employee.java): Employee domain model
- [`src/main/java/com/rajesh/dao/EmployeeDAO.java`](src/main/java/com/rajesh/dao/EmployeeDAO.java): DAO interface
- [`src/main/java/com/rajesh/dao/EmployeeDAOImpl.java`](src/main/java/com/rajesh/dao/EmployeeDAOImpl.java): DAO implementation using `JdbcTemplate`
- [`src/main/java/com/rajesh/spring_jdbc/SpringJdbcApplication.java`](src/main/java/com/rajesh/spring_jdbc/SpringJdbcApplication.java): Main Spring Boot application
- [`src/main/java/com/rajesh/spring_jdbc/CommandLineAppStartupRunner.java`](src/main/java/com/rajesh/spring_jdbc/CommandLineAppStartupRunner.java): Runs demo CRUD operations at startup
- [`src/main/resources/application.properties`](src/main/resources/application.properties): Database configuration

## Prerequisites

- Java 21+
- MySQL running on `localhost:3306` with a database named `testDB`
- MySQL user: `root`, password: `root@123` (see [`application.properties`](src/main/resources/application.properties))
- Gradle (or use the provided wrapper)

## Database Setup

Create the `Employee` table in your `testDB` database:

```sql
CREATE TABLE Employee (
  id INT PRIMARY KEY,
  name VARCHAR(100),
  role VARCHAR(100)
);
```

## Build & Run

### Using Gradle

```sh
./gradlew build
./gradlew bootRun
```

### Using Docker

Build the JAR:

```sh
./gradlew build
```

Build and run the Docker image:

```sh
docker build -t spring-jdbc-demo .
docker run --rm spring-jdbc-demo
```

## How It Works

On application startup, the [`CommandLineAppStartupRunner`](src/main/java/com/rajesh/spring_jdbc/CommandLineAppStartupRunner.java) will:

1. Insert a new employee
2. Fetch and print the employee
3. Update the employee's role
4. List all employees

## Customization

- Update database credentials in [`application.properties`](src/main/resources/application.properties) as needed.
- Extend the `Employee` model and DAO for more complex operations.

## License

This project is licensed under the Apache License 2.0.# Spring JDBC Employee CRUD Example
