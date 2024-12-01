### Question 1:

Let say I am on logged-in SBI bank website then how a hacker can send a request to me? will it share a link to me email or how it will, explain in the simple way.

### Answer 1:

Great question! Let's break it down step by step and explain it in a simple way.

### Scenario: You're logged into your SBI bank website

When you're logged in to your bank website (like SBI), the website typically keeps you logged in by storing a session. This session is identified by a special **cookie** in your browser. Every time you visit the site, your browser automatically sends this session cookie, which tells the website that you're the person logged in.

Now, here’s where **Cross-Site Request Forgery (CSRF)** comes into play.

### **How a CSRF Attack Works:**

1. **The Attacker’s Setup:**
    - The attacker creates a malicious **link** or **website** that performs a harmful action (like transferring money, changing your password, etc.) on the bank’s website.
    - For example, the attacker could create a link like:
      ```
      http://sbi-bank.com/transfer?amount=10000&toAccount=attackerAccount
      ```
    - This link is a **malicious request** designed to transfer money from your account to the attacker’s account.

2. **The Attacker Sends You the Link:**
    - The attacker **sends** this malicious link to you in different ways, like:
        - **Email**: The attacker could send you an email that looks like it’s from SBI or another trusted source.
        - **Social Media**: The attacker could send the link through a direct message.
        - **Fake Website**: The attacker could create a fake website that tricks you into clicking the link.
    - You might receive an email saying, "Click here to verify your account" or "Check out this new offer," which might contain the malicious link.

3. **You Click on the Malicious Link:**
    - Now, as soon as you **click the link**, your browser makes a request to the **SBI bank website**, but here's the critical part: since you're already **logged in**, your browser automatically sends your **session cookie** with the request.
    - The website now sees that you're logged in and thinks that you intended to make the transfer, even though you didn’t actually click anything on the bank’s website yourself.

4. **What Happens on the Bank Website:**
    - The bank website gets the request and sees that it’s coming from an authenticated user (you, who are logged in).
    - Because there’s no check that the request is **actually coming from your bank’s website**, the bank processes it as if you did it intentionally. In this case, it transfers the money from your account to the attacker’s account.
    - The malicious action happens **without you knowing**.

### **How Does CSRF Protection Help?**

To prevent this from happening, the bank’s website needs to **verify** that requests are legitimate. This is done by adding a **CSRF token** to every action or form submission on the website. Here's how:

- When you’re logged in to the SBI website, **every form** or **action** you perform will include a CSRF token (a random value).
- When the bank receives the request, it checks if the token sent with the request matches the token it issued for your session.
- If the token is **missing** or **doesn’t match**, the request is rejected because it’s likely a CSRF attack.

---

### **Summary:**
- The attacker sends you a **malicious link** (via email, social media, etc.).
- You click the link while being **logged into your bank**.
- Your browser sends the request with your **session cookie**, making the bank think that **you** initiated the request.
- The bank processes the malicious request, and harmful actions (like transferring money) are performed **without your knowledge**.

**CSRF protection** works by adding a **token** to every request, ensuring that requests are genuinely coming from the legitimate user and not from a malicious third party trying to exploit your active session.