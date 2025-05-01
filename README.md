# 🛒 Java Online Store System

This project was developed as part of a semester-long **Object-Oriented Programming (OOP)** course.  
It simulates a basic e-commerce platform written entirely in Java, showcasing class hierarchy, modular structure, and exception handling.

---

## 🎯 Project Overview

The system allows buyers and sellers to interact in a virtual marketplace:
- Buyers can register, browse products, add items to their cart, and place orders
- Sellers can add products to their inventory
- Each order is recorded with date and total price
- Cart cloning and order history supported
- Handles invalid inputs and custom exceptions

---

## 💡 Key Features

- 👤 **User management** – Registration of buyers and sellers
- 🛍️ **Product catalog** – Multiple categories and optional packaging
- 🧺 **Cart & Order** – Add/remove items, checkout, track history
- 🔁 **Cart cloning** – Restore past orders into current cart
- 🧾 **Order summary** – Date, items, price
- ⚠️ **Custom exceptions** – Empty cart, invalid strings, negative numbers
- 📦 **OOP principles** – Encapsulation, inheritance, composition
- 🧪 **Tested via console interface**

---

## 📁 Package & Class Structure

All classes are under the package:

```java
package onlinestore;
| Class                            | Description                                          |
|----------------------------------|------------------------------------------------------|
| `Main.java`                      | Runs the program and presents the menu               |
| `Buyer.java`                     | Represents a buyer with cart and orders              |
| `Seller.java`                    | Represents a seller with product list                |
| `Product.java`                   | Base class for store items                           |
| `PackagedProduct.java`           | Product with extra packaging cost                    |
| `Order.java`                     | Represents an order with timestamp & items           |
| `Address.java`                   | Location data for buyers                             |
| `SystemManager.java`             | Core logic for users, products, actions              |
| `ProductList.java`               | Internal list to store products                      |
| `User.java`                      | Common base class for Buyer & Seller                 |
| `eCategory.java`                 | Enum for product categories                          |
| `StringEmptyNullException.java`  | Thrown for empty/null strings                        |
| `NegativeNumException.java`      | Thrown for invalid numbers                           |
| `EmptyCartException.java`        | Thrown when trying to buy from an empty cart         |

```

---

## 🛠️ Compilation & Execution״
To compile and run the project from terminal:
```
javac onlinestore/*.java
java onlinestore.Main

```
---

## 📷 Example Menu Output

```
Welcome to IYR 🛍️
1) Add a seller
2) Add a buyer
3) Add a product for the seller
4) Add a product for the buyer
5) Pay for your products
6) Show buyers
7) Show sellers
8) Show products by category
9) Clone cart from history
0) Exit
```
---

## 🧠 What I Learned
- Designing modular Java applications using OOP
- Creating interactive command-line menus
- Exception handling for domain-specific logic
- Deep use of inheritance, composition, and encapsulation
- Managing user input and validating system behavior

---

## 👤 Author

Itamar Hadad  
B.Sc. Computer Science Student – Afeka Tel Aviv Academic College of Engineering  
Email: hzitamar4@gmail.com  
LinkedIn: https://www.linkedin.com/in/itamar-hadad

---
