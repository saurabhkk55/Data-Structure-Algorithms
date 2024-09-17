### 1. Instead of writing boilerplate code we can add dependency in the pom.xml?

Yes, in Spring Boot, you can avoid writing boilerplate code by adding specific dependencies to the `pom.xml` file. These dependencies bring in the necessary libraries and configurations automatically, allowing you to focus on building your application instead of manually setting up configurations.

For example:

- Spring Web: To create REST APIs.
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

- Spring Data JPA: For database access using JPA.
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

- Spring Security: For adding security features.
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```

By using these dependencies, Spring Boot will automatically configure the required components, saving time and effort on boilerplate code.

---

### 2. When we add dependency in POM.xml its corresponding library or something else will be loaded into class path and how we have use it in the actual code let say inside controller directory.

When you add a dependency in the `pom.xml`, Maven automatically downloads the corresponding libraries (JAR files) and includes them in the classpath of your project. These libraries are then available for use in your application, including inside controller classes or other components.

How it Works:
1. Add Dependency in pom.xml: When you add a dependency, such as for Spring Web, Maven downloads the necessary JAR files and loads them into the classpath.

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

2. Use in Your Code: You can now use the classes from that library. For example, after adding the Spring Web dependency, you can create a REST controller using the `@RestController` annotation from the Spring Web library.


Example: Using Spring Web in a Controller
After adding the Spring Web dependency, here's how you can use it in your controller:

```java
package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Provided by Spring Web
@RequestMapping("/api")
public class DemoController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }
}
```

Steps:
1. **Maven Dependency**: The spring-boot-starter-web dependency adds the Spring Web framework to your classpath.
2. **Annotations**: You use Spring-provided annotations like @RestController and @GetMapping in your code.
3. **Automatic Configuration**: Spring Boot automatically configures the web server (like Tomcat) and mappings based on these annotations.

In short, adding dependencies to pom.xml automatically brings the required libraries into your classpath, and you can use the provided classes and annotations directly in your code.

---

### 3. How does Spring Boot works?

Spring Boot works by simplifying the development of Java applications, especially those built with the Spring framework. Here's an overview of how Spring Boot operates:

1. **Auto-Configuration**
- Automatic Setup: Spring Boot automatically configures components (like databases, web servers, etc.) based on the dependencies you've included in the `pom.xml` (or `build.gradle`).
- For example, if you add `spring-boot-starter-web`, Spring Boot auto-configures a web server (like Tomcat) without requiring explicit configuration files like `web.xml`.
- 
2. **Embedded Servers**
Spring Boot includes embedded servers like Tomcat, Jetty, or Undertow, which allows you to run applications without needing an external server. This makes development and deployment faster and simpler since your app runs directly with the embedded server.

3. **Spring Boot Starters**
Starter Dependencies: Spring Boot provides “starter” dependencies, which are collections of libraries bundled together for specific functionalities. For example, `spring-boot-starter-data-jpa` includes everything you need for database access with JPA.
Starters reduce the need to manually manage dependencies.

4. **Convention Over Configuration**
Sensible Defaults: Spring Boot follows the principle of convention over configuration. It uses sensible default settings, reducing the need for extensive configuration files (like `applicationContext.xml` or `persistence.xml` in traditional Spring apps).
You can override these defaults with properties in `application.properties` or `application.yml`.

5. **Spring Boot Actuator**
Spring Boot includes Actuator, which provides built-in features for monitoring, metrics, health checks, and application management. This is useful for managing your application in production environments.

6. **Spring Boot Initializer**
Quick Project Setup: Spring Boot includes a tool called Spring Initializr that generates a pre-configured project based on your selected dependencies. It’s a quick way to start a project without manual setup.

7. **DevTools for Development**
Spring Boot has DevTools, which helps speed up the development process by enabling automatic restarts, live reload, and enhanced logging.

8. **Externalized Configuration**
Spring Boot supports externalized configuration, meaning you can store your settings (like database URLs, credentials) in `application.properties` or `application.yml` files, allowing different configurations for different environments (development, testing, production).

**How Spring Boot Works in Practice**
1. **Dependencies**: You add Spring Boot starter dependencies to `pom.xml` (e.g., `spring-boot-starter-web`, `spring-boot-starter-data-jpa`).

2. **Main Class**: You create a main class with the `@SpringBootApplication` annotation, which triggers auto-configuration and component scanning.
```java
@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
```
3. **Annotations and Beans**: Spring Boot uses annotations like `@RestController`, `@Service`, and `@Repository` to define beans. These beans are automatically managed by Spring’s Inversion of Control (IoC) container.

4. **Run Application**: When you run the application (e.g., through an embedded Tomcat server), Spring Boot auto-configures the environment and starts the application.

**Key Features That Make Spring Boot Work**:
- **@SpringBootApplication**: Combines `@Configuration`, `@EnableAutoConfiguration`, and `@ComponentScan`, making it the starting point for Spring Boot apps.
- **Auto-configuration**: Automatically configures beans based on classpath dependencies.
- **Embedded Server**: Runs your application with an embedded server like Tomcat, allowing you to run your app as a standalone service.

In short, Spring Boot works by simplifying the Spring framework with auto-configuration, embedded servers, and default settings to help you focus on building business logic instead of configuring infrastructure.
