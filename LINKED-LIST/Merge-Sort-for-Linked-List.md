# [`Merge Sort for Linked List`](https://www.geeksforgeeks.org/problems/sort-a-linked-list/1)


```java
/*
class Node
{
    int data;
    Node next;
    Node(int key) {
        this.data = key;
        next = null;
    }
} */

class Solution
{
    public static Node mergeTwoLists(Node list1, Node list2) {
        Node t1 = list1, t2 = list2;
        
        Node prevNode = new Node(-1);
        Node ansHead = prevNode;
        
        while(t1 != null && t2 != null) {
            if(t1.data <= t2.data) {
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
    
	public static Node findMiddleNode(Node head) {
        Node slow = head, fast = head.next;
        while((fast != null) && (fast.next != null)) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    //Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head)
    {
        // add your code here
        if(head == null || head.next == null) return head;
        
        Node middleNode = findMiddleNode(head);
        Node leftHead = head;
        Node rightHead = middleNode.next;
        middleNode.next = null;
        
        leftHead = mergeSort(leftHead);
        rightHead = mergeSort(rightHead);
        
        return mergeTwoLists(leftHead, rightHead);
    }
}

// TC: logN * (N + (N/2))
// SC: O(1)
```