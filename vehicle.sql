CREATE DATABASE vehicle_rental_db;

USE vehicle_rental_db;

CREATE TABLE vehicles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(50),
    model VARCHAR(100),
    status VARCHAR(20),
    price DOUBLE
);