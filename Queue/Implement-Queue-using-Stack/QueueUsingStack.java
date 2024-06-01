import java.util.Stack;

class CustomQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    
    public void push(int elem) {
        // s1_to_s2
        while(s1.isEmpty() == false) {
            s2.push(s1.peek());
            s1.pop();
        }
        
        s1.push(elem);
        
        // s2_to_s1
        while(s2.isEmpty() == false) {
            s1.push(s2.peek());
            s2.pop();
        }
        
        System.out.println("Pushed element: "+elem);
    }
    
    public int pop() {
        return s1.pop();
    }
    
    public int peek() {
        return s1.peek();
    }
    
    public void display() {
        System.out.print("Queue elements: ");
        for(int elem : s1) {
            System.out.print(elem+" ");
        }
        System.out.println();
    }
}

public class QueueUsingStack {
    public static void main(String[] args) {
        CustomQueue obj = new CustomQueue();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.display();
        System.out.println("Popped element: "+obj.pop());
        obj.display();
        obj.push(4);
        obj.display();
        System.out.println("Front element: "+obj.peek());
        obj.push(5);
        System.out.println("Front element: "+obj.peek());
        obj.display();
        System.out.println("Popped element: "+obj.pop());
        System.out.println("Popped element: "+obj.pop());
        System.out.println("Popped element: "+obj.pop());
        obj.display();
        System.out.println("Popped element: "+obj.pop());
        obj.display();
    }
}

// TC: O(N)
// SC: O(2N)

/*
### Algorithm for `push(int elem)`
1. Transfer all elements from `s1` to `s2`.
2. Push the new element `elem` onto `s1`.
3. Transfer all elements back from `s2` to `s1`.
4. Print the pushed element.

### Algorithm for `pop()`
1. Remove and return the top element of `s1`.

### Algorithm for `peek()`
1. Return the top element of `s1` without removing it.

### Algorithm for `display()`
1. Print all elements in `s1`.
*/
