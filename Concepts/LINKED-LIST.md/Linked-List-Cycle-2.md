# [142](https://leetcode.com/problems/linked-list-cycle-ii/description/) `Linked List Cycle II`

```java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    public static ListNode cycle_begins(ListNode slow, ListNode fast) {
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow; // return fast;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while((fast != null) && (fast.next != null)) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return cycle_begins(head, fast);
        }
        return null;
    }
}
```