import java.util.Stack;

class CustomQueue {
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();
    
    public void push(int elem) {
        input.push(elem);
        System.out.println("Pushed element: "+elem);
    }
    
    public int pop() {
        if(output.isEmpty() == false) {
            return output.pop();
        } else {
            while(input.isEmpty() == false) {
                output.push(input.peek());
                input.pop();
            }
            return output.pop();
        }
    }
    public int peek() {
        if(output.isEmpty() == false) {
            return output.peek();
        } else {
            while(input.isEmpty() == false) {
                output.push(input.peek());
                input.pop();
            }
            return output.peek();
        }
    }
    public boolean empty() {
        if((input.isEmpty() == true) && (output.isEmpty() == true)) {
            return true;
        }
        return false;
    }
}

public class QueueUsingStackOpimal {
    public static void main(String[] args) {
        CustomQueue obj = new CustomQueue();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        System.out.println("Popped element: "+obj.pop());
        obj.push(4);
        System.out.println("Front element: "+obj.peek());
        System.out.println("Is Queue empty? "+obj.empty());
        obj.push(5);
        System.out.println("Front element: "+obj.peek());
        System.out.println("Popped element: "+obj.pop());
        System.out.println("Popped element: "+obj.pop());
        System.out.println("Popped element: "+obj.pop());
        System.out.println("Popped element: "+obj.pop());
        System.out.println("Is Queue empty? "+obj.empty());
    }
}

// TC: O(1) amortised (not O(1) time complexity but mostly it is that only)
// SC: O(2N)

/*
### Algorithm for `push(int elem)`
1. Push `elem` onto `input`.
2. Print the pushed element.

### Algorithm for `pop()`
1. If `output` is not empty:
    - Return `output.pop()`.
2. If `output` is empty:
    - Transfer all elements from `input` to `output`.
    - Return `output.pop()`.

### Algorithm for `peek()`
1. If `output` is not empty:
    - Return `output.peek()`.
2. If `output` is empty:
    - Transfer all elements from `input` to `output`.
    - Return `output.peek()`.
*/
