### 5. Input Validation and Data Sanitization
- `SQL Injection Prevention`: Use parameterized queries or an ORM like Hibernate to prevent SQL
  injection attacks.

### Explaination

### Input Validation and Data Sanitization: SQL Injection Prevention

**SQL Injection** is a security vulnerability where attackers inject malicious SQL code into input fields to manipulate or gain unauthorized access to the database.

---

### **How SQL Injection Works**
Imagine you have a login page, and a malicious user enters the following input:
- Username: `admin`
- Password: `' OR '1'='1`

If the application executes this input directly in an SQL query like:
```sql
SELECT * FROM users WHERE username = 'admin' AND password = '' OR '1'='1';
```
The query always evaluates to true because `'1'='1'` is a valid condition, granting unauthorized access.

---

### **How to Prevent SQL Injection**
1. **Parameterized Queries**: Use placeholders (`?`) in SQL queries to separate SQL code from user inputs. This ensures that user input is treated as data, not executable code.
2. **ORMs (Object-Relational Mappers)**: Tools like Hibernate abstract database queries and inherently protect against injection attacks.

---

### **Example 1: Using Parameterized Queries (JDBC)**

#### Code Implementation
```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SqlInjectionPrevention {

    public static void main(String[] args) {
        String userInput = "admin"; // Simulated user input
        String passwordInput = "password123"; // Simulated user input

        try {
            // Establish database connection
            Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mydb", "username", "password");

            // Parameterized query to prevent SQL injection
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Bind user inputs to the query
            preparedStatement.setString(1, userInput); // Sets the username
            preparedStatement.setString(2, passwordInput); // Sets the password

            // Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Check if user exists
            if (resultSet.next()) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Invalid username or password.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

#### Explanation
- **`?` in the Query**: Acts as a placeholder for user inputs, ensuring the SQL syntax is not altered.
- **`setString()` Method**: Safely binds user-provided values to the query.

---

### **Example 2: Using Hibernate ORM**

#### Code Implementation
```java
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;

@Entity
@Table(name = "users")
public class User {
    @Id
    private Long id;
    private String username;
    private String password;

    // Getters and setters omitted for brevity
}

@Repository
public class UserRepository {
    
    @Autowired
    private EntityManager entityManager;

    public User findByUsernameAndPassword(String username, String password) {
        // Use a typed query for secure database access
        String jpql = "SELECT u FROM User u WHERE u.username = :username AND u.password = :password";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
        query.setParameter("username", username);
        query.setParameter("password", password);

        return query.getResultList().stream().findFirst().orElse(null);
    }
}
```

#### Explanation
- **JPQL (Java Persistence Query Language)**: Abstracts SQL queries and ensures proper escaping.
- **`setParameter()` Method**: Safely binds user-provided inputs.

---

### **Best Practices for Preventing SQL Injection**
1. **Never Concatenate User Inputs**: Avoid constructing SQL queries with user inputs directly.
   ```java
   String query = "SELECT * FROM users WHERE username = '" + userInput + "'"; // Unsafe!
   ```
2. **Validate Inputs**: Ensure the input matches expected formats (e.g., username should not contain special characters).
3. **Use ORM Tools**: Prefer Hibernate or JPA for database interactions, as they inherently mitigate injection risks.
4. **Limit Database Privileges**: Restrict database user permissions to prevent unnecessary data exposure.
5. **Enable Logging**: Log unexpected or suspicious query patterns for investigation.

---

### **Conclusion**
Using **parameterized queries** or **ORMs** is essential to prevent SQL injection. These techniques ensure that user inputs are treated as data and not executable code, protecting your database from malicious attacks. This simple yet powerful approach greatly improves your application’s security.
