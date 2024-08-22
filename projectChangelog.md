### Project Overview

The project is an e-commerce application using Spring Boot and Spring Data JPA to manage users and their orders. The main entities in the application are `User` and `UserOrder`. The application demonstrates the following key concepts:

1. **Entity Mapping**: The `User` and `UserOrder` classes are mapped to database tables using JPA annotations like `@Entity`, `@Id`, `@GeneratedValue`, `@OneToMany`, `@ManyToOne`, `@ElementCollection`, etc.

2. **Repository Interfaces**: The `UserRepository` and `OrderRepository` interfaces extend `JpaRepository`, providing CRUD operations and custom finder methods.

3. **Data Persistence**: The application stores and retrieves `User` and `UserOrder` entities in a MySQL database.

### Tables Created in MySQL

1. **`user` Table**:
    - **Columns**:
        ![](.projectChangelog_images/a9294644.png)
    - **Reason for Creation**: The `@Entity` annotation on the `User` class instructs JPA to create this table.

2. **`user_order` Table**:
    - **Columns**:
   
   ![](.projectChangelog_images/a045d113.png)
    - **Reason for Creation**: The `@Entity` annotation on the `UserOrder` class instructs JPA to create this table.

3. **`user_interests` Table**:
    - **Columns**:
   
    ![](.projectChangelog_images/51b86910.png)
    - **Reason for Creation**: The `@ElementCollection` annotation on the `interests` field in the `User` class instructs JPA to create this table.

4. **`user_addresses` Table**:
    - **Columns**:
   
        ![](.projectChangelog_images/36a810ec.png)
    - **Reason for Creation**: The `@ElementCollection` annotation on the `addresses` field in the `User` class, combined with `@MapKeyColumn` and `@Column`, instructs JPA to create this table.

### Table creation Explanation

- **Entity Mapping to Tables**: The `@Entity` annotation on a class is what instructs JPA to create a corresponding table in the database. In the provided code, this annotation is used on the `User` and `UserOrder` classes, which leads to the creation of `user` and `user_order` tables, respectively.

- **Collection Tables**: The `@ElementCollection` annotation is used to create additional tables to store collections of basic types or embeddable objects. This leads to the creation of the `user_interests` and `user_addresses` tables for storing lists and maps, respectively.

Necessary to store the different attributes and relationships defined in the `User` and `UserOrder` classes.