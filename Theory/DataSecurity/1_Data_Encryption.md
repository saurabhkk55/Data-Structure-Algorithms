### 1. Data Encryption
   - `Encrypt data at rest`: Use encryption mechanisms such as AES or RSA to ensure that sensitive
   data like passwords or personal information is stored securely in databases, files, or any other
   storage.
   - `Encrypt data in transit`: Implement TLS (Transport Layer Security) to secure data transmission
   between the client and server, preventing eavesdropping and tampering during communication.


### Explaination

**Data Encryption** is about making sure your sensitive information is secure whether it’s stored (data at rest) or being sent between systems (data in transit). Let’s break it into two parts:

---

### **1. Encrypting Data at Rest**
When data is stored, like in databases or files, we use encryption to scramble it so that no one can understand it without a special key. Common encryption techniques include AES (Advanced Encryption Standard).

#### Why Encrypt Data at Rest?
- Protect sensitive data in case the storage device (e.g., database or hard drive) is stolen or hacked.
- Ensure compliance with regulations (e.g., GDPR, HIPAA).

#### Example: AES Encryption in Java
Below is an example to encrypt and decrypt data using AES in Java.

```java
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class EncryptionExample {

    /**
     * Encrypts the given data using AES encryption.
     * @param data The plaintext data to encrypt.
     * @param key The secret key used for encryption.
     * @return The encrypted data in Base64 format.
     * @throws Exception If encryption fails.
     */
    public static String encrypt(String data, SecretKey key) throws Exception {
        // Create a Cipher instance for AES encryption
        Cipher cipher = Cipher.getInstance("AES");

        // Initialize the cipher in encryption mode with the secret key
        cipher.init(Cipher.ENCRYPT_MODE, key);

        // Encrypt the data and return it as a Base64-encoded string
        byte[] encryptedData = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedData);
    }

    /**
     * Decrypts the given encrypted data using AES decryption.
     * @param encryptedData The encrypted data in Base64 format.
     * @param key The secret key used for decryption.
     * @return The original plaintext data.
     * @throws Exception If decryption fails.
     */
    public static String decrypt(String encryptedData, SecretKey key) throws Exception {
        // Create a Cipher instance for AES decryption
        Cipher cipher = Cipher.getInstance("AES");

        // Initialize the cipher in decryption mode with the secret key
        cipher.init(Cipher.DECRYPT_MODE, key);

        // Decode the Base64 string and decrypt the data
        byte[] decodedData = Base64.getDecoder().decode(encryptedData);
        byte[] originalData = cipher.doFinal(decodedData);
        return new String(originalData);
    }

    public static void main(String[] args) throws Exception {
        // Generate a secret key for AES encryption
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // Set the key size to 128 bits
        SecretKey secretKey = keyGen.generateKey();

        // Example plaintext data to encrypt
        String originalData = "SensitiveInformation123";

        // Encrypt the plaintext data
        String encryptedData = encrypt(originalData, secretKey);

        // Decrypt the encrypted data
        String decryptedData = decrypt(encryptedData, secretKey);

        // Print the results
        System.out.println("Original Data: " + originalData);
        System.out.println("Encrypted Data (Base64): " + encryptedData);
        System.out.println("Decrypted Data: " + decryptedData);
    }
}
```

---

### **2. Encrypting Data in Transit**
When data is being sent over the internet (like when you log in to a website), encryption ensures that no one can "listen in" or tamper with the data. For this, we use protocols like **TLS (Transport Layer Security)**.

#### Why Encrypt Data in Transit?
- Prevent hackers from intercepting sensitive information like passwords or credit card details.
- Ensure data integrity, so the data isn’t altered during transmission.

#### Example: Using HTTPS in Java (Securing Data in Transit)
If you’re building a web app, make sure to use HTTPS (which is essentially HTTP over TLS). Here’s how you can make a secure HTTPS request in Java:

```java
import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class SecureConnectionExample {

    public static void main(String[] args) {
        try {
            // Define the URL to connect to, making sure it's HTTPS
            URL url = new URL("https://your-secure-server.com");

            // Open an HTTPS connection to the URL
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();

            // Set the request method to GET (can be POST, PUT, etc.)
            connection.setRequestMethod("GET");

            // Establish the connection and read the response
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                // Print each line of the server's response
                System.out.println(line);
            }

            // Close the reader to free up resources
            reader.close();

        } catch (Exception e) {
            // Handle exceptions such as invalid URLs or connection errors
            e.printStackTrace();
        }
    }
}
```

---

### Theory Points for Better Understanding
1. **Keys and Algorithms**:
    - **Symmetric Encryption (e.g., AES)**: The same key is used to encrypt and decrypt the data. Fast and good for large data.
    - **Asymmetric Encryption (e.g., RSA)**: Uses a pair of keys (public and private). Slower but ideal for secure key exchange.

2. **TLS for Data in Transit**:
    - TLS uses asymmetric encryption to establish a secure connection and then switches to symmetric encryption for actual data transfer.

3. **Use Best Practices**:
    - Always store encryption keys securely (e.g., AWS Secrets Manager, HashiCorp Vault).
    - Never hardcode keys in your code.
    - Use industry-standard libraries for encryption (like Java's `javax.crypto` or Python's `cryptography`).

By combining encryption at rest (like AES) and encryption in transit (TLS/HTTPS), you ensure that your data is secure no matter where it is.
