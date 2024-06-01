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

class Queue {
    Node front, head;

    public void push(int elem) {
        Node newNode = new Node(elem);
        if(front == null) {
            front = newNode;
            head = newNode;
        } else {
            head.next = newNode;
            head = newNode;
        }
    }

    public int pop() {
        if(front == null) return -1; // queue is empty, there is no element to be deleted
        int pop_elem = front.data;
        front = front.next;
        return pop_elem;
    }

    public void display() {
        if (front == null) {
            System.out.println("Queue is empty");
        } else {
            Node currNode = front;
            System.out.print("Queue elements: ");
            while(currNode != null) {
                System.out.print(currNode.data+" ");
                currNode = currNode.next;
            }
            System.out.println();
        }
    }
}
public class QueueUsingLinkedList {
    public static void main(String[] args) {
        Queue obj = new Queue();
        System.out.println("Pop element: "+obj.pop());
        obj.push(10);
        obj.push(20);
        obj.push(30);
        obj.push(40);
        obj.push(50);
        obj.push(60);
        obj.push(70);
        obj.display();
        System.out.println("Pop element: "+obj.pop());
        System.out.println("Pop element: "+obj.pop());
        obj.push(80);
        obj.push(90);
        obj.display();
        System.out.println("Pop element: "+obj.pop());
        System.out.println("Pop element: "+obj.pop());
        System.out.println("Pop element: "+obj.pop());
        System.out.println("Pop element: "+obj.pop());
        System.out.println("Pop element: "+obj.pop());
        System.out.println("Pop element: "+obj.pop());
        obj.display();
        System.out.println("Pop element: "+obj.pop());
        obj.display();
        System.out.println("Pop element: "+obj.pop());
        obj.display();
    }
}

// TC: O(1)
// SC: O(N)