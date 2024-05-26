# [138](https://leetcode.com/problems/copy-list-with-random-pointer/description/). `Clone/Copy a Linked List with random pointers`

```java
import java.util.HashMap;

/****************************************************************

 Following is the class structure of the Node class:

 class Node {
    public int data;
    public Node next;
    public Node random;
    
    Node() {
        this.data = 0;
        this.next = null;
        this.random = null;
    }
    Node(int data) {
        this.data = data;
        this.next = null;
        this.random = null;
    }
    Node(int data, Node next, Node random) {
        this.data = data;
        this.next = next;
        this.random = random;
    }
 }

 *****************************************************************/

public class Solution {
    public static Node cloneLL(Node head) {
        // Write your code here.
        HashMap<Node, Node> hm = new HashMap<>();
        Node currNode = head;

        while(currNode != null) {
            Node newNode = new Node(currNode.data);
            hm.put(currNode, newNode);
            currNode = currNode.next;
        }

        currNode = head;
        while(currNode != null) {
            Node copyNode = hm.get(currNode);
            copyNode.next = currNode.next;
            copyNode.random = currNode.random;
            currNode = currNode.next;
        }

        return hm.get(head); // head of the copied List
    }
}

// TC: O(2N)
// SC: O(2N): One N for hashmap and another N for copied Linked-List 
```

```java
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;
    
    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        
        Node currNode = head;
        while(currNode != null) {
            Node newNode = new Node(currNode.val);
            newNode.next = currNode.next;
            currNode.next = newNode;
            currNode = newNode.next;
        }
        
        currNode = head;
        while(currNode != null) {
            // if(currNode.random == null) currNode.next.random = currNode.random;
            // else currNode.next.random = currNode.random.next;
            
            // Above commented if-else can be written like this as well
            currNode.next.random = (currNode.random == null) ? null : currNode.random.next;
            
            currNode = currNode.next.next;
        }
        
        currNode = head;
        
        Node tempNode = new Node(-1);
        tempNode.next = currNode.next;
        
        while(currNode != null) {
            Node copiedNode = currNode.next;
            currNode.next = currNode.next.next;
            copiedNode.next = (copiedNode.next == null)  ? null : currNode.next.next;
            currNode = currNode.next;
        }
        
        return tempNode.next;
    }
}
```
