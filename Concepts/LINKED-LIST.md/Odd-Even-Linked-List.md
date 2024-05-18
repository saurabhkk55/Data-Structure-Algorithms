# [328](https://leetcode.com/problems/odd-even-linked-list/description/). `Odd Even Linked List`

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
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        ListNode odd_head = head;
        ListNode even_head = head.next, start_even_head = head.next;

        while((even_head != null) && (even_head.next != null)) {
            odd_head.next = odd_head.next.next;
            even_head.next = even_head.next.next;

            odd_head = odd_head.next;
            even_head = odd_head.next;
        }
        odd_head.next = start_even_head;
        return head;
    }
}
```
