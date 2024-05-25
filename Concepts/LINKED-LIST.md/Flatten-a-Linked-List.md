# [`Flatten A Linked List`](https://www.naukri.com/code360/problems/flatten-a-linked-list_1112655?utm_source=youtube&utm_medium=affiliate&utm_campaign=Codestudio_Linkedlistseries&leftPanelTabValue=PROBLEM)

```java
/****************************************************************
 Following is the class structure of the Node class:

 class Node {
    public int data;
    public Node next;
    public Node child;

    Node() {
        this.data = 0;
        this.next = null;
        this.child = null;
    }
    Node(int data) {
        this.data = data;
        this.next = null;
        this.child = null;
    }
    Node(int data, Node next, Node child) {
        this.data = data;
        this.next = next;
        this.child = child;
    }
 }
 *****************************************************************/

public class Solution {
    public static Node mergeTwoList(Node list1, Node list2) {
        Node t1 = list1, t2 = list2;
        Node prevNode = new Node(-1);
        Node ansHead = prevNode;
        
        while(t1 != null && t2 != null) {
            if(t1.data <= t2.data) {
                prevNode.child = t1;
                t1 = t1.child;
                prevNode = prevNode.child;
                prevNode.child = null;
            } else {
                prevNode.child = t2;
                t2 = t2.child;
                prevNode = prevNode.child;
                prevNode.child = null;
            }
            prevNode.next = null;
        }
        
        while(t1 != null) {
            prevNode.child = t1;
            t1 = t1.child;
            prevNode = prevNode.child;
            prevNode.child = null;
            prevNode.next = null;
        }
        while(t2 != null) {
            prevNode.child = t2;
            t2 = t2.child;
            prevNode = prevNode.child;
            prevNode.child = null;
            prevNode.next = null;
        }
        return ansHead.child;
    }
    
    public static Node flattenLinkedList(Node head) {
        //Write your code here
        Node currNode = head;
        
        if(currNode.next == null) {
            return currNode;
        }
        
        Node extreme_last_list = flattenLinkedList(currNode.next);
        Node second_last_list = currNode;
        return mergeTwoList(second_last_list, extreme_last_list);
    }
}
```
