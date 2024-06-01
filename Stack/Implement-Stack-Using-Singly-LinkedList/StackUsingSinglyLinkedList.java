class Node {
    int data;
    Node next;
    
    public Node(int data) {
        this.data = data;
    }
    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

class Stack {
    Node head = null;

    public void push(int elem) {
        Node newNode = new Node(elem);
        newNode.next = head;
        head = newNode;
        System.out.println("Pushed element: "+elem);
    }

    public int pop() {
        if(head == null) {
            System.out.println("Stack is empty, returning -1 to represent stack is empty");
            return -1;
        }
        int popped_elem = head.data;
        head = head.next;
        return popped_elem;
    }

    public int peek() {
        return head.data;
    }

    public void display() {
        Node currNode = head;
        System.out.print("Stack elements: ");
        while(currNode != null) {
            System.out.print(currNode.data+" ");
            currNode = currNode.next;
        }
        System.out.print("\n");
    }

}

public class StackUsingSinglyLinkedList {
    public static void main(String[] args) {
        Stack obj = new Stack();
        System.out.println("Popped element: "+ obj.pop());
        obj.push(10);
        obj.push(20);
        System.out.println("Popped element: "+ obj.pop());
        obj.push(30);
        obj.push(40);
        obj.push(50);
        System.out.println("Peek element: "+obj.peek());
        obj.display();
        System.out.println("Popped element: "+ obj.pop());
        obj.display();
    }
}

/*
### Algorithm for Stack Operations using Singly Linked List

#### Node Class
1. **Constructor 1 (`Node(int data)`):**
    - Initialize the `data` attribute with the provided value.
    - Set the `next` attribute to `null`.

2. **Constructor 2 (`Node(int data, Node next)`):**
    - Initialize the `data` attribute with the provided value.
    - Initialize the `next` attribute with the provided `Node`.

#### Stack Class
1. **Attribute Initialization:**
    - Initialize `head` to `null`.

2. **`push(int elem)` Method:**
    - Create a new `Node` with `data` as `elem`.
    - Set the `next` attribute of the new `Node` to the current `head`.
    - Update `head` to the new `Node`.
    - Print "Pushed element: `elem`".

3. **`pop()` Method:**
    - Check if `head` is `null` (i.e., the stack is empty):
        - Return `-1`.
    - Store the `data` of `head` in `popped_elem`.
    - Update `head` to the `head.next`.
    - Return `popped_elem`.

4. **`peek()` Method:**
    - return head.data();

5. **`display()` Method:**
    - Initialize `currNode` to `head`.
    - Print "Stack elements: ".
    - Traverse the linked list starting from `currNode`:
        - Print the `data` of `currNode`.
        - Move `currNode` to the `next` node.
    - Print a newline after displaying all elements.
 */
