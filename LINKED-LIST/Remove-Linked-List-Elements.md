# [203](https://leetcode.com/problems/remove-linked-list-elements/description/). `Remove Linked List Elements`

```java
/*
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
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode currNode = head, prevNode = null;
        while(currNode != null) {
            if (currNode.val == val) {
                prevNode.next = currNode.next;
            } else prevNode = currNode;
            currNode = currNode.next;
        }
        return head;
    }
}
```
