A lambda function (or lambda expression) in Java is an anonymous function (a function without a name). It is primarily used to provide the implementation of a functional interface. A functional interface is an interface that has exactly one abstract method (SAM - Single Abstract Method). Instead of using traditional classes or anonymous inner classes to implement the method, you can use a lambda expression to give a concise, inline implementation.

CODE-1: demonstrates how a lambda expression can be used to implement a method of a functional interface in Java:
```java
// Define a functional interface with a single abstract method
@FunctionalInterface
interface Greeting {
    void sayHello(String name);
}

public class LambdaExample {
    public static void main(String[] args) {
        // Using a lambda expression to provide implementation for the sayHello method
        Greeting greeting = (name) -> System.out.println("Hello, " + name);

        // Calling the method of the functional interface
        greeting.sayHello("Saurabh");  // Output: Hello, Saurabh
    }
}
```

CODE-2: The same code would look without using a lambda expression. In this version, we implement the functional interface using an anonymous inner class:
```java
// Define a functional interface with a single abstract method
@FunctionalInterface
interface Greeting {
    void sayHello(String name);
}

public class LambdaExample {
    public static void main(String[] args) {
        // Using an anonymous inner class to provide implementation for the sayHello method
        Greeting greeting = new Greeting() {
            @Override
            public void sayHello(String name) {
                System.out.println("Hello, " + name);
            }
        };

        // Calling the method of the functional interface
        greeting.sayHello("Saurabh");  // Output: Hello, Saurabh
    }
}
```

##################################################################################################

Lambda expressions in Java provide a concise way to represent anonymous functions (functions without a name). They offer several key features that enhance code readability and maintainability. Let’s explore the features you mentioned:

##################################################################################################

### 1. Lambda Expressions as Method Parameters

**Explanation:**
Lambda expressions can be passed as parameters to methods, which allows for more flexible and functional programming styles. This feature is particularly useful for scenarios where you want to specify behavior without creating separate classes or implementing interfaces explicitly.

**Example:**
Suppose you have a method that performs an operation on two integers, and you want to specify the operation behavior using a lambda expression.

```java
@FunctionalInterface
interface Operation {
    int apply(int a, int b);
}

public class LambdaExample {
    public static void main(String[] args) {
        // Pass a lambda expression as a parameter
        int result = performOperation(5, 3, (a, b) -> a + b);
        System.out.println("Result: " + result);  // Output: Result: 8
    }

    public static int performOperation(int a, int b, Operation operation) {
        return operation.apply(a, b);
    }
}
```

In this example:
- `Operation` is a functional interface with a single abstract method `apply`.
- The `performOperation` method takes an `Operation` as a parameter and applies it to the integers.
- A lambda expression `(a, b) -> a + b` is passed to `performOperation` to define the addition operation.

### 2. Standalone Lambda Expressions

**Explanation:**
Lambda expressions do not need to belong to a class. They are standalone, meaning you can use them directly in expressions or as method arguments without the need for a separate class or explicit class implementation.

**Example:**
Here’s an example showing how a lambda expression can be used directly within a method call.

```java
import java.util.Arrays;
import java.util.List;

public class LambdaStandaloneExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // Use a lambda expression directly
        names.forEach(name -> System.out.println(name));
    }
}
```

In this example:
- `names.forEach(name -> System.out.println(name));` uses a lambda expression to print each name in the list.
- The lambda expression `name -> System.out.println(name)` is standalone and not tied to a specific class.

### Summary

- **Passing as Method Parameters**: Lambda expressions can be passed as arguments to methods, allowing you to specify behavior dynamically without creating additional classes.
- **Standalone Use**: Lambda expressions can be used directly in expressions or method calls, providing a concise way to implement functional interfaces without extra boilerplate code.

##################################################################################################


### What are the various categories of pre-defined function interfaces?
ANS)
In Java, there are several pre-defined functional interfaces in the java.util.function package, introduced in Java 8, which are categorized based on the number and types of parameters and return values they handle.

