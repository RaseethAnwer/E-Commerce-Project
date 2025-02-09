# 🛒 E-Commerce Website API

This is a **Spring Boot REST API** for an **E-Commerce Website**, supporting **role-based authentication, product management, and discount handling**.  

---

## 🚀 Features

| Feature | Description |
|---------|-------------|
| **User Authentication** | Signup & Login with JWT Security |
| **Role-Based Access** | Admin, Staff, Buyer, Vendor |
| **Product Management** | Add, update, view, and search products |
| **Discount Management** | Apply discounts on products |
| **Secure API** | JWT Authentication for protected routes |
| **Database** | MySQL Integration |

---

## 🏗️ Tech Stack

| Technology | Usage |
|------------|-------|
| **Java** | Backend API |
| **Spring Boot** | Framework for REST APIs |
| **Spring Security** | Authentication & Authorization |
| **MySQL** | Database |
| **JWT** | Secure Token-based Authentication |
| **Postman** | API Testing |

## 📌 API Endpoints

| Method | Endpoint | Description |
|--------|---------|-------------|
| **POST** | `/auth/signup` | Register a new user |
| **POST** | `/auth/login` | User login & token generation |
| **POST** | `/api/v1/product/saveOrUpdate` | Add or update a product |
| **GET** | `/api/v1/product/all` | Get all products |
| **PUT** | `/api/v1/product/{id}/discount` | Apply a discount to a product |
| **GET** | `/api/v1/product/products?name=&category=` | Search products by name & category |
| **GET** | `/api/v1/product/{id}` | Get a product by ID |
| **DELETE** | `/api/v1/product/{id}` | Delete a product by ID |

## 🛠️ Postman Collection

| Tool | Link |
|------|------|
| **Postman Collection** | 📥 [Download Here]((https://bakend-7437.postman.co/workspace/Team-Workspace~15e5d60c-2f3e-4a43-8561-0c991b0f1c8f/collection/41955790-de5f0aa5-efa8-4d44-95f9-58b26f022f03?action=share&creator=41955790)) |




