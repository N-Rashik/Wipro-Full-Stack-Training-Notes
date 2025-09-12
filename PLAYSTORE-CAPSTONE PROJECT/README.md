# 📱 Playstore Capstone Project

## 📖 Overview
The **Playstore Project** is a microservices-based application that replicates the core functionalities of an app marketplace. It allows **Users** to register, browse, download apps, and give reviews, while **Owners** can upload, manage, and update their applications.  

The system is built using **Spring Boot, Microservices, and Spring Cloud** with role-based security and centralized configuration.

---

## 🎯 Problem Statement
In a real-world scenario, both users and app developers (owners) need a platform:  
- **Users** → To search, download, and review applications.  
- **Owners** → To publish, manage, and monitor their apps.  

This project provides a **Playstore-like ecosystem** that bridges the gap between users and owners.

---

## ⚙️ Tech Stack
- **Languages:** Java, SQL, JavaScript  
- **Frontend:** HTML, CSS, jQuery, Bootstrap, Thymeleaf  
- **Backend:** Spring Boot, Spring Framework, Microservices, Hibernate, JPA  
- **Database:** MySQL  
- **APIs & Communication:** Feign Client  
- **Service Discovery & Config:** Spring Cloud Eureka  
- **Security:** JWT  
- **Version Control:** Git & GitHub  

---

## 🏗️ Architecture
The project follows a **Microservices Architecture** with the following services:  

1. **User Service**  
   - User registration & login  
   - Browse apps with filters & categories  
   - Download applications (file handling)  
   - Post reviews & ratings  

2. **Owner Service**  
   - Owner registration & login  
   - Upload apps (supports any file extension)  
   - Update app details (name, description, category)  
   - Manage uploaded apps  

3. **System-Level Services**  
   - **Eureka Server** → Service discovery  
   - **Feign Client** → Service-to-service communication  
   - **Global Exception Handling** → Custom and global error handling  

---

## 🔑 Features
- 👤 **User Module**: Secure registration, login, app browsing, downloads, and reviews.  
- 🧑‍💻 **Owner Module**: Secure registration, app uploads, management, and updates.  
- 🔒 **Security**: JWT authentication   
- ⚡ **Microservices**: Loosely coupled services with independent deployment.  
- 🔔 **(Future Scope)**: Notifications (owner → user).  
- 📂 **File Handling**: App upload & download functionality.  

---

## 📂 Project Structure

playstore-project/
│
├── user-service/ # Handles user-related operations
├── owner-service/ # Handles owner-related operations
├── eureka-server/ # Service discovery

---

## 🚀 How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/playstore-project.git
   cd playstore-project
2. Start **Eureka Server → Owner Service → User Service (in that order).**
3. Access application at:
   -**User Service** → http://localhost:8081
   -**Owner Service** → http://localhost:8082
   -**Eureka Dashboard** → http://localhost:8761

---

# 📌 Annotations Used

-**@RestController** → Create REST APIs
-**@Service** → Service layer
-**@Repository** → Database access layer
-**@Entity** → Map Java class to DB table
-**@Autowired** → Dependency injection
-**@RequestMapping, @GetMapping, @PostMapping** → API endpoints
-**@DiscriminatorValue** → Inheritance mapping in JPA
-**@ExceptionHandler** → Handle specific exceptions
-**@ControllerAdvice** → Global exception handling

---

## 📊 Future Enhancements

-Implement Notification Service (real-time alerts)
-Add Payment Gateway for premium apps

---

# ✍️ Author

Rashik N