| Functional Interface | Number of Arguments | Return Type |
|----------------------|---------------------|-------------|
| **Supplier**          | 0                   | T           |
| **Consumer**          | 1                   | void        |
| **BiConsumer**        | 2                   | void        |
| **Function**          | 1                   | R           |
| **BiFunction**        | 2                   | R           |
| **Predicate**         | 1                   | boolean     |
| **UnaryOperator**     | 1 (Same Type)       | T           |
| **BinaryOperator**    | 2 (Same Type)       | T           |


### 1. **Supplier**
A `Supplier` doesn't take any arguments but returns a value.

```java
import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "Hello from Supplier!";
        System.out.println(supplier.get());  // Output: Hello from Supplier!
    }
}
```

### 2. **Consumer**
A `Consumer` takes one argument but doesn’t return a result.

```java
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        Consumer<String> consumer = message -> System.out.println("Consumed: " + message);
        consumer.accept("Hello from Consumer!");  // Output: Consumed: Hello from Consumer!
    }
}
```

### 3. **BiConsumer**
A `BiConsumer` takes two arguments and doesn't return a result.

```java
import java.util.function.BiConsumer;

public class BiConsumerExample {
    public static void main(String[] args) {
        BiConsumer<String, Integer> biConsumer = (name, age) -> System.out.println(name + " is " + age + " years old.");
        biConsumer.accept("John", 30);  // Output: John is 30 years old.
    }
}
```

### 4. **Function**
A `Function` takes one argument and returns a result.

```java
import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        Function<Integer, String> function = number -> "The number is " + number;
        String result = function.apply(5);  // result: "The number is 5"
        System.out.println(result);  // Output: The number is 5
    }
}
```

### 5. **BiFunction**
A `BiFunction` takes two arguments and returns a result.

```java
import java.util.function.BiFunction;

public class BiFunctionExample {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> biFunction = (a, b) -> a + b;
        int sum = biFunction.apply(10, 20);  // sum: 30
        System.out.println("Sum: " + sum);  // Output: Sum: 30
    }
}
```

### 6. **Predicate**
A `Predicate` takes one argument and returns a boolean result (typically used for condition checks).

```java
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {
        Predicate<String> predicate = str -> str.length() > 5;
        boolean result = predicate.test("HelloWorld");  // result: true
        System.out.println(result);  // Output: true
    }
}
```

### 7. **UnaryOperator**
A `UnaryOperator` is a specialized `Function` that takes one argument and returns a result of the same type.

```java
import java.util.function.UnaryOperator;

public class UnaryOperatorExample {
    public static void main(String[] args) {
        UnaryOperator<Integer> unaryOperator = number -> number * 2;
        int result = unaryOperator.apply(10);  // result: 20
        System.out.println(result);  // Output: 20
    }
}
```

### 8. **BinaryOperator**
A `BinaryOperator` is a specialized `BiFunction` that takes two arguments of the same type and returns a result of the same type.

```java
import java.util.function.BinaryOperator;

public class BinaryOperatorExample {
    public static void main(String[] args) {
        BinaryOperator<Integer> binaryOperator = (a, b) -> a * b;
        int product = binaryOperator.apply(4, 5);  // product: 20
        System.out.println("Product: " + product);  // Output: Product: 20
    }
}
```

##################################################################################################


### What are static methods in Interfaces?
ANS)
In Java, interfaces can have static methods in addition to instance methods and default methods. Static methods in interfaces are a feature introduced in Java 8.

### Characteristics of Static Methods in Interfaces:

1. **Defined in the Interface**:
   - Static methods are defined in the interface itself, not in the implementing classes.

2. **Called on the Interface**:
   - Static methods can only be called on the interface itself, not on instances of classes that implement the interface.

3. **Cannot Be Overridden**:
   - Unlike instance methods or default methods, static methods cannot be overridden by implementing classes.

4. **No Access to Instance Fields or Methods**:
   - Static methods do not have access to instance fields or methods of the implementing classes.

5. **Use Case**:
   - Static methods in interfaces are often used for utility or helper functions related to the interface.

### Example of Static Methods in Interfaces:

Here’s an example demonstrating how to define and use static methods in an interface:

