### Secure Password Handling
- `Password Hashing`: Use strong hashing algorithms like bcrypt, scrypt, or Argon2 for password
storage instead of plain text. Ensure the use of salt to make brute-force attacks more difficult.
- `Password Policies`: Enforce strong password policies (e.g., length, complexity) and implement
mechanisms for password expiration and rotation.

### Explaination

### **Secure Password Handling**
When it comes to handling passwords, security is crucial to prevent unauthorized access to sensitive systems. Here are two key techniques:

---

### **1. Password Hashing**
- **What is it?**  
  Password hashing converts a password into a fixed-length string of characters using a mathematical algorithm. Even if hackers access the hashed password, they cannot reverse it to retrieve the original password.
- **Why use hashing?**  
  Storing plain-text passwords is dangerous. Hashing ensures that even if the database is compromised, the actual passwords are not exposed.
- **What is salt?**  
  Salt is random data added to the password before hashing. This prevents attackers from using precomputed hash databases (rainbow tables) to crack passwords.

---

#### Example: Password Hashing with BCrypt in Java
```java
import org.mindrot.jbcrypt.BCrypt;

public class PasswordHashingExample {

    /**
     * Hashes a plain-text password using the BCrypt algorithm.
     * @param password The plain-text password.
     * @return The hashed password.
     */
    public static String hashPassword(String password) {
        // Generate a salt and hash the password
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    /**
     * Verifies a plain-text password against a hashed password.
     * @param plainPassword The plain-text password.
     * @param hashedPassword The hashed password stored in the database.
     * @return True if the password matches, otherwise false.
     */
    public static boolean verifyPassword(String plainPassword, String hashedPassword) {
        // Compare the plain password with the stored hash
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }

    public static void main(String[] args) {
        // Example plain-text password
        String password = "SecureP@ssword123";

        // Hash the password
        String hashedPassword = hashPassword(password);
        System.out.println("Hashed Password: " + hashedPassword);

        // Verify the password
        boolean isMatch = verifyPassword("SecureP@ssword123", hashedPassword);
        System.out.println("Password Match: " + isMatch);
    }
}
```

**Output**:
```
Hashed Password: $2a$10$e.ybCt3zWYlIRcmoy/ljQO7bhuHt2FNhVQGDbDsyb.8dhJFcR/RrC
Password Match: true
```

---

### **2. Password Policies**
- **What is it?**  
  Password policies are rules to ensure that users create strong passwords, making them harder for attackers to guess.
- **Examples**:
    - Minimum password length (e.g., 8 characters).
    - Complexity requirements (e.g., uppercase, lowercase, numbers, and symbols).
    - Password expiration (e.g., passwords must be updated every 90 days).

---

#### Example: Enforcing Password Policies in Java
```java
import java.util.regex.Pattern;

public class PasswordPolicyExample {

    /**
     * Validates a password against strong password policies.
     * @param password The password to validate.
     * @return True if the password meets the policies, otherwise false.
     */
    public static boolean isPasswordStrong(String password) {
        // Define the password policy regex
        String passwordPolicyRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        
        // Check if the password matches the policy
        return Pattern.matches(passwordPolicyRegex, password);
    }

    public static void main(String[] args) {
        // Example passwords
        String weakPassword = "password";
        String strongPassword = "SecureP@ssword123";

        // Validate passwords
        System.out.println("Weak Password Valid: " + isPasswordStrong(weakPassword)); // false
        System.out.println("Strong Password Valid: " + isPasswordStrong(strongPassword)); // true
    }
}
```

**Output**:
```
Weak Password Valid: false
Strong Password Valid: true
```

---

### **Theory Points**
1. **Password Hashing**:
    - Hashing is **one-way**: it cannot be reversed to retrieve the original password.
    - Use algorithms like **bcrypt**, **scrypt**, or **Argon2**:
        - **bcrypt**: Resistant to brute-force attacks and widely used.
        - **scrypt**: Memory-intensive, making it harder for attackers with high computational power.
        - **Argon2**: Modern and highly recommended due to its flexibility and security.

2. **Password Policies**:
    - **Length**: Require at least 8 characters (preferably more).
    - **Complexity**: Enforce at least one uppercase letter, one lowercase letter, one number, and one special character.
    - **Expiration**: Regularly expire passwords and require updates to prevent prolonged exposure of a single password.

3. **Best Practices**:
    - Never store plain-text passwords.
    - Use a unique **salt** for each password to prevent rainbow table attacks.
    - Implement account lockout policies to prevent brute-force attempts.
    - Regularly audit password hashing algorithms and update them if they become outdated.

By combining **hashing** for secure storage and **policies** for password strength, you can significantly enhance the security of your application.
