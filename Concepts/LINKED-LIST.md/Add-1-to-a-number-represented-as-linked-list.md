# [`Add 1 to a number represented as linked list`](https://www.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1)

## `Brute`
```java
/*************************************************************

Following is the class structure of the Node class:

    class Node {
		public int data;
		public Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
	  	}
    }

*************************************************************/

public class Solution {
	public static Node reverse(Node head) {
		Node prev_node = null, curr_node = head, next = null;
        
		while(curr_node != null) {
			next = curr_node.next;
			curr_node.next = prev_node;
			prev_node = curr_node;
			curr_node = next;
		}
		return prev_node;
	}
    
	public static Node addOne(Node head) {
		// Write your code here.
		Node tail = reverse(head);
		Node curr_node = tail;
		int carry = 1, sum;
		while(curr_node != null) {
			sum = curr_node.data + carry;
			if(sum >= 10) {
				curr_node.data = 0;
				carry  = 1;
			} else {
				curr_node.data = sum;
				carry = 0;
			}
			curr_node = curr_node.next;
		}
		if(carry == 1) {
			Node new_node = new Node(carry);
			new_node.next = tail;
			tail = new_node;
			return tail;
		}
		head = reverse(tail);
		return head;
	}
}
```

## `Optimal (using recursion)`
```java
/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Solution
{
    public static int help(Node curr_node) {
        int carry, sum;
        
        if(curr_node == null) return 1;
        
        carry = help(curr_node.next);
        
        sum = curr_node.data + carry;
        
        if(sum >= 10) {
            curr_node.data = 0;
            carry = 1;
        } else {
            curr_node.data = sum;
            carry = 0;
        }
        
        return carry;
    }
    public static Node addOne(Node head) 
    { 
        //code here.
        Node curr_node = head;
        int carry = help(curr_node);
        
        if(carry == 1) {
            Node new_node = new Node(carry);
            new_node.next = head;
            head = new_node;
        }
        return head;
    }
}
```
