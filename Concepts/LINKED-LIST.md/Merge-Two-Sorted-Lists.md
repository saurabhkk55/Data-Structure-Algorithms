# [21](https://leetcode.com/problems/merge-two-sorted-lists/). `Merge Two Sorted Lists`

## `Better: using a new Linked list to have the merge of Two sorted lists`
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode t1 = list1, t2 = list2;
        
        ListNode prevNode = new ListNode(-1);
        ListNode ansHead = prevNode;
        
        while(t1 != null && t2 != null) {
            ListNode newNode;
            if(t1.val <= t2.val) {
                newNode = new ListNode(t1.val);
                prevNode.next = newNode;
                t1 = t1.next;
            } else {
                newNode = new ListNode(t2.val);
                prevNode.next = newNode;
                t2 = t2.next;
            }
            prevNode = newNode;
        }
        
        while(t1 != null) {
            ListNode newNode = new ListNode(t1.val);
            prevNode.next = newNode;
            t1 = t1.next;
            prevNode = newNode;
        }
        
        while(t2 != null) {
            ListNode newNode = new ListNode(t2.val);
            prevNode.next = newNode;
            t2 = t2.next;
            prevNode = newNode;
        }
        
        return ansHead.next;
    }
}

// TC: O(n + m)
// SC: O(n + m)
// Here, n = length of list1 and,
//       m = length of list2
```
## `Optimal: No extra space, chainging links instead`
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode t1 = list1, t2 = list2;
        
        ListNode prevNode = new ListNode(-1);
        ListNode ansHead = prevNode;
        
        while(t1 != null && t2 != null) {
            if(t1.val <= t2.val) {
                prevNode.next = t1;
                prevNode = prevNode.next;
                t1 = t1.next;
                prevNode.next = null;
            } else {
                prevNode.next = t2;
                prevNode = prevNode.next;
                t2 = t2.next;
                prevNode.next = null;
            }
        }
        
        while(t1 != null) {
            prevNode.next = t1;
            prevNode = prevNode.next;
            t1 = t1.next;
            prevNode.next = null;
        }
        
        while(t2 != null) {
            prevNode.next = t2;
            prevNode = prevNode.next;
            t2 = t2.next;
            prevNode.next = null;
        }
        
        return ansHead.next;
    }
} 

// TC: O(n + m)
// SC: O(1)
// Here, n = length of list1 and,
//       m = length of list2
```
