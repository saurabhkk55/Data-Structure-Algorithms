class Node {
    int data;
    Node next;
    Node prev;
    
    public Node(int data) {
        this.data = data;
    }
    public Node(int data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

class Stack {
    Node head = null;
    int size = 0;

    // Push the element onto stack
    public void push(int elem) {
        Node newNode = new Node(elem);
        if (head == null) head = newNode;
        else {
            head.next = newNode;
            newNode.prev = head;
            head = newNode;
        }
        size++;
        System.out.println("Element " + elem + " pushed onto stack.");
        // System.out.println("head: "+head+" | head.data: "+head.data+" | head.prev: "+head.prev+" | head.next: "+head.next);
    }

    // return the popped element, or -1 if the stack is empty
    public int pop() {
        if (head == null) {
            System.out.println("Stack underflow: stack is already empty.");
            return -1;
        }
        
        int popped_elem = head.data;
        head = head.prev;
        head.next = null;
        System.out.println("Element " + popped_elem + " popped from stack.");
        // System.out.println("head: "+head+" | head.data: "+head.data+" | head.prev: "+head.prev+" | head.next: "+head.next);
        size--;
        return popped_elem;
    }

    // return The top element, or -1 if the stack is empty
    public int peek() {
        if (head == null) {
            System.out.println("Stack underflow: stack is empty.");
            return -1;
        }
        return head.data;
    }

    // return The number of elements in the stack
    public int size() {
        return size;
    }

    // Displays all elements in the stack
    public void display() {
        if (head == null) {
            System.out.println("Stack is empty.");
            return;
        }
        
        Node currNode = head;
        
        while(currNode.prev != null) {
            currNode = currNode.prev;
        }
        
        System.out.print("STACK elements: ");
        while(currNode.next != null) {
            System.out.print(currNode.data+" ");
            currNode = currNode.next;
        }
        System.out.print(currNode.data);
        System.out.println();
    }
}

public class StackUsingLinkedList {
    public static void main(String[] args) {
        Stack obj = new Stack();
        obj.push(10);
        obj.push(20);
        obj.pop();
        obj.push(30);
        obj.push(40);
        obj.push(50);
        System.out.println("Peek element: "+obj.peek());
        System.out.println("Stack size/length: "+obj.size());
        obj.display();
        obj.pop();
        obj.display();
    }
}
