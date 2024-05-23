# [`Remove duplicate element from sorted Linked List`](https://www.geeksforgeeks.org/problems/remove-duplicate-element-from-sorted-linked-list/1)

**NOTE**: This code will work for both `singly` and `doubly` linked list

```java
/*
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
*/

class GfG
{
    //Function to remove duplicates from sorted linked list.
    Node removeDuplicates(Node head)
    {
	    // Your code here
	    while((head.next != null) && (head.data == head.next.data)) {
	        head = head.next;
	    }
	    
	    Node currNode = head;
	    
	    while(currNode != null) {
	        if((currNode.next != null) && (currNode.data == currNode.next.data)) {
	            currNode.next = currNode.next.next;
	        } else currNode = currNode.next;
	    }
	    return head;
    }
}
```
