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
        System.out.println(">>>>>>>>>>>>>>>>>>>> INSERTING IN BEGINNING <<<<<<<<<<<<<<<<<<<<<<<<");
        Node newNode = new Node(data);
        if (k == 0) System.out.println("HEAD: "+head);
        newNode.next = head;
        head = newNode;
        System.out.println("newNode: "+newNode+" | newNode-DATA: "+newNode.data+" | newNode-NEXT: "+newNode.next);
        if (k >= 1) System.out.println("HEAD: "+head+" | HEAD-DATA: "+head.data+" | HEAD-NEXT: "+head.next);
        k++;
        System.out.println("------------------------------");
    }

    // Method to insert a new node at the beginning of the linked list
    public void insertAtEnd(int data) {
        System.out.println(">>>>>>>>>>>>>>>>>>>> INSERTING AT END <<<<<<<<<<<<<<<<<<<<<<<<");
        Node newNode = new Node(data);
        Node currNode = head;
        while(currNode.next != null) {
            System.out.println("currNode.data: "+currNode.data+" | currNode.next: "+currNode.next);
            currNode = currNode.next;
            System.out.println("currNode.data: "+currNode.data+" | currNode.next: "+currNode.next);
            System.out.println("------------------------------");
        }
        currNode.next = newNode;
    }

    public void insertMiddle(int data, int idx) {
        System.out.println(">>>>>>>>>>>>>>>>>>>> INSERTING IN MIDDLE <<<<<<<<<<<<<<<<<<<<<<<<");
        if (idx == 0) {
            insertAtBeginning(data);
        }
        else {
            Node newNode = new Node(data);
            Node currNode = head;
            

            for (int i=0; i<idx-1; i++) {
                System.out.println("currNode.data: "+currNode.data+" | currNode.next: "+currNode.next);
                currNode = currNode.next;
                System.out.println("currNode.data: "+currNode.data+" | currNode.next: "+currNode.next);
                System.out.println("------------------------------");
            }
            newNode.next = currNode.next;
            currNode.next = newNode;
        }
    }

    public void deleteBeginning() {
        System.out.println(">>>>>>>>>>>>>>>>>>>> DELETE FROM BEGINNING <<<<<<<<<<<<<<<<<<<<<<<<");
        head = head.next;
    }

    public void deleteEnd() {
        System.out.println(">>>>>>>>>>>>>>>>>>>> DELETE FROM END <<<<<<<<<<<<<<<<<<<<<<<<");
        Node currNode = head;
        Node node_before_currNode = null;
        System.out.println("currNode.data: "+currNode.data+" | currNode.next: "+currNode.next);
        while(currNode.next != null) {
            node_before_currNode = currNode;
            System.out.println("BEFORE: currNode.data: "+currNode.data+" | currNode.next: "+currNode.next);
            currNode = currNode.next;
            System.out.println("AFTER: currNode.data: "+currNode.data+" | currNode.next: "+currNode.next);
            System.out.println("------------------------------");
        }
        System.out.println("node_before_currNode.data: "+node_before_currNode.data+" | node_before_currNode.next: "+node_before_currNode.next);
        System.out.println();
        node_before_currNode.next = null;
    }

    // Method to display the elements of the linked list
    public void display() {
        Node current = head;
        System.out.println("Linked List: "+current);
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
        list.insertAtBeginning(50);
        list.insertAtBeginning(40);
        list.insertAtBeginning(30);
        list.insertAtBeginning(20);
        list.insertAtBeginning(10);
        list.insertMiddle(100, 5);
        list.insertAtEnd(80);
        list.display();
        list.deleteBeginning();
        list.display();
        list.deleteEnd();
        // Displaying the linked list
        list.display();
    }
}