```java
interface MathUtils {
    // Static method in the interface
    static int add(int a, int b) {
        return a + b;
    }

    // Abstract method to be implemented by classes
    int multiply(int a, int b);
}

class MathOperations implements MathUtils {
    // Implementing the abstract method
    @Override
    public int multiply(int a, int b) {
        return a * b;
    }
}

public class StaticMethodExample {
    public static void main(String[] args) {
        // Calling the static method on the interface
        int sum = MathUtils.add(5, 10);
        System.out.println("Sum: " + sum);  // Output: Sum: 15

        // Creating an instance of a class that implements the interface
        MathOperations operations = new MathOperations();
        int product = operations.multiply(5, 10);
        System.out.println("Product: " + product);  // Output: Product: 50
    }
}
```

##################################################################################################

### What is the default method, and why is it required?
ANS)
- Default Method: A default method in an interface is a method with a concrete implementation provided directly in the interface. It uses the default keyword to specify this behavior.
- No Obligation to Override: Classes that implement the interface are not required to override the default method. If they do not provide their own implementation, the default implementation from the interface is used.
- Option to Override: If an implementing class needs a different behavior for the default method, it can override the default method with its own implementation.
```java
interface Animal {
    // Default method
    default void makeSound() {
        System.out.println("Some generic animal sound");
    }

    // Abstract method
    void eat();
}

class Dog implements Animal {
    @Override
    public void eat() {
        System.out.println("Dog is eating.");
    }
    
    // Optionally, you can override the default method if needed
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }
}

public class DefaultMethodExample {
    public static void main(String[] args) {
        Animal myDog = new Dog();
        myDog.makeSound();  // Output: Dog barks (overridden)
        myDog.eat();        // Output: Dog is eating.
    }
}
```

##################################################################################################

Can a functional interface extend/inherit from another interface?
ANS)
Yes, a functional interface can extend or inherit from another interface, including other functional interfaces. However, there are specific rules and conditions that need to be met for this to be valid:

### Examples

#### Example 1: Functional Interface Extending Another Functional Interface

```java
@FunctionalInterface
interface BasicOperation {
    int operate(int a, int b); // by-default is abstract method in interface
}

@FunctionalInterface
interface AdvancedOperation extends BasicOperation {
    // Inherits operate(int a, int b) from BasicOperation
}
```

In this example, `AdvancedOperation` is still a functional interface because it inherits exactly one abstract method from `BasicOperation`.

#### Example 2: Functional Interface with Additional Abstract Method

```java
@FunctionalInterface
interface BasicOperation {
    int operate(int a, int b);
}

@FunctionalInterface
interface ComplexOperation extends BasicOperation {
    // This would cause a compilation error because it introduces an additional abstract method
    int additionalOperation(int a);
}
```

In this example, `ComplexOperation` is not a valid functional interface because it introduces an additional abstract method, `additionalOperation(int a)`, making the total count of abstract methods more than one.

#### Example 3: Functional Interface with Default Methods

```java
@FunctionalInterface
interface BasicOperation {
    int operate(int a, int b);

    // Default method
    default int doubleOperation(int a, int b) {
        return operate(a, b) * 2;
    }
}

@FunctionalInterface
interface AdvancedOperation extends BasicOperation {
    // Still a functional interface because it only inherits the single abstract method
}
```

In this example, `AdvancedOperation` is still a valid functional interface because it inherits exactly one abstract method, even though `BasicOperation` includes a default method.

### Summary

- A functional interface can extend another interface as long as it maintains exactly one abstract method.
- Inheriting default methods does not affect the functional interface status.
- Adding additional abstract methods in the extending interface would disqualify it from being a functional interface.

##################################################################################################
### What are functional or SAM interfaces?

Functional interfaces, also known as Single Abstract Method (SAM) interfaces, are a special kind of interface introduced in Java 8. They are designed to work with lambda expressions and method references, providing a way to represent single-method contracts.

### Key Characteristics of Functional Interfaces

1. **Single Abstract Method (SAM)**:
   - A functional interface has exactly one abstract method. This is the method that lambda expressions or method references will implement.

2. **Default and Static Methods**:
   - Functional interfaces can have multiple default methods and static methods, which do not affect the functional interface status. These methods have implementations and do not count as abstract methods.

3. **Annotated with `@FunctionalInterface`**:
   - The `@FunctionalInterface` annotation is optional but recommended. It serves as documentation and allows the compiler to enforce that the interface adheres to the functional interface contract (i.e., it has only one abstract method).

