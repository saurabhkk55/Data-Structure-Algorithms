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
    int linked_list_size = 0;

    // Constructor to initialize an empty linked list
    public LinkedList() {
        this.head = null; // why are we using this.head here?
    }
    int k = 0;

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        // if (k == 0) System.out.println("HEAD: "+head);
        newNode.next = head;
        head = newNode;
        // System.out.println("newNode: "+newNode+" | newNode-DATA: "+newNode.data+" | newNode-NEXT: "+newNode.next);
        // if (k >= 1) System.out.println("HEAD: "+head+" | HEAD-DATA: "+head.data+" | HEAD-NEXT: "+head.next);
        // k++;
        // System.out.println("------------------------------");
        linked_list_size++;
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        Node currNode = head;
        while(currNode.next != null) {
            // System.out.println("currNode.data: "+currNode.data+" | currNode.next: "+currNode.next);
            currNode = currNode.next;
            // System.out.println("currNode.data: "+currNode.data+" | currNode.next: "+currNode.next);
            // System.out.println("------------------------------");
        }
        currNode.next = newNode;
        linked_list_size++;
    }

    public void insertMiddle(int data, int idx) {
        if (idx == 0) {
            insertAtBeginning(data);
        }
        else {
            Node newNode = new Node(data);
            Node currNode = head;
            

            for (int i=0; i<idx-1; i++) {
                // System.out.println("currNode.data: "+currNode.data+" | currNode.next: "+currNode.next);
                currNode = currNode.next;
                // System.out.println("currNode.data: "+currNode.data+" | currNode.next: "+currNode.next);
                // System.out.println("------------------------------");
            }
            newNode.next = currNode.next;
            currNode.next = newNode;
        }
        linked_list_size++;
    }

    public void deleteBeginning() {
        head = head.next;
        linked_list_size--;
    }

    public void deleteEnd() {
        Node currNode = head;
        Node node_before_currNode = null;
        // System.out.println("currNode.data: "+currNode.data+" | currNode.next: "+currNode.next);
        while(currNode.next != null) {
            node_before_currNode = currNode;
            // System.out.println("BEFORE: currNode.data: "+currNode.data+" | currNode.next: "+currNode.next);
            currNode = currNode.next;
            // System.out.println("AFTER: currNode.data: "+currNode.data+" | currNode.next: "+currNode.next);
            // System.out.println("------------------------------");
        }
        // System.out.println("node_before_currNode.data: "+node_before_currNode.data+" | node_before_currNode.next: "+node_before_currNode.next);
        // System.out.println();
        node_before_currNode.next = null;
        linked_list_size--;
    }

    public void deleteMiddle(int idx) {
        if (idx == 0) {
            deleteBeginning();
        } else {
            Node currNode = head;
            Node node_before_currNode = null;
            for (int i=0; i<idx; i++) {
                node_before_currNode = currNode;
                currNode = currNode.next;
            }
            // System.out.println("node_before_currNode.data: "+node_before_currNode.data+" | node_before_currNode.next: "+node_before_currNode.next);
            // System.out.println("currNode.data: "+currNode.data+" | currNode.next: "+currNode.next);
            node_before_currNode.next = currNode.next;
            currNode.next = null;
        }
        linked_list_size--;
    }

    public void searchElement(int data) {
        Node currNode = head;
        int idx = 0;
        boolean found = false;
        while(currNode != null) {
            if ((currNode.data) == data) {
                System.out.printf("Element %d found at index: %d\n", data, idx);
                found = true;
                break;
            }
            currNode = currNode.next;
            idx++;
        } if (found == false) {
            System.out.printf("Linked-List does not contain the element: %d\n", data);
        }
    }

    public void reverse() {
        Node next = null, currNode = head, prevNode = null;
        while(currNode != null) {
            next = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = next;
        }
        head = prevNode;
    }
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
        System.out.println("INSERTING IN THE BEGINNING:");
        list.insertAtBeginning(50);
        list.insertAtBeginning(40);
        list.insertAtBeginning(30);
        list.insertAtBeginning(20);
        list.insertAtBeginning(10);
        list.display();
        System.out.println("--------------------------------");
        
        System.out.println("INSERTING IN THE MIDDLE:");
        list.insertMiddle(100, 5);
        list.display();
        System.out.println("--------------------------------");
        
        System.out.println("INSERTING AT END:");
        list.insertAtEnd(80);
        list.display();
        System.out.println("--------------------------------");
        
        System.out.println("DELETE FROM BEGINNING:");
        list.deleteBeginning();
        list.display();
        System.out.println("--------------------------------");
        
        System.out.println("DELETE FROM END:");
        list.deleteEnd();
        list.display();
        System.out.println("--------------------------------");
        
        System.out.println("DELETE FROM MIDDLE:");
        list.deleteMiddle(4);
        list.display();
        System.out.println("--------------------------------");
        
        System.out.println("SEARCH IN A LINKED-LIST:");
        list.searchElement(50);
        System.out.println("--------------------------------");
        System.out.println("LINKED-LIST SIZE:");
        System.out.println(list.linked_list_size);
        System.out.println("--------------------------------");
        System.out.println("REVERSE LINKED-LIST:");
        list.reverse();
        list.display();
        System.out.println("--------------------------------");
    }
}
