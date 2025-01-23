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
- **Spring Boot**: Java framework for building web applications.
- **JPA**: Java Persistence API for database interaction.
- **H2 Database**: In-memory database for development and testing.
- **ModelMapper**: For converting entities to DTOs and vice versa.
- **REST APIs**: Exposed for table management.

## Installation Guide

Follow these steps to get the project up and running:

### 1. Clone the Repository

Clone the repository to your local machine:
```bash
git clone https://github.com/yourusername/table-booking-system.git
cd table-booking-system
```

table-booking-system/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── ansh/
│   │   │           └── restSpring/
│   │   │               ├── controllers/         # Contains the REST controllers
│   │   │               ├── dto/                 # Contains DTO classes
│   │   │               ├── entities/            # JPA entity classes
│   │   │               ├── repositories/        # Repository interfaces for DB interaction
│   │   │               └── services/            # Service layer for business logic
│   │   ├── resources/
│   │   │   ├── application.properties  # Configuration file
│   │   │   └── static/                 # Static resources (if any)
│   │   │   └── templates/              # Template files (if any)
├── target/                             # Compiled bytecode and JAR files
├── pom.xml                             # Maven configuration file
└── README.md                           # This README file
