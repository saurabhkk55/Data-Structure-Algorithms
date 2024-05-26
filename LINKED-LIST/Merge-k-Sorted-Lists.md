# [23](https://leetcode.com/problems/merge-k-sorted-lists/description/). `Merge k Sorted Lists`

## `Better: Too many iterations are happenning here`
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
    public static ListNode mergeTwoList(ListNode list1, ListNode list2) {
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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        int i;
        
        for(i=0; i<lists.length; i++) {
            if(lists[i] != null) {
                head = lists[i];
                break;
            }
        }
        
        for(i=i+1; i<lists.length; i++) {
            head = mergeTwoList(head, lists[i]);
        }
        return head;
    }
}

// 1st Iteration: N1 + N2 (N1: no. of elements in list1, lly for N2) => 2N (if both have same no. of elements)
// 2nd Iteration: (N1 + N2) + N3 => 3N
// 3rd Iteration: (N1 + N2 + N3) + N4 => 4N
// .
// .
// .
// Kth Iteration: (N1 + N2 + N3 + ... ) + N (N: no. of elements in the Kth list) => kN

// => 2N + 3N + 4N + ... + KN => N (added just to derive formula) + 2N + 3N + 4N + ... + KN
// => N * (1 + 2 + 3 + 4 + ... + K) => N * formula of sum of first K natural numbers
// => N * [(K * (k+1))/2]
// Hence,
// TC: O(N * (((k)*(k+1))/2))
// SC: O(1)
```

## `Optimal: using priority queue`
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
    public ListNode mergeKLists(ListNode[] lists) {
        // Handle edge case where the input list is null or empty
        if (lists == null || lists.length == 0) return null;

        // Initialize a priority queue (min-heap) to manage ListNode objects
        // Comparator is defined to sort ListNode objects by their 'val' field in ascending order
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        // Add the head (first node) of each linked list to the priority queue
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }

        // Create a dummy node to serve as the starting point for the merged linked list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;      // 'current' pointer to build the merged list

        // Process the nodes in the priority queue until it's empty
        while (!pq.isEmpty()) {
            ListNode node = pq.poll(); // Extract the smallest node from the priority queue (removes the node from the queue)
            current.next = node;       // Append this node to the merged list
            current = current.next;    // Move the 'current' pointer to the next node
            
            // If the extracted node has a next node, add the next node to the priority queue
            if (node.next != null) {
                pq.add(node.next);
            }
        }
        
        // Return the head of the merged linked list (skipping the dummy node)
        return dummy.next;
    }
}

// TC: (k * logk) + ((k * N) * (2 * logk)) => klogk + kNlogk
// SC: O(k)

// here, N: no. of elements in each list, so total elements in k no. of list will be k * N
// logk: every single priority queue operation (`add()`, `poll()`) takes `logk` of time
```

**`NOTE`**:
- The `poll()` method `retrieves` and `removes` the head of the queue, which is the smallest element in the case of a min-heap PriorityQueue.
- If the queue is empty, `poll()` returns null.
