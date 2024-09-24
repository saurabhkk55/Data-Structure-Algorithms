// import java.util.*;

// // Parent class
// class Animal {
//     void sound() {
//         System.out.println("Animal makes a sound");
//     }
// }

// // Child class inheriting from Animal
// class Dog extends Animal {
//     @Override
//     void sound() {
//         System.out.println("Dog barks");
//     }

//     void wagTail() {
//         System.out.println("Dog wags tail");
//     }
// }

// public class Main {
//     public static void main(String[] args) {
//         // Dog myDog = new Dog(); // Creating an object of subclass Dog
//         // Animal animal = myDog; // Upcasting Dog to Animal
        
//         // animal.sound(); // Calls overridden method in Dog
//         // animal.wagTail(); // Compilation error: Animal class doesn't have wagTail method

//     }
// }

// import java.util.function.BinaryOperator;

// public class BinaryOperatorExample {
//     public static void main(String[] args) {
//         // Create a BinaryOperator instance
//         BinaryOperator<Integer> binaryOperator = (a, b) -> a + b;
        
//         // Use the BinaryOperator instance
//         int result = binaryOperator.apply(10, 20);
//         System.out.println("Result: " + result);  // Output: Result: 30
//     }
// }

// class Saurabh extends Thread {
//     public void run() {
//         try{
//             Thread.sleep(1000);
//         } catch(InterruptedException ex) {
//             System.out.println("error: "+ex);
//         }
//         System.out.println("123:"+Thread.currentThread().getName());
//     }
// }

// public class Main {
//     public static void main(String[] args) {
//         Saurabh t1 = new Saurabh();
//         Saurabh t2 = new Saurabh();
//         t1.start();
//         t2.start();
//         System.out.println("456----------");
//     }
// }

import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        // 1. Create a ThreadPoolExecutor with custom settings
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,       // corePoolSize
                5,       // maximumPoolSize
                1,       // keepAliveTime
                TimeUnit.SECONDS,  // time unit for keepAliveTime
                new LinkedBlockingQueue<>(3), // task queue with a capacity of 3
                new ThreadPoolExecutor.CallerRunsPolicy() // Rejection policy
        );

        // 2. Submit tasks to the executor
        for (int i = 1; i <= 10; i++) {
            Runnable task = new Task(i);
            executor.execute(task);
        }

        // 3. Shutdown the executor
        executor.shutdown();
    }

    // Custom Runnable task
    static class Task implements Runnable {
        private int taskId;

        public Task(int taskId) {
            this.taskId = taskId;
        }

        @Override
        public void run() {
            System.out.println("Task " + taskId + " is running on Thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(5000); // Simulate a long-running task
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}