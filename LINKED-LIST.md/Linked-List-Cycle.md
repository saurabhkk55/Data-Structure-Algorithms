# [Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/description/)

## `Better (using HashMap)`

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
    public boolean hasCycle(ListNode head) {
        ListNode currNode = head;
        HashMap<ListNode, Integer> hm = new HashMap<>();

        while((currNode != null) && (currNode.next != null)) {
            if(hm.containsKey(currNode) == false) {
                hm.put(currNode, 1);
            } else return true;

            currNode = currNode.next;
        }
        return false;
    }
}
```

## `Better (using HashSet)`

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
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> visited = new HashSet<>();
        
        ListNode currNode = head;

        while (currNode != null) {
            if (visited.contains(currNode)) {
                return true; // Cycle detected
            }
            visited.add(currNode);
            currNode = currNode.next;
        }
        return false; // No cycle detected
    }
}
```

## `Optimal`

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
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while((fast != null) && (fast.next != null)) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
}
```
