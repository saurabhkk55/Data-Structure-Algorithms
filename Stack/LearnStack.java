class CustomStack {
    int top = -1;                           // Index of the top element in the stack
    int[] stack_arr = new int[5];           // Array to store stack elements
    int stack_arr_len = stack_arr.length;   // Length of the stack array

    // Push the element onto stack
    public void push(int elem) {
        if (top == stack_arr_len - 1) {
            System.out.println("Stack overflow: cannot insert new element.");
            return;
        }
        
        top = top + 1;
        stack_arr[top] = elem;
        System.out.println("Element " + elem + " pushed onto stack.");
    }

    // return the popped element, or -1 if the stack is empty
    public int pop() {
        if (top == -1) {
            System.out.println("Stack underflow: stack is already empty.");
            return -1;
        }
        
        int popped_elem = stack_arr[top];
        top = top - 1;
        System.out.println("Element " + popped_elem + " popped from stack.");
        return popped_elem;
    }

    // return The top element, or -1 if the stack is empty
    public int peek() {
        if (top == -1) {
            System.out.println("Stack underflow: stack is empty.");
            return -1;
        }
        return stack_arr[top];
    }

    // return The number of elements in the stack
    public int size() {
        return top + 1;
    }

    // Displays all elements in the stack
    public void display() {
        if (top == -1) {
            System.out.println("Stack is empty.");
            return;
        }
        
        System.out.print("Stack elements: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(stack_arr[i] + " ");
        }
        System.out.println();
    }
}

public class LearnStack {
    public static void main(String[] args) {
        CustomStack obj = new CustomStack();

        // Test peek on empty stack
        System.out.println("Peek: " + obj.peek());

        // Test push operation
        obj.push(10);
        System.out.println("Peek: " + obj.peek());

        // Test pop operation
        System.out.println("Popped: " + obj.pop());
        System.out.println("Peek: " + obj.peek());

        // Push multiple elements
        obj.push(10);
        obj.push(20);
        obj.push(30);
        obj.push(40);
        obj.push(50);
        obj.push(60); // trigger stack overflow

        // Display stack elements
        obj.display();

        // Display stack size
        System.out.println("Stack size: " + obj.size());
    }
}
