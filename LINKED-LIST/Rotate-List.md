# [61](https://leetcode.com/problems/rotate-list/description/). `Rotate List`

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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode currNode = head, lastNode = null;
        int len = 0;
        
        while(currNode != null) {
            len++;
            lastNode = currNode;
            currNode = currNode.next;
        }
        lastNode.next = head;
        
        k = k % len;
        int x = (len - k) - 1;
        
        currNode = head;
        while(x != 0) {
            currNode = currNode.next;
            x--;
        }
        head = currNode.next;
        currNode.next = null;
        
        return head;
    }
}
```
