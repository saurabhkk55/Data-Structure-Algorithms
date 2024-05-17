```java
class Solution {
    public ListNode first_mid(ListNode head) {
        ListNode slow = head, fast = head;
        while ((fast.next != null) && (fast.next.next != null)) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode reverse(ListNode head) {
        ListNode next = null, prev_node = null, curr_node = head;
        while(curr_node != null) {
            next = curr_node.next;
            curr_node.next = prev_node;
            prev_node = curr_node;
            curr_node = next;
        }
        return prev_node;
    }
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode mid_node = first_mid(head);
        ListNode tail = reverse(mid_node.next);
        ListNode start = head, last = tail;
        while (last != null) {
            if (start.val != last.val) {
                return false;
            }
            start = start.next;
            last = last.next;
        }
        return true;
    }
}
```