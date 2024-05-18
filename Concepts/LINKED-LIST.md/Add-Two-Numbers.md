# [2](https://leetcode.com/problems/add-two-numbers/description/). `Add Two Numbers`

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr_node1 = l1, curr_node2 = l2;

        ListNode temp_node = new ListNode();
        ListNode temp_head = temp_node;

        int sum1, sum2, sum, carry = 0;

        while((curr_node1 != null) || (curr_node2 != null)) {
            sum1 = (curr_node1 != null) ? curr_node1.val : 0;
            sum2 = (curr_node2 != null) ? curr_node2.val : 0;
            sum = sum1 + sum2 + carry;

            if(sum >= 10) {
                sum = sum % 10;
                carry = 1;
            } else carry = 0;

            ListNode new_node = new ListNode(sum);
            temp_node.next = new_node;
            temp_node = new_node;

            if(curr_node1 != null) curr_node1 = curr_node1.next;
            if(curr_node2 != null) curr_node2 = curr_node2.next;
        }

        if(carry == 1) {
            ListNode new_node = new ListNode(carry);
            temp_node.next = new_node;
            temp_node = new_node;
        }

        return temp_head.next;
    }
}
```
