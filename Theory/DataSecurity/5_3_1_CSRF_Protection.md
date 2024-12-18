### 5. Input Validation and Data Sanitization
- Cross-Site Request Forgery (CSRF) Protection: Enable CSRF protection, especially in stateful
  applications. Spring Security offers built-in CSRF protection mechanisms.

### Explaination

### **Cross-Site Request Forgery (CSRF) Protection**

**Cross-Site Request Forgery (CSRF)** is a type of security vulnerability where an attacker tricks the user into performing actions they didn't intend to, on a website where the user is authenticated. This is particularly dangerous for stateful applications (where the user's session is maintained across requests), as the attacker can leverage the user's session to execute harmful actions.

For example, if a user is logged into a banking website and the attacker sends a request to transfer funds using the victim’s session, the action would be executed on behalf of the victim without their knowledge.

To prevent CSRF attacks, it's essential to **validate** the requests made by the client, ensuring that they come from an authentic source (i.e., the same website). One common protection mechanism is **CSRF tokens**, which are unique values sent with each request, ensuring that the request is legitimate and not forged by an attacker.

---

### **How CSRF Works:**

Let’s say a victim is logged into a website (for example, a bank) and the attacker sends a request that looks like this:

```html
<img src="http://victim-bank.com/transfer?amount=1000&toAccount=attackerAccount" />
```

The victim's browser will automatically send this request to the bank site, using the victim’s session cookie. The bank would process the request as if the user intended it, even though it was actually initiated by the attacker.

---

### **How CSRF Protection Works:**

To prevent this, we can **enable CSRF protection** in the application. One of the most effective ways is to use a **CSRF token**. This token is a unique value generated by the server, included in every form and request, and checked for validity when the server receives the request. If the token is missing or invalid, the server will reject the request.

### **Steps for CSRF Protection in Spring Security:**

1. **Enable CSRF Protection**: Spring Security enables CSRF protection by default. It automatically generates a unique CSRF token for every form and validates it with each request.
2. **CSRF Token in Forms**: The CSRF token is included in web forms, usually as a hidden input field.
3. **Token Verification**: When the form is submitted, the server verifies that the CSRF token sent in the request matches the token generated when the page was loaded.

### **Example with Spring Security**

In a Spring Boot application, CSRF protection is enabled by default. However, you need to ensure your forms include the CSRF token for POST, PUT, DELETE, or PATCH requests.

#### **1. Spring Security Configuration (Enable CSRF Protection)**

By default, Spring Security enables CSRF protection. However, if you want to customize it, you can do so in your security configuration class:

```java
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf() // Enable CSRF protection
                .and()
            .authorizeRequests()
                .antMatchers("/login", "/register").permitAll() // Allow public access to login/register
                .anyRequest().authenticated(); // Require authentication for other requests
    }
}
```

In this example, **CSRF protection** is enabled by default, and we configure the application to allow public access to the login and register pages.

#### **2. CSRF Token in HTML Forms (Frontend)**

When rendering forms in your HTML pages, you need to ensure that the CSRF token is included. In **Thymeleaf**, you can easily include the token using the `th:action` and `th:name` attributes.

For example, in your HTML form:

```html
<form method="POST" action="/transfer">
    <!-- Include the CSRF token in the form -->
    <input type="hidden" name="_csrf" th:value="${_csrf.token}"/>
    
    <!-- Form fields (e.g., for a bank transfer) -->
    <label for="amount">Amount:</label>
    <input type="text" id="amount" name="amount" required />
    
    <button type="submit">Transfer</button>
</form>
```

- The **`_csrf.token`** is a special variable automatically provided by Spring Security in the Thymeleaf templates.
- This hidden input field contains the CSRF token that will be sent along with the form submission.

When the form is submitted, the CSRF token is sent as part of the request, and Spring Security will check whether it matches the expected token. If the token is missing or incorrect, Spring Security will reject the request and throw a **403 Forbidden** error.

#### **3. CSRF Token in AJAX Requests**

For AJAX requests (like those made using JavaScript), you also need to send the CSRF token with each request. Here’s how you can include the CSRF token in an AJAX request using JavaScript (with jQuery):

```javascript
// Get the CSRF token from the meta tag (or hidden input field)
var csrfToken = $("meta[name='_csrf']").attr("content");

// Include the CSRF token in the request header for AJAX requests
$.ajax({
    url: '/transfer',
    type: 'POST',
    data: {
        amount: 1000,
        toAccount: '12345'
    },
    beforeSend: function(xhr) {
        // Set the CSRF token in the request header
        xhr.setRequestHeader('X-CSRF-TOKEN', csrfToken);
    },
    success: function(response) {
        console.log('Transfer successful');
    },
    error: function(error) {
        console.log('Transfer failed');
    }
});
```

This code sets the CSRF token in the `X-CSRF-TOKEN` header before sending the request. Spring Security will automatically validate this token when the request is received.

### **Key Points to Remember**
1. **CSRF Protection** prevents attackers from performing actions on behalf of a user without their consent.
2. **CSRF Tokens** are unique values included in forms or AJAX requests to validate that the request is coming from an authentic user, not an attacker.
3. **Spring Security** automatically enables CSRF protection by default, and you can customize its behavior in the configuration.
4. **Include CSRF Token in Forms**: For regular forms, make sure to include the CSRF token as a hidden input field.
5. **Include CSRF Token in AJAX**: For AJAX requests, include the token in the request header using JavaScript.

---

### **Summary**

**CSRF Protection** in Spring Security is crucial for defending against unauthorized actions performed by attackers who exploit a user's active session. By ensuring that each form submission or request includes a CSRF token, we can verify that the request is legitimate and not forged by a malicious actor. This mechanism is particularly important in stateful applications where user sessions are maintained.
