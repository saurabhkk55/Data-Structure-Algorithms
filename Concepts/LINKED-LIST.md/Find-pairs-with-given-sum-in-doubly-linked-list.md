# [`Find pairs with given sum in doubly linked list`](https://www.geeksforgeeks.org/problems/find-pairs-with-given-sum-in-doubly-linked-list/1?page=1&category=doubly-linked-list&sortBy=submissions)

```java
/*
Definition for singly Link List Node

class Node
{
    int data;
    Node next,prev;
    
    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}
*/

class Solution {
    public static Node tail(Node head) {
        Node currNode = head;
        
        while(currNode.next != null) {
            currNode = currNode.next;
        }
        return currNode;
    }
    
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        // code here
        Node left = head, right = tail(head);
        ArrayList<ArrayList<Integer>> ans_list = new ArrayList<>();
        
        while(left.data < right.data) {
            if((left.data + right.data) < target) left = left.next;
            else if ((left.data + right.data) > target) right = right.prev;
            else {
                ArrayList<Integer> temp_list = new ArrayList<>();
                temp_list.add(left.data);
                temp_list.add(right.data);
                ans_list.add(temp_list);
                
                left = left.next;
                right = right.prev;
            }
        }
        return ans_list;
    }
}
```
