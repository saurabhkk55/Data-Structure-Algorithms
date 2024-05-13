class Node {
    int data;
    Node prev;
    Node next;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Node head;

    public DoublyLinkedList() {
        this.head = null;
    }

    public void insert_at_beginning(int data) {
        Node new_node = new Node(data);
        new_node.data = data;
        new_node.prev = null;
        new_node.next = head;
        if (head != null) head.prev = new_node;
        head = new_node;
        // System.out.println("new_node: "+new_node+" | new_node.prev: "+new_node.prev+" | new_node.data: "+new_node.data+" | new_node.next: "+new_node.next);
    }

    public void insert_at_end(int data) {
        Node new_node = new Node(data);
        Node currNode = head;
        while(currNode.next != null) {
            currNode = currNode.next;
        }
        currNode.next = new_node;
        new_node.prev = currNode;
        new_node.next = null;
    }

    public void display() {
        Node currNode;
        currNode = head;
        System.out.println();
        while(currNode != null) {
            System.out.println("currNode: "+currNode+" | currNode.prev: "+currNode.prev+" | currNode.data: "+currNode.data+" | currNode.next: "+currNode.next);
            currNode = currNode.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insert_at_beginning(30);
        list.insert_at_beginning(20);
        list.insert_at_beginning(10);

        list.insert_at_end(40);
        list.insert_at_end(50);

        list.insert_at_middle(100); 

        list.display();
    }
}
