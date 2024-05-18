# [2095](https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/). `Delete the Middle Node of a Linked List`

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
    public ListNode second_mid(ListNode head) {
        ListNode slow = head, fast = head;
        while((fast != null) && (fast.next != null)) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode midNode = second_mid(head);
        ListNode currNode = head, prevNode = null;
        while(currNode != midNode) {
            prevNode = currNode;
            currNode = currNode.next;
        }
        prevNode.next = currNode.next;
        return head;
    }
}
```
