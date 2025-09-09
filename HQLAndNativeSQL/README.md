# Employee CRUD Operations with Hibernate

This project demonstrates fundamental CRUD operations—**Create**, **Read**, **Update**, and **Delete**—on an `Employee` entity using Hibernate ORM in Java.

## Versions Included

1. **HQLDemo.java** – Implements CRUD operations using Hibernate Query Language (HQL).
2. **NativeSQLDemo.java** – Implements CRUD operations using native SQL queries.

## Features

- **Add Employee:** Create and insert a new employee record.
- **View Employee by ID:** Retrieve employee details using their unique ID.
- **Update Employee Email:** Change the email address of an existing employee.
- **Delete Employee by ID:** Remove an employee record from the database.
- **View All Employees:** List details of all employees.
- **Exit Program:** Safely close resources and terminate the application.

## HQL vs Native SQL

| Feature           | HQL                          | Native SQL                  |
|-------------------|------------------------------|-----------------------------|
| Query Syntax      | Uses entity/class names       | Uses table/column names      |
| Example           | `from Employee`               | `SELECT * FROM employee1`    |
| Portability       | Database-independent          | Database-specific            |
| Performance       | Optimized by Hibernate        | Depends on DB implementation |
| Flexibility       | Limited to mapped entities    | Full SQL capabilities        |


## Author

**Rashik N.**
