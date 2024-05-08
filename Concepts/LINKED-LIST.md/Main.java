// Node class representing each element in the linked list
class Node {
    int data;
    Node next;

    // Constructor to initialize a node with given data
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// LinkedList class to manage basic linked list operations
class LinkedList {
    private Node head;

    // Constructor to initialize an empty linked list
    public LinkedList() {
        this.head = null; // why are we using this.head here?
    }
    int k = 0;
    // Method to insert a new node at the beginning of the linked list
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (k == 0) System.out.println("HEAD: "+head);
        newNode.next = head;
        head = newNode;
        System.out.println("newNode: "+newNode+" newNode-DATA: "+newNode.data+" newNode-NEXT: "+newNode.next);
        if (k >= 1) System.out.println("HEAD: "+head+" HEAD-DATA: "+head.data+" HEAD-NEXT: "+head.next);
        k++;
        System.out.println();
    }

    // Method to insert a new node at the beginning of the linked list
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        Node current = head;
        while(current.next != null) {
            System.out.println("current.data: "+current.data);
            System.out.println("current.next: "+current.next);
            current = current.next;
            System.out.println("current.data: "+current.data);
            System.out.println("current.next: "+current.next);
            System.out.println("------------------------------");
        }
        current.next = newNode;
    }

    // Method to display the elements of the linked list
    public void display() {
        Node current = head;
        System.out.print("Linked List: "+current);
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}

// Main class to test the LinkedList implementation
public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Inserting elements into the linked list at the beginning
        list.insertAtBeginning(30);
        list.insertAtBeginning(20);
        list.insertAtBeginning(10);
        list.insertAtEnd(80);

        // Displaying the linked list
        list.display();
    }
}
