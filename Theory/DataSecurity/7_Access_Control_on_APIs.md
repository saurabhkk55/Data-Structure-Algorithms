### 7. Access Control on APIs
- Limit sensitive API exposure: Ensure APIs handling sensitive data are protected with proper authentication and authorization mechanisms. Use API gateways or rate-limiting techniques to prevent abuse.
- Implement CORS (Cross-Origin Resource Sharing) policies to restrict which domains can access the API to prevent unauthorized cross-origin requests.

### Explaination

### **Access Control on APIs**

When you expose APIs, especially those that handle sensitive data, it is crucial to ensure that only authorized users can access them. This can be done through **authentication** (to verify the user's identity) and **authorization** (to ensure the user has the right to access specific resources).

Additionally, you should control the **rate of requests** and **CORS policies** to ensure your APIs are not abused and that only trusted domains can interact with them.

Let's break this down into the key points:

### **1. Limit Sensitive API Exposure:**

**Authentication & Authorization**: Use authentication mechanisms like **JWT (JSON Web Token)** or **OAuth** to ensure that only authenticated users can access certain APIs. Once a user is authenticated, implement authorization to ensure they only access the resources they are allowed to.

**Rate-Limiting**: Use rate limiting to prevent abuse of the API by limiting how many requests a user can make in a given period. This helps protect against **DoS (Denial of Service) attacks** and **brute force attacks**.

**API Gateway**: An API gateway can help to centralize the security policies and handle things like rate-limiting, authentication, and logging.

---

#### **Code Example for API Authentication and Authorization (JWT):**

```java
// Spring Boot example using JWT for API access control

@RestController
@RequestMapping("/api")
public class MyController {

    // A sample secured API endpoint
    @GetMapping("/secure-data")
    @PreAuthorize("hasRole('USER')") // Only accessible to users with 'USER' role
    public ResponseEntity<String> getSecureData() {
        return ResponseEntity.ok("This is sensitive data!");
    }

    // A login endpoint that generates a JWT token
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserCredentials credentials) {
        // Authenticate user (this should be done using a service)
        if (authenticate(credentials)) {
            String token = jwtTokenProvider.generateToken(credentials.getUsername());
            return ResponseEntity.ok("Bearer " + token);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }

    private boolean authenticate(UserCredentials credentials) {
        // Check username and password
        return "user".equals(credentials.getUsername()) && "password".equals(credentials.getPassword());
    }
}
```

**Explanation**:
- The `/secure-data` endpoint is protected using `@PreAuthorize` with a role-based access control. Only users with the **'USER'** role can access this endpoint.
- The `/login` endpoint provides a JWT token when a user successfully logs in. This token is then used in the `Authorization` header for subsequent API requests.

---

### **2. Implement CORS (Cross-Origin Resource Sharing) Policies:**

**CORS** is a mechanism that allows or restricts web applications running at one origin (domain) to make requests to another domain. Without proper CORS policies, a malicious website could make unauthorized API calls on behalf of a logged-in user.

**CORS Example**:
In Spring Boot, you can configure CORS globally or on a per-controller basis to specify which domains are allowed to access the API.

---

#### **Code Example to Enable CORS in Spring Boot:**

```java
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Allow access to the API only from 'https://trusted-website.com'
        registry.addMapping("/api/**")
                .allowedOrigins("https://trusted-website.com") // Allowed domain
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Allowed methods
                .allowedHeaders("*") // Allow any header
                .allowCredentials(true); // Allow credentials like cookies or authentication tokens
    }
}
```

**Explanation**:
- The `allowedOrigins` method ensures that only **`https://trusted-website.com`** can make requests to the API. Any other origin will be blocked.
- You can also specify allowed HTTP methods (`GET`, `POST`, `PUT`, etc.) and headers that are permitted in the request.

---

### **3. Rate Limiting:**

To implement **Rate Limiting** with **Resilience4j** in a Spring Boot application, you can leverage the **Resilience4j RateLimiter** module, which allows you to limit the rate at which your application performs operations. This is useful for preventing excessive load on your backend services and APIs.

Here’s how you can set it up:

### **3.1. Add Dependencies**
First, you need to add the necessary dependencies for **Resilience4j** and **Spring Boot Starter for Resilience4j** in your `pom.xml` file:

```xml
<dependencies>
    <!-- Resilience4j RateLimiter -->
    <dependency>
        <groupId>io.github.resilience4j</groupId>
        <artifactId>resilience4j-ratelimiter</artifactId>
        <version>1.7.0</version>
    </dependency>

    <!-- Spring Boot Starter Resilience4j -->
    <dependency>
        <groupId>io.github.resilience4j</groupId>
        <artifactId>resilience4j-spring-boot2</artifactId>
        <version>1.7.0</version>
    </dependency>
</dependencies>
```

### **3.2. Configuration in `application.yml`**
You can configure the **RateLimiter** settings in the `application.yml` file.

```yaml
resilience4j.ratelimiter:
  instances:
    myRateLimiter:
      limitForPeriod: 5        # Maximum number of calls allowed in the time period
      limitRefreshPeriod: 1s   # Time period (1 second here)
      timeoutDuration: 500ms   # Timeout for acquiring a permit from the RateLimiter
```

In the configuration above:
- **`limitForPeriod`**: The maximum number of requests allowed in the specified time period.
- **`limitRefreshPeriod`**: The duration of time after which the limit is refreshed (e.g., every second).
- **`timeoutDuration`**: The amount of time the system will wait for a request to acquire a permit from the rate limiter.

### **3.3. Using RateLimiter in Service Layer**
Now, you can use the **RateLimiter** in your service layer to limit the number of requests.

#### **Code Example Using Resilience4j RateLimiter:**

```java
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    // RateLimiter applied here, using 'myRateLimiter' instance defined in application.yml
    @RateLimiter(name = "myRateLimiter", fallbackMethod = "rateLimitFallback")
    public String getRateLimitedData() {
        // Simulate an API call or any sensitive operation
        return "This is rate-limited data!";
    }

    // Fallback method that is invoked when rate limit is exceeded
    public String rateLimitFallback(Exception e) {
        return "Rate limit exceeded. Please try again later.";
    }
}
```

**Explanation**:
- The `@RateLimiter` annotation on the `getRateLimitedData` method applies the rate limiter configuration defined in the `application.yml`.
- The **fallbackMethod** (`rateLimitFallback`) is called if the rate limit is exceeded. This can be used to return a user-friendly message or handle the error gracefully.

### **3.4. Using the RateLimited API in a Controller**

Here’s how you can expose the rate-limited API in your controller:

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private MyService myService;

    @GetMapping("/rate-limited")
    public String getRateLimitedData() {
        // Calling the service method that is rate-limited
        return myService.getRateLimitedData();
    }
}
```

### **3.5. Result:**
- When a user calls the `/rate-limited` endpoint, they will only be able to make a certain number of requests per second as defined in the `application.yml` file.
- If they exceed the rate limit, the **fallback method** will be triggered, and the user will see the message "Rate limit exceeded. Please try again later."

### **Key Concepts Recap:**

1. **Resilience4j RateLimiter**: This is used to control the rate of calls to the service, ensuring that the system doesn't get overwhelmed by excessive requests.
2. **Configuration**: You define rate limiting parameters in `application.yml`, such as how many requests can be processed in a given time window.
3. **Fallback Method**: The fallback method is triggered when the rate limit is exceeded, allowing the system to handle the overflow gracefully by providing meaningful responses to the users.

### **Advantages of Using Resilience4j for Rate Limiting:**
- **Resilience**: It helps make your system more resilient by preventing it from being overwhelmed by traffic.
- **Flexibility**: You can configure rate limiting per method and handle exceptions gracefully using fallback methods.
- **Integration**: Resilience4j integrates seamlessly with Spring Boot, and it can work in conjunction with other resilience patterns like circuit breaking and retries.

By using **Resilience4j**, you get an easy-to-implement, flexible, and robust solution for rate limiting, which is an important aspect of building scalable and secure APIs.

---

### **Best Practices for Access Control on APIs:**

1. **Always Authenticate**: Ensure that APIs handling sensitive data are always protected by authentication mechanisms such as **JWT**, **OAuth**, or **API Keys**.
2. **Use Role-based Authorization**: After authentication, use **roles** or **permissions** to control who can access which resources (e.g., "admin", "user", etc.).
3. **Implement Rate Limiting**: Protect your APIs from abuse by limiting the number of requests a user can make in a given time period.
4. **Use Secure CORS Policies**: Restrict which domains are allowed to access your API to prevent **cross-origin attacks**.

---

By combining these techniques (authentication, authorization, rate limiting, and CORS), you can ensure that your API is both secure and resilient to malicious attacks.