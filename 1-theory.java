What is a class in Java
A class is a group of objects which have common properties. It is a template or blueprint from which objects are created. It is a logical entity. It can't be physical.
A class in Java can contain:
Fields
Methods
Constructors
Blocks
Nested class and interface

Object Definitions:
An object is a real-world entity.
An object is a runtime entity.
The object is an entity which has state and behavior.
The object is an instance of a class.

3 Ways to initialize object
By reference variable
By method
By constructor

Anonymous object
Anonymous simply means nameless. An object which has no reference is known as an anonymous object. It can be used at the time of object creation only.

If you have to use an object only once, an anonymous object is a good approach. For example:
new Calculation();//anonymous object

// Calling method through a reference:
Calculation c=new Calculation();  
c.fact(5);

Calling method through an anonymous object
new Calculation().fact(5);

Let's see the full example of an anonymous object in Java.
class Calculation{  
 void fact(int  n){  
    int fact=1;  
    for(int i=1;i<=n;i++){  
        fact=fact*i;  
    }  
    System.out.println("factorial is "+fact);  
}  
public static void main(String args[]){  
    new Calculation().fact(5);//calling method with anonymous object  
}  
}  
Output:
Factorial is 120