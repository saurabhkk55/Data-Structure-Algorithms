// Parent class
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

// Child class inheriting from Animal
class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }

    void wagTail() {
        System.out.println("Dog wags tail");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog myDog = new Dog(); // Creating an object of subclass Dog
        Animal animal = myDog; // Upcasting Dog to Animal
        
        animal.sound(); // Calls overridden method in Dog
        animal.wagTail(); // Compilation error: Animal class doesn't have wagTail method
    }
}
