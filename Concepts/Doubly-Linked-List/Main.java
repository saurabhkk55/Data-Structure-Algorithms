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
    int doubly_linked_list_size = 0;
    
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
        doubly_linked_list_size++;
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
        doubly_linked_list_size++;
    }
    
    public void insert_in_middle(int data, int idx) {
        if (idx == 0) {
            insert_at_beginning(data);
        } else {
            Node new_node = new Node(data);
            Node currNode = head;
            Node tail = null;
            
            for (int i=0; i<idx-1; i++) {
                currNode = currNode.next;
            }
            tail = currNode.next;
            currNode.next = new_node;
            new_node.prev = currNode;
            tail.prev = new_node;
            new_node.next = tail;
            doubly_linked_list_size++;
        }
        // System.out.println("currNode: "+currNode+" | currNode.prev: "+currNode.prev+" | currNode.data: "+currNode.data+" | currNode.next: "+currNode.next);
    }
    
    public void delete_from_start() {
        head = head.next;
        head.prev = null;
        doubly_linked_list_size--;
    }

    public void delete_from_end() {
        Node currNode = head;
        while(currNode.next != null) {
            currNode = currNode.next;
        }
        currNode = currNode.prev;
        currNode.next = null;
        doubly_linked_list_size--;
    }

    public void delete_from_middle(int idx) {
        if (idx == 0) { 
            delete_from_end();
        } else if (idx == (doubly_linked_list_size-1)) {
            delete_from_end();
        } else if ((idx > 0) && (idx < (doubly_linked_list_size-1))){
            Node tempNode = null;
            Node currNode = head;
            for (int i=0; i<idx-1; i++) {
                currNode = currNode.next;
            }
            tempNode = currNode.next;
            currNode.next = tempNode.next;
            tempNode = tempNode.next;
            tempNode.prev = currNode;
            doubly_linked_list_size--;
        } else {
            System.out.println("Invalid index: "+idx);
        }
    }

    public void find_in_the_list(int target) {
        Node currNode = head;
        int atIdx = 0;
        boolean found = false;
        while(currNode != null) {
            if(currNode.data == target) {
                found = true;
                // System.out.println(target+" found at index "+atIdx+"" the list.");
                System.out.printf("\n%d found at index %d in the list\n", target, atIdx);
                break;
            }
            currNode = currNode.next;
            atIdx++;
        }
        if (found == false) {
            System.out.println(target+" does not exst in the list.");
        }
    }

    public void reverse() {
        Node currNode, tempNode;
        currNode = head;
        tempNode = head;
        Node temp_addr = null;

        while(currNode != null) {
            tempNode = currNode;
            temp_addr = currNode.prev;
            currNode.prev = currNode.next;
            currNode.next = temp_addr;
            currNode = currNode.prev;
        }
        head = tempNode;
        // System.out.println("tempNode: "+tempNode+" | tempNode.prev: "+tempNode.prev+" | tempNode.data: "+tempNode.data+" | tempNode.next: "+tempNode.next);
        display();
        System.out.print("/START");
    }
    
    public void display() {
        Node currNode;
        currNode = head;
        // System.out.println("currNode: "+currNode+" | currNode.prev: "+currNode.prev+" | currNode.data: "+currNode.data+" | currNode.next: "+currNode.next);
        System.out.println();
        while(currNode != null) {
            // System.out.println("currNode: "+currNode+" | currNode.prev: "+currNode.prev+" | currNode.data: "+currNode.data+" | currNode.next: "+currNode.next);
            System.out.print(currNode.data+" -> ");
            currNode = currNode.next;
        }
        System.out.print("END");
    }
}

public class Main { 
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        System.out.println("\nInsert nodes at the beginning of the list");
        list.insert_at_beginning(30);
        list.insert_at_beginning(20);
        list.insert_at_beginning(10);
        list.display();
        System.out.println("\n-----------------------------------------------------------");
        
        System.out.println("\nInsert nodes at the end of the list");
        list.insert_at_end(40);
        list.insert_at_end(50);
        list.display();
        System.out.println("\n-----------------------------------------------------------");
        
        System.out.println("\nInsert nodes in the middle of the list");
        list.insert_in_middle(100, 0);
        list.insert_in_middle(200, 3);
        list.display();
        System.out.println("\n-----------------------------------------------------------");
        
        System.out.println("\nSize: "+list.doubly_linked_list_size);
        list.display();
        System.out.println("\n-----------------------------------------------------------");
        
        System.out.println("\nDelete a node from the beginning of the list");
        list.delete_from_start();
        
        System.out.println("\n\nSize: "+list.doubly_linked_list_size);
        list.display();
        System.out.println("\n-----------------------------------------------------------");
        
        System.out.println("\nDelete a node from the end of the list");
        list.delete_from_end();
        
        System.out.println("\n\nSize: "+list.doubly_linked_list_size);
        list.display();
        System.out.println("\n-----------------------------------------------------------");
        
        System.out.println("\nDelete a node from the middle of the list");
        // list.delete_from_middle(2);
        list.delete_from_middle(3);
        
        System.out.println("\n\nSize: "+list.doubly_linked_list_size);
        list.display();
        System.out.println("\n-----------------------------------------------------------");

        System.out.println("\nFind an element in the list");
        // list.delete_from_middle(2);
        list.find_in_the_list(200);
        list.find_in_the_list(10);
        list.find_in_the_list(20);
        list.find_in_the_list(40);
        list.find_in_the_list(41);
        
        System.out.println("\n\nSize: "+list.doubly_linked_list_size);
        list.display();
        System.out.println("\n-----------------------------------------------------------");
        
        System.out.println("\nReverse the Linked List");
        list.reverse();
        System.out.println("\n-----------------------------------------------------------");
    }
}
