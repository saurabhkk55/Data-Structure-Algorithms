# [Given a linked list of 0s, 1s and 2s, sort it](https://www.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1)

Given a linked list of N nodes where nodes can contain values 0s, 1s, and 2s only. The task is to segregate 0s, 1s, and 2s linked list such that all zeros segregate to head side, 2s at the end of the linked list, and 1s in the mid of 0s and 2s.


```
Example 1:

Input:
N = 8
value[] = {1,2,2,1,2,0,2,2}
Output: 0 1 1 2 2 2 2 2
Explanation: All the 0s are segregated
to the left end of the linked list,
2s to the right end of the list, and
1s in between.
```

```
Example 2:

Input:
N = 4
value[] = {2,2,0,1}
Output: 0 1 2 2
Explanation: After arranging all the
0s,1s and 2s in the given format,
the output will be 0 1 2 2.
```

```
Example 3:

Input:
N = 5
value[] = {2,2,2,2,2}
Output: 2 2 2 2 2
Explanation: As there are no 0s and 1s. 
So, the output will be 2 2 2 2 2.
```

```java
/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/

class Solution {
    // Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head) {
        // add your code here
        Node new_node_0 = new Node(-1);
        Node new_node_1 = new Node(-1);
        Node new_node_2 = new Node(-1);
         
        Node head_new_node_0 = new_node_0;
        Node head_new_node_1 = new_node_1;
        Node head_new_node_2 = new_node_2;
        
        Node curr_node = head;
        
        while(curr_node != null) {
            if(curr_node.data == 0) {
                new_node_0.next = curr_node;
                new_node_0 = curr_node;
            } else if(curr_node.data == 1) {
                new_node_1.next = curr_node;
                new_node_1 = curr_node;     
            } else {
                new_node_2.next = curr_node;
                new_node_2 = curr_node;
            }
            
            curr_node = curr_node.next;
        }
        
        if(head_new_node_1.next != null) {
            new_node_0.next = head_new_node_1.next;
        } else {
            new_node_0.next = head_new_node_2.next;
        }
        new_node_1.next = head_new_node_2.next;
        new_node_2.next = null;
        
        return head_new_node_0.next;
    }
}
```
