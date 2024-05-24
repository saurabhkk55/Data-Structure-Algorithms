# [25](https://leetcode.com/problems/reverse-nodes-in-k-group/description/). `Reverse Nodes in k-Group`

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
        public void reverseList(ListNode head) {
        ListNode next = null, currNode = head, prevNode = null;
        while(currNode != null) {
            next = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = next;
        }
    }
    
    public ListNode getKthNode(ListNode currNode, int k) {
        k--;
        while(k != 0 && currNode != null) {
            currNode = currNode.next;
            k--;
        }
        if(k == 0) return currNode;
        return null;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head, prev_node = null;
        
        while(temp != null) {
            ListNode kth_node = getKthNode(temp, k);
            if(kth_node == null) {
                if (prev_node != null) prev_node.next = temp;
                break;
            }
            ListNode next_node = kth_node.next;
            kth_node.next = null;
            reverseList(temp);
            
            if(temp == head) {
                head = kth_node;
            } else {
                prev_node.next = kth_node; 
            }
            
            prev_node = temp;
            temp = next_node;
        }
        return head;
    }
}
```
