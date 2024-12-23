# 🍽️ Restaurant Management System

## 📚 Overview
This is a **Restaurant Management System** developed using **Spring Boot**, **JTE templates**, **Spring Security**, **WebSockets**, **MySQL**, and more. It helps manage restaurant orders, customer interactions, and administrative tasks with real-time updates. 

### ⚙️ Technologies Used:
- **Spring Boot**: Backend framework to handle REST APIs and business logic. 🖥️
- **JTE Templates**: A modern template engine for rendering dynamic HTML pages. 💻
- **Spring Security**: For managing authentication and authorization of users. 🔐
- **WebSockets**: For real-time communication between the frontend and backend (e.g., order updates, notifications). 💬
- **MySQL**: Database for storing orders, user details, menu items, etc. 🗃️

## 🚀 Features
- **Admin Panel**: Allows restaurant admins to manage orders, add new dishes in the menu, view customer requests, and perform administrative tasks. 🧑‍💼
- **Customer Ordering**: Customers can browse the menu, place orders, and make payments. 🍽️
- **Real-Time Updates**: WebSockets provide real-time updates to admins about the status of customer orders. 🔄
- **Security**: The system uses **Spring Security** to protect the admin routes and provide user login functionality. 🛡️
- **QR Code Ordering**: Customers can scan a QR code to view the menu and place orders directly from their mobile device. 📱

## 🛠️ Prerequisites
- Java 17 or above ☕
- MySQL 8 or above 🗄️
- Maven or Gradle for dependency management 📦

### 📱 QR Code for Ordering

The QR code below directs customers to the food ordering page, where they can view the menu and place orders.

![QR Code for Ordering](https://cheflink.onrender.com/qr)

- **Login Page**: Provides login functionality for admin users. 🔑  
  URL: [Login](https://cheflink.onrender.com/login)

- **Order Dashboard**: Admins can view active and completed orders. 📊  
  URL: [Order Dashboard](https://cheflink.onrender.com/admin)
  
- **Admin Dashboard**: Admins can add new dishes to the menu with dish images directly sotred in cloud. 📊  
  URL: [Add Dish Dashboard](https://cheflink.onrender.com/addItem)

- **For Demonstration**:
  - Sample Username: **Keshav Sharma**  
  - Sample Password: **04122004** 🔑

## 🚀 Running the Application

To run the application locally, follow these steps:

1. **Clone the repository**:

    ```sh
    https://github.com/Medhansh-32/Resturant-Management-System.git
    ```

2. **Provide the your credentials like MySQL Data Source Url, username, password and client ID for imgur cloud in application.properties**:

    ```sh
    spring.datasource.url=
    spring.datasource.username=
    spring.datasource.password=
    client_id=
    ```

3. **Build and run the application using Maven or Gradle**:

    ```sh
    ./mvnw spring-boot:run
    ```

   or

    ```sh
    ./gradlew bootRun
    ```

## 🤝 Contributing

If you would like to contribute to this project, please fork the repository and submit a pull request. Make sure to include tests for any new features or bug fixes.

For any issues or feature requests, please create an issue in the GitHub repository. 🐛

