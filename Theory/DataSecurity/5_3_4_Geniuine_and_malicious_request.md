### Question 1:

Let say i am making request as a geniuine user then how my request will look like how it is going to be different from hacker request?

### Answer 1:

Great question! Let’s break down how your request, as a **genuine user**, will look different from a **hacker’s request** in terms of **CSRF protection**.

### 1. **Request from the Genuine User (Authenticated with CSRF Token)**
When you, as a legitimate user, make a request to the SBI Bank website (or any secure website), the following things happen:

#### **Step 1: Session Cookie**
- Your browser stores a **session cookie** that holds your **authentication information** (like login details).
- This session cookie ensures that you're authenticated on the server side and that the server knows you're the one making the request.

#### **Step 2: CSRF Token**
- For actions that require protection from CSRF attacks (like making a transfer), the website will include a **CSRF token** in your form or as part of the headers (if it’s an AJAX request).
- The CSRF token is unique for your session and is tied to your **login session**.
- When you submit a form (e.g., transferring money), the CSRF token will be sent **along with the form submission** to verify that the request came from you and not a malicious third-party website.

#### **Step 3: How the Request Looks**
Let’s assume you want to transfer money on the bank's website. The request from your browser would include:

1. **Session Cookie** – To verify your identity on the server.
2. **CSRF Token** – This is included either in the **body of the form** (for standard form submissions) or in the **HTTP header** (for AJAX requests).
3. **Other Form Data** – The actual data like the amount to transfer, beneficiary details, etc.

For example:
```http
POST /transfer HTTP/1.1
Host: www.sbibank.com
Cookie: JSESSIONID=abcd1234; CSRF-TOKEN=xyz98765
Content-Type: application/x-www-form-urlencoded
Content-Length: 1024

amount=1000&toAccount=9876543210&csrf_token=xyz98765
```

In this request:
- The **CSRF token** (`csrf_token=xyz98765`) is sent along with the transfer request.
- The **session cookie** (`JSESSIONID=abcd1234`) is sent with the request, showing the server that this is an authenticated request.
- The server will verify that the CSRF token matches what it has stored for your session.

If the CSRF token in the request matches the token stored on the server for your session, the request will be processed, and your money will be transferred.

### 2. **Request from the Malicious Hacker**
Now, let’s imagine the hacker sends a **malicious request** to the server. Here’s how their request will differ from yours:

#### **Step 1: No Session Cookie**
- The hacker doesn’t have access to your **authenticated session** and can’t use your **session cookie** because it is **stored in your browser**.
- The hacker’s request won’t contain your session details or the correct **session cookie** (e.g., `JSESSIONID=abcd1234`).

#### **Step 2: No CSRF Token**
- The hacker doesn’t have access to your CSRF token either because it’s tied to your session and stored in your browser.
- Without your CSRF token, the hacker’s request **cannot include a valid token**.

For example, a hacker might try to send a malicious link like:
```html
<a href="https://www.sbibank.com/transfer?amount=1000&toAccount=9876543210">Click here to transfer money</a>
```

If the hacker somehow tricks you into clicking this link while you are logged in, the request from your browser might look like:
```http
GET /transfer?amount=1000&toAccount=9876543210 HTTP/1.1
Host: www.sbibank.com
Cookie: JSESSIONID=abcd1234
```

This request is **missing the CSRF token**, and because the server expects a CSRF token to validate the action, it will **reject this request**.

### Key Differences Between Genuine and Malicious Requests

#### 1. **Presence of CSRF Token**:
- **Genuine Request**: Contains the correct CSRF token in the body or header.
- **Malicious Request**: Lacks the CSRF token or contains an invalid/forged token.

#### 2. **Session Cookies**:
- **Genuine Request**: Contains valid session cookies that are tied to the authenticated user (you).
- **Malicious Request**: The hacker's request may lack valid session cookies or use cookies from a different session (if the attacker is trying to hijack a session).

#### 3. **Request Source**:
- **Genuine Request**: Comes from the legitimate user's browser and is initiated by the user on the bank's website.
- **Malicious Request**: Comes from an external website, trying to mimic an action on the bank's website using your **authenticated session**.

### Summary
- **Genuine User**: Your request includes your **session cookie**, a **valid CSRF token**, and other legitimate data, which the server uses to verify that the request is coming from you and that it is safe.
- **Malicious Hacker**: The hacker's request either **lacks the CSRF token** or **contains an invalid token**, and because the token doesn't match what the server expects, the request is **rejected**.

In this way, **CSRF protection** ensures that only **genuine requests** coming from your **authenticated session** with a valid CSRF token are processed by the server.