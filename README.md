# Product Management System

A backend application built using Spring Boot, Spring Data JPA, and MySQL to manage product information efficiently.

## Features

- Create new products
- Retrieve all products
- Retrieve product by ID
- Update product price and stock quantity
- Delete individual products
- Delete all products
- Find products by category
- Find products with price greater than a given amount
- Automatic stock availability management
- Business rule validation:
  - Price must be positive
  - Stock quantity cannot be negative
  - Zero stock automatically sets status as OUT_OF_STOCK
