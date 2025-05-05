# Day-06-Practicals Session


## Description
This project demonstrates the implementation of entity relationships in Spring Boot using JPA and Hibernate. The application models a company structure with Departments, Employees, and Projects, showcasing different types of relationships (One-to-Many, Many-to-One, and Many-to-Many).

## Table of Contents
- [Day-06-Practicals Session](#day-05-practicals-session)
  - [Description](#description)
  - [Table of Contents](#table-of-contents)
  - [Entity Models](#entity-models)
    - [Department Entity](#department-entity)
    - [Employee Entity](#employee-entity)
    - [Project Entity](#project-entity)
  - [Relationships](#relationships)
    - [One-to-Many: Between Department and Employee](#one-to-many-between-department-and-employee)
    - [Many-to-One: Between Employee and Department](#many-to-one-between-employee-and-department)
    - [Many-to-Many: Between Employee and Project](#many-to-many-between-employee-and-project)
  - [Database Configuration](#database-configuration)
    - [Dependencies](#dependencies)
    - [Usage](#usage)

## Entity Models

### Department Entity
```java
package com.example.firstapp.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Department {
        @Id
        @Column(name="dept_id")
        private int id;

        @Column(nullable = false)
        private String name;

        private Date established;

        @OneToMany(mappedBy = "department")
        private List<Employee> employees;

        // Constructor and getter/setter methods
        // ...
}
```

### Employee Entity
```java
package com.example.firstapp.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Employee {
        @Id
        private String empNo;
        private String name;
        private int age;
        private double salary;
        private String gender;

        @ManyToOne
        private Department department;

        @ManyToMany(mappedBy = "employees")
        private List<Project> projet;

        // Constructor and getter/setter methods
        // ...
}
```

### Project Entity
```java
package com.example.firstapp.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Project {
        @Id
        @Column(name="pro_id")
        private int id;
        private String name;
        private long totalCost;

        @ManyToMany
        private List<Employee> employees;

        // Constructor and getter/setter methods
        // ...
}
```

## Relationships

### One-to-Many: Between Department and Employee
- One department can have many employees.
- In the `Department` class, `@OneToMany(mappedBy = "department")` indicates that one department relates to many employees.
- The `mappedBy` attribute references the field in `Employee` that owns the relationship.

### Many-to-One: Between Employee and Department
- Many employees can belong to one department.
- In the `Employee` class, `@ManyToOne` establishes this relationship.
- This is the inverse of the One-to-Many relationship defined in `Department`.

### Many-to-Many: Between Employee and Project
- Many employees can work on many projects.
- Many projects can have many employees.
- This requires a join table in the database to track which employees are assigned to which projects.
- In the `Project` class, `@ManyToMany` defines the owning side of the relationship.
- In the `Employee` class, `@ManyToMany(mappedBy = "employees")` indicates the inverse side.

## Database Configuration
The application is configured to connect to a MySQL database with the following properties:

```properties
spring.application.name=newapp
spring.datasource.url=jdbc:mysql://localhost:3306/employeeDB
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
```

### Dependencies
The project uses the following Spring Boot dependencies:
- **Spring Web**: For building RESTful web services
- **Spring Data JPA**: For simplified data access using JPA
- **MySQL Driver**: For connecting to MySQL database


### Usage
This project serves as a foundation for building a complete CRUD application for managing departments, employees, and projects
