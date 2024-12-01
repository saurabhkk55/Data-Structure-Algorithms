### 3. Sensitive Data Masking and Tokenization
   - `Data Masking`: Hide sensitive information (e.g., credit card numbers, social security numbers)
   before displaying it to unauthorized users.
   - `Tokenization`: Replace sensitive data with non-sensitive tokens for secure storage and
   processing. This ensures that even if data is exposed, the sensitive information is not leaked.

### Explanation

**Sensitive Data Masking and Tokenization** are techniques used to protect sensitive information, such as credit card numbers or social security numbers, from being exposed to unauthorized users or during processing.

---

### **1. Data Masking**
- **What is it?**  
  Data masking hides parts of sensitive data when displaying it. For example, showing `**** **** **** 1234` instead of the full credit card number.
- **Why is it important?**
    - Prevents unauthorized users from seeing sensitive information.
    - Reduces risk in case of accidental data exposure.

#### Example: Data Masking in Java
```java
public class DataMaskingExample {

    /**
     * Masks a credit card number by showing only the last 4 digits.
     * @param creditCardNumber The full credit card number.
     * @return The masked credit card number (e.g., **** **** **** 1234).
     */
    public static String maskCreditCard(String creditCardNumber) {
        // Replace all digits except the last 4 with asterisks
        return creditCardNumber.replaceAll("\\d(?=\\d{4})", "*");
    }

    public static void main(String[] args) {
        // Example credit card number
        String creditCard = "1234567812345678";
        
        // Mask the credit card number
        String maskedCreditCard = maskCreditCard(creditCard);
        
        // Display the masked credit card number
        System.out.println("Masked Credit Card: " + maskedCreditCard);
    }
}
```

**Output**:
```
Masked Credit Card: ************5678
```

---

### **2. Tokenization**
- **What is it?**  
  Tokenization replaces sensitive data with randomly generated, non-sensitive tokens. For instance, a credit card number `1234567812345678` might be replaced by `TKN-987654321`. The actual sensitive data is stored securely in a separate location (e.g., a token vault).
- **Why is it important?**
    - Protects sensitive data during storage and processing.
    - If data is leaked, only meaningless tokens are exposed.

#### Example: Tokenization in Java
```java
import java.util.HashMap;
import java.util.UUID;

public class TokenizationExample {

    // Simulated token vault to store mappings between tokens and sensitive data
    private static final HashMap<String, String> tokenVault = new HashMap<>();

    /**
     * Generates a token for the given sensitive data and stores it in the token vault.
     * @param sensitiveData The original sensitive data.
     * @return The generated token.
     */
    public static String tokenize(String sensitiveData) {
        // Generate a unique token
        String token = "TKN-" + UUID.randomUUID().toString();
        
        // Store the token and its corresponding sensitive data in the vault
        tokenVault.put(token, sensitiveData);
        
        // Return the token
        return token;
    }

    /**
     * Retrieves the original sensitive data for a given token.
     * @param token The token for which sensitive data is requested.
     * @return The original sensitive data, or null if the token is invalid.
     */
    public static String detokenize(String token) {
        // Retrieve the sensitive data from the token vault
        return tokenVault.get(token);
    }

    public static void main(String[] args) {
        // Example sensitive data (credit card number)
        String creditCard = "1234567812345678";

        // Tokenize the credit card number
        String token = tokenize(creditCard);
        System.out.println("Generated Token: " + token);

        // Detokenize the token to retrieve the original data
        String originalData = detokenize(token);
        System.out.println("Original Data: " + originalData);
    }
}
```

**Output**:
```
Generated Token: TKN-123e4567-e89b-12d3-a456-426614174000
Original Data: 1234567812345678
```

---

### **Theory Points**
1. **Data Masking Use Cases**:
    - Showing masked credit card numbers to customers on a webpage.
    - Displaying partially masked personal information (e.g., `J*** D***`) in logs or dashboards.

2. **Tokenization Use Cases**:
    - Securely storing credit card details for payment processing.
    - Replacing sensitive identifiers like social security numbers with tokens in databases.

3. **Differences Between Masking and Tokenization**:

   | **Aspect**        | **Masking**                              | **Tokenization**                       |
   |---------------|------------------------------------- |--------------------------------------  |
   | **Purpose**       | Hide data when displayed             | Replace data for secure storage        |
   | **Reversibility** | No (masked data cannot be restored)  | Yes (token can be detokenized)         |
   | **Storage**       | Data is still present in raw form    | Sensitive data stored in a token vault |

4. **Best Practices**:
    - Use **data masking** to secure data displayed to unauthorized users.
    - Use **tokenization** to protect data in databases or logs.
    - Store sensitive data and tokens securely (e.g., encrypted vaults or services like AWS Secrets Manager).

By combining **data masking** and **tokenization**, you can ensure your application provides robust protection for sensitive information both during processing and display.
