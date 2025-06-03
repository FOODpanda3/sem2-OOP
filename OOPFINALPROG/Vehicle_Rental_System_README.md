
# Vehicle Rental System

## Project Overview
This is a Java Swing-based Vehicle Rental System application that allows users to rent, return vehicles, and view rental receipts. It uses MySQL as the backend database to store vehicle information and rental status.

---

## Requirements

- **Java Development Kit (JDK) 8 or higher**
- **MySQL Server** installed and running
- **NetBeans IDE** (recommended for easier project management)
- **MySQL Connector/J (JDBC driver)** for database connection

---

## Setup Instructions

### 1. Clone or Download the Project
Download the project source code from the GitHub repository (or your local copy).

### 2. Set up the MySQL Database
- Open MySQL Workbench or any MySQL client.
- Create a new database, e.g., `vehicle_rental_db`.
- Run the provided SQL script to create the necessary tables (`vehicles` table and others if applicable).
- Example table schema:
```sql
CREATE TABLE vehicles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    model VARCHAR(100),
    type VARCHAR(50),
    price DOUBLE,
    status VARCHAR(20)
);
```
- Insert sample data into the `vehicles` table.

### 3. Configure Database Connection
- Open the `DBconnection.java` file in your project.
- Update the database URL, username, and password to match your MySQL setup.
```java
String url = "jdbc:mysql://localhost:3306/vehicle_rental_db";
String user = "your_mysql_username";
String password = "your_mysql_password";
```

### 4. Add MySQL JDBC Driver to the Project
- Download the MySQL Connector/J driver from the official site.
- Add the JAR file to your project libraries in NetBeans:
  - Right-click the project → Properties → Libraries → Add JAR/Folder → Select the Connector/J JAR.

### 5. Run the Application
- Open the main class `AdminDashboard.java` or the starting JFrame class.
- Run the project (Right-click → Run).
- The GUI will launch, and you can navigate through Rent, Return, and Receipt features.

---

## Features

- **Rent Vehicles:** Mark available vehicles as rented.
- **Return Vehicles:** Change rented vehicles back to available status.
- **View Receipts:** Display all currently rented vehicles and total cost.
- **Logout:** Exit the system securely.

---

## Troubleshooting

- **Database Connection Issues:** Check your database URL, username, and password. Ensure MySQL server is running.
- **JDBC Driver Not Found:** Make sure the MySQL Connector/J JAR is properly added to the project libraries.
- **GUI Does Not Appear:** Check for exceptions in the console, especially SQL errors or null pointers.

---

## Author
Jassen
