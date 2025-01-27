# Table Booking System

## Description
This is a simple Table Booking System built using Spring Boot and H2 database. The system allows users to book tables, update bookings, and search for tables based on booking names. It includes functionalities for both users and admins, with endpoints for table management.

The system uses **JPA** for data persistence and **ModelMapper** for converting between `Entity` and `DTO` objects. The backend exposes REST APIs to interact with table bookings.

## Features
- **Create a table booking**
- **Update table booking**
- **Delete table booking**
- **Search for bookings by name**
- **Get all table bookings**

## Technologies Used
- **Spring Boot**
- **JPA**: Java Persistence API for database interaction.
- **H2 Database**
- **ModelMapper**: For converting entities to DTOs and vice versa.
- **REST APIs**

## Installation Guide

Follow these steps to get the project up and running:


### 1. Clone the Repository

Clone the repository to your local machine:
```bash
git clone https://github.com/yourusername/table-booking-system.git
cd table-booking-system
```

---

### 2. Prerequisites

Make sure you have the following installed on your system:
- **Java 17** or later
- **Maven** (for building and running the application)
- **MySQL** (as the database)

---

### 3. Setup Database

1. Start your MySQL server.
2. Create a new database:
   ```sql
   CREATE DATABASE table_booking_system;
   ```
3. Update `application.properties` file in the `src/main/resources` directory with your database credentials:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/table_booking_system
   spring.datasource.username=your_mysql_username
   spring.datasource.password=your_mysql_password
   ```

---

### 4. Build and Run the Application

1. Build the application using Maven:
   ```bash
   mvn clean install
   ```
2. Run the application:
   ```bash
   mvn spring-boot:run
   
3. Images for refrence are in the static folder
   ![Alt text]( src/main/resources/static/Screenshot%202025-01-27%20at%2011.06.10.png"Optional title")
    ![Alt text]( src/main/resources/static/Screenshot%202025-01-27%20at%2011.06.38.png"Optional title")
  ![Alt text]( src/main/resources/static/Screenshot%202025-01-27%20at%2011.07.45.png"Optional title")
      ![Alt text]( src/main/resources/static/Screenshot%202025-01-27%20at%2011.08.00.png"Optional title")
     


