# [19](https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/). `Remove Nth Node From End of List`

# `Brute`
```java
/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;

     Node()
     {
         this.data = 0;
         this.next = null;
     }

     Node(int data)
     {
         this.data = data;
         this.next = null;
     }

     Node(int data, Node next)
     {
         this.data = data;
         this.next = next;
     }
 };
*/

public class Solution
{
    public static Node removeKthNode(Node head, int K)
    {
        // Write your code here.
        int node_count = 0;
        Node curr_node = head;

        while(curr_node != null) {
            node_count++;
            curr_node = curr_node.next;
        }

        node_count = (node_count - K)-1;

        if (node_count < 0) return head = head.next;

        curr_node = head;
        while(node_count != 0) {
            curr_node = curr_node.next;
            node_count--;
        }
        curr_node.next = curr_node.next.next;
        
        return head;
    }
}
```

# `Optimal`
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        while(n != 0) {
            fast = fast.next;
            n--;
        }

        if(fast == null) return head.next;

        ListNode slow = head;
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;

        return head;
    }
}
```
