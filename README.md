A simple full-stack microservices project built using Spring Boot, React + TypeScript, JWT Authentication, Docker, and Docker Compose.

# Project Overview

This application manages students with full CRUD operations.
It consists of four backend microservices and one React frontend.

1. Service Registry (Eureka Server)

Acts as the central registry.
Keeps track of all microservices.
Other services register themselves here.

2. Auth Service

Handles user login and registration.
Generates JWT tokens for authentication.
Communicates with Student Service using OpenFeign.
The frontend interacts only with this service.

3. Student Service

Performs all student-related operations: Add, List, Update, Delete.
Accepts requests only from the Auth Service.
Validates JWT before executing actions.

4. API Gateway (Optional)

Routes incoming requests to the correct service.
Can add an additional layer of security.

5. Frontend (React + TypeScript)

Provides UI for Login, Register, and Student CRUD.
Sends API requests only to the Auth Service.
Stores JWT in the browser and uses it for secure calls.
Displays student details only when the user is authenticated.

# How the System Works

User registers or logs in → React sends request to Auth Service.
Auth Service verifies credentials → returns JWT token.
React stores the token for secure operations.

For any student operations:
React → Auth Service (with JWT)
Auth Service verifies token
Auth Service → Student Service via OpenFeign
Student Service performs CRUD
Auth Service sends response back to frontend

 Frontend talks only to Auth Service
 Auth Service communicates with Student Service
 Service Registry keeps all services discoverable

# Docker Setup

Each microservice has its own Dockerfile and JAR file.
The frontend also has its own Dockerfile.
All services run together using docker-compose.

 # Run All Services
docker-compose up --build

# Stop All Services
docker-compose down

# Project Structure
/service-registry
/auth-service
/student-service
/api-gateway (if present)
/frontend-react
docker-compose.yml# Student_Management_Application_
This project is the Demo for Full Stack Application Developement
