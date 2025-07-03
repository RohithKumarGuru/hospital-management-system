# 🏥 Hospital Management System

A full-stack backend project built with **Java Spring Boot** to manage hospital operations including patients, doctors, prescriptions, appointments, rooms, payments, and more.

---

## 🚀 Features

- ✅ RESTful API for 10+ entities (Patient, Doctor, Hospital, etc.)
- ✅ CRUD operations with service-controller-dao architecture
- ✅ Swagger/OpenAPI documentation
- ✅ JPA relationships: OneToOne, OneToMany, ManyToOne
- ✅ Exception handling and response structure wrapper
- ✅ Built using Maven and Eclipse

---

## 🛠 Tech Stack

- **Java 17**
- **Spring Boot**
- **Maven**
- **Swagger (OpenAPI 3.0)**
- **MySQL**
- **Eclipse IDE**

---

## 📂 How to Run

```bash

## 📦 How to Run the Project

### Prerequisites:
- Java 17 or later
- Maven
- MySQL

### Steps:
1. **Clone**
   ```bash
   git clone https://github.com/RohithKumarGuru/hospital-management-system.git
   cd hospital-management-system

2. Create the MySQL Database

sql
CREATE DATABASE hospital_db;

3. Update application.properties
Open src/main/resources/application.properties and set:

properties
spring.datasource.url=jdbc:mysql://localhost:3306/hospital_db
spring.datasource.username=your_username
spring.datasource.password=your_password

4. Run the project
Using Maven wrapper:

bash
./mvnw spring-boot:run
Or using Eclipse: right-click HospitalManagementSystemApplication.java → Run

5. Open the Swagger API documentation
http://localhost:8080/swagger-ui/index.html


# Navigate into the project
cd hospital-management-system

# Run the application
./mvnw spring-boot:run
