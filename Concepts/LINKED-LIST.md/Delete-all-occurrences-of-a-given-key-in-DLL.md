# [`Delete all occurrences of a given key in a doubly linked list`](https://www.naukri.com/code360/problems/delete-all-occurrences-of-a-given-key-in-a-doubly-linked-list_8160461?utm_source=youtube&utm_medium=affiliate&utm_campaign=Codestudio_Linkedlistseries&leftPanelTabValue=PROBLEM)

```java
/****************************************************************

Following is the class structure of the Node class:

class Node {
    public int data;
    public Node next;
    public Node prev;

    Node() {
        this.data = 0;
        this.next = null;
        this.prev = null;
    }
    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
    Node(int data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
 }

 *****************************************************************/

public class Solution {
    public static Node deleteAllOccurrences(Node head, int k) {
        // Write your code here.
        
        while(head != null && head.data == k) {
            head = head.next;
        }

        Node currNode = head;
        while(currNode != null) {
            if(currNode.data == k) {
                currNode.prev.next = currNode.next;
            }
            currNode = currNode.next;
        }
        
        return head;
    }
}
```
