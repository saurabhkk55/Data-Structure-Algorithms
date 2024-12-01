### Question 1:

ORMs (Object-Relational Mappers): Tools like Hibernate abstract database queries and inherently protect against injection attacks.

explain meaning of abstract here.

### Answer 1:

In the context of **ORMs (Object-Relational Mappers)** like Hibernate, the term **abstract** means **hiding the underlying complexity of database operations**. ORMs provide a higher-level interface to interact with the database, allowing developers to work with objects and methods in their programming language instead of writing raw SQL queries.

---

### **Detailed Explanation**

When we say that ORMs **abstract** database queries, we mean they:
1. **Provide a simplified layer**: Instead of directly writing SQL, developers use object-oriented programming concepts (e.g., classes, methods) to perform database operations.
2. **Handle low-level details**: The ORM translates the high-level commands into optimized SQL queries, manages connections, and ensures proper parameterization to prevent issues like SQL injection.
3. **Improve readability**: By abstracting raw SQL, the code becomes easier to read and maintain.

---

### **Example**

**Without Abstraction (Using SQL Queries Directly):**
Developers write raw SQL and manually handle parameters, connections, and query execution:
```java
String query = "SELECT * FROM users WHERE username = ? AND password = ?";
PreparedStatement stmt = connection.prepareStatement(query);
stmt.setString(1, username);
stmt.setString(2, password);
ResultSet rs = stmt.executeQuery();
```

**With Abstraction (Using an ORM like Hibernate):**
The ORM provides a simpler, more intuitive way to interact with the database:
```java
User user = userRepository.findByUsernameAndPassword(username, password);
```
Here:
- `userRepository.findByUsernameAndPassword(...)` is a high-level abstraction provided by the ORM.
- Hibernate generates and executes the SQL query under the hood.

---

### **Benefits of Abstraction in ORMs**
1. **Reduced Complexity**: Developers focus on business logic, not SQL intricacies.
2. **Improved Security**: Automatically prevents vulnerabilities like SQL injection.
3. **Portability**: Abstracted queries work across different databases without modification.
4. **Maintainability**: Object-oriented approach simplifies code updates and debugging.

By abstracting database interactions, ORMs like Hibernate make application development faster, safer, and more developer-friendly.
