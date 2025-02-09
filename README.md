# E-Commerce-Project
# 🛒 E-Commerce Website API

This is a **Spring Boot REST API** for an **E-Commerce Website**, supporting **role-based authentication, product management, and discount handling**.  

---

## 🚀 Features

✅ **User Authentication** (Signup & Login)  
✅ **Role-Based Access Control** (Admin, Staff, Buyer, Vendor)  
✅ **Product Management** (Create, Update, Retrieve, Delete)  
✅ **Discount Management**  
✅ **Secure API with JWT Authentication**  
✅ **MySQL Database Integration**  

---

## 🏗️ Tech Stack

- **Backend:** Java, Spring Boot, Spring Security  
- **Database:** MySQL  
- **Authentication:** JWT (JSON Web Tokens)  
- **API Documentation:** Postman Collection  


📌 API Endpoints
Method	Endpoint	Description
POST	/auth/signup	Register a new user
POST	/auth/login	User login & token generation
POST	/api/v1/product/saveOrUpdate	Add or update a product
GET	/api/v1/product/all	Get all products
PUT	/api/v1/product/{id}/discount	Apply a discount to a product
GET	/api/v1/product/products?name=&category=	Search products by name & category
GET	/api/v1/product/{id}	Get a product by ID