### Examples of Functional Interfaces

#### Basic Example

```java
@FunctionalInterface
interface MyFunctionalInterface {
    // Single abstract method
    void performAction();
}
```

#### Using Lambda Expression

```java
public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        // Implementing the functional interface using a lambda expression
        MyFunctionalInterface action = () -> System.out.println("Action performed!");
        action.performAction();  // Output: Action performed!
    }
}
```

##################################################################################################

`Metaspace` and `PermGen` (Permanent Generation) are both memory areas used by the Java Virtual Machine (JVM) to store metadata related to classes and methods. However, they differ in their management and implementation.

### PermGen (Permanent Generation)

**PermGen** is an area of memory in the JVM used prior to Java 8 for storing:

1. **Class Metadata**: Information about loaded classes, such as their structure and methods.
2. **Method Metadata**: Information related to method bodies and other related structures.
3. **Interned Strings**: Strings that are interned by the JVM.

#### Characteristics:
- **Fixed Size**: PermGen had a fixed size, which meant that if the PermGen space was full, it could lead to `OutOfMemoryError` related to PermGen.
- **Garbage Collection**: PermGen was collected during full garbage collections, which could lead to performance issues and long GC pauses.
- **Configuration**: The size of PermGen could be adjusted using JVM flags such as `-XX:PermSize` and `-XX:MaxPermSize`.

### Metaspace

**Metaspace** was introduced in Java 8 as a replacement for PermGen. It handles the same type of metadata but with some significant changes:

1. **Class Metadata**: Just like PermGen, Metaspace stores information about loaded classes.
2. **Method Metadata**: Stores information about method implementations and structures.
3. **Interned Strings**: Although interned strings are still present, they are managed differently.

#### Characteristics:
- **Dynamic Sizing**: Metaspace uses native memory (outside the Java heap), which means its size is dynamic and can grow as needed. This helps avoid the fixed-size limitations of PermGen.
- **Garbage Collection**: Metaspace is managed by the JVM using native memory, which is more flexible and can be garbage collected more efficiently. However, it can still lead to `OutOfMemoryError` if the native memory is exhausted.
- **Configuration**: The size of Metaspace can be controlled using JVM flags like `-XX:MetaspaceSize` and `-XX:MaxMetaspaceSize`.

### Key Differences

1. **Memory Management**:
   - **PermGen**: Fixed-size, part of the Java heap, which could lead to `OutOfMemoryError` when full.
   - **Metaspace**: Dynamic size, uses native memory, and is not part of the Java heap.

2. **Configuration**:
   - **PermGen**: Configured with `-XX:PermSize` and `-XX:MaxPermSize`.
   - **Metaspace**: Configured with `-XX:MetaspaceSize` and `-XX:MaxMetaspaceSize`.

3. **Memory Type**:
   - **PermGen**: Part of the JVM heap.
   - **Metaspace**: Uses native memory outside the Java heap.

4. **Garbage Collection**:
   - **PermGen**: Collected during full garbage collection cycles.
   - **Metaspace**: More flexible, collected in a more dynamic manner using native memory.

### Example Configuration

Here is an example of how you might configure Metaspace in the JVM:

```sh
java -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=256m -jar your-application.jar
```

In this configuration:
- `-XX:MetaspaceSize=128m` sets the initial size of the Metaspace.
- `-XX:MaxMetaspaceSize=256m` sets the maximum size of the Metaspace.

### Summary

- **PermGen**: The older memory area for storing class and method metadata with fixed size and managed within the heap.
- **Metaspace**: The newer, dynamic memory area introduced in Java 8 for the same purpose, using native memory and allowing for more flexible management.

###
PremGen: MetaData information of classes was stored in PremGen (Permanent-Generation) memory type before Java 8. PremGen is fixed in size and cannot be dynamically resized. It was a contiguous Java Heap Memory.

MetaSpace: Java 8 stores the MetaData of classes in native memory called 'MetaSpace'. It is not a contiguous Heap Memory and hence can be grown dynamically which helps to overcome the size constraints. This improves the garbage collection, auto-tuning, and de-allocation of metadata.

