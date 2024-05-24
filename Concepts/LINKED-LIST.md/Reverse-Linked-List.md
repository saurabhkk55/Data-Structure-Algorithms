# [206](https://leetcode.com/problems/reverse-linked-list/description/). `Reverse Linked List`

## `Iterative`
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
    public ListNode reverseList(ListNode head) {
        ListNode next = null, currNode = head, prevNode = null;
        while(currNode != null) {
            next = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = next;
        }
        head = prevNode;
        return head;
    }
}
```

## `Recursive`
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
    public ListNode reverseList(ListNode head) {
        ListNode currNode = head;
        if((currNode == null) || (currNode.next == null)) return currNode;
        
        head = reverseList(currNode.next);
        ListNode front = currNode.next;
        front.next = currNode;
        currNode.next = null;
        
        return head;
    }
}
```