###
Feature				| PermGen							    |MetaSpace
--------------------| --------------------------------------|---------------------------------
Location			| Non-heap memory					    |Native memory
Sizing				| Fixed at startup				        |Dynamically grows
Garbage Collection	| Not managed by GC				        |Managed by GC
OutOfMemoryError	| Prone to OOM due to fixed size	    |Less likely due to dynamic sizing


##################################################################################################

In which programming paradigm Java 8 falls?
ANS)
Object-oriented programming language.
Functional programming language.
Procedural programming language.
Logic programming language

##################################################################################################


11. Describe the newly added features in Java 8?
ANS)
Here are the newly added features of Java 8:

Feature Name							|Description
----------------------------------------|--------------------------------------------------------------
Lambda expression						|A function that can be shared or referred to as an object.
Functional Interfaces					|Single abstract method interface.
Method References						|Uses function as a parameter to invoke a method.
Default method							|It provides an implementation of methods within interfaces enabling 'Interface evolution' facilities.
Stream API								|Abstract layer that provides pipeline processing of the data.
Date Time API							|New improved joda-time inspired APIs to overcome the drawbacks in previous versions
Optional								|Wrapper class to check the null values and helps in further processing based on the value.
Nashorn, JavaScript Engine				|An improvised version of JavaScript Engine that enables JavaScript executions in Java, to replace Rhino.


##################################################################################################

In Java 8, a **method reference** is a concise way to refer to a method using the `::` operator. It allows you to pass a method as a parameter to another method or assign it to a variable, similar to how you would use a lambda expression.

Method references are particularly useful when you want to pass an existing method to a functional interface method that expects a lambda expression. They make the code more readable and reduce boilerplate.

There are four main types of method references in Java 8:

1. **Reference to a static method**:
   ```java
   ClassName::staticMethodName
   ```

2. **Reference to an instance method of a particular object**:
   ```java
   instanceReference::instanceMethodName
   ```

3. **Reference to an instance method of an arbitrary object of a particular type**:
   ```java
   ClassName::instanceMethodName
   ```

4. **Reference to a constructor**:
   ```java
   ClassName::new
   ```

Here's an example of using a method reference to print elements of a list:

```java
List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
names.forEach(System.out::println);
```

This is equivalent to using a lambda expression:

```java
names.forEach(name -> System.out.println(name));
```

##################################################################################################
Stream and Optional

https://chatgpt.com/c/66d9dc50-7098-8011-9018-86708b66fd58

##################################################################################################

Sure, here’s a concise summary:

### 18. Features of the New Date and Time API in Java 8:
- **Immutable and Thread-safe**: Date and time objects are immutable and thread-safe.
- **Timezone Support**: Comprehensive timezone handling.
- **Fluent Methods**: Provides fluent APIs for creation and arithmetic operations.
- **I18N Issues**: Addresses internationalization issues of earlier APIs.
- **Joda-Time Influence**: Inspired by the Joda-Time library.
- **ISO-8601 Based**: Based on the ISO-8601 calendar system.

### 19. Important Packages for the New Date and Time API:
- **java.time**: Core package for date and time.
- **java.time.format**: For formatting and parsing.
- **java.time.temporal**: Temporal-based calculations and adjustments.
- **java.time.zone**: Timezone data.

### 20. LocalDate, LocalTime, and LocalDateTime Examples:

- **LocalDate**: Represents a date without time.
  ```java
  LocalDate today = LocalDate.now();  // Current date
  LocalDate aDate = LocalDate.of(2011, 12, 30);  // Specific date
  ```

- **LocalTime**: Represents a time without date, with nanosecond precision.
  ```java
  LocalTime now = LocalTime.now();  // Current time
  LocalTime aTime = LocalTime.of(18, 20, 30);  // Specific time
  ```

- **LocalDateTime**: Represents both date and time.
  ```java
  LocalDateTime timestamp = LocalDateTime.now();  // Current date and time
  LocalDateTime dt = LocalDateTime.of(2011, 12, 30, 18, 20, 30);  // Specific date and time
  ```
##################################################################################################

### 21. Nashorn in Java 8:
Nashorn is a JavaScript engine included in Java 8 that provides a high-performance runtime for executing JavaScript code within Java applications, replacing the older Rhino engine.

##################################################################################################

