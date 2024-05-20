# [`Intersection of Two Linked Lists`](https://www.naukri.com/code360/problems/-intersection-of-two-linked-lists_630457?utm_source=youtube&utm_medium=affiliate&utm_campaign=Codestudio_Linkedlistseries&leftPanelTabValue=PROBLEM)

## `Brute (using HashMap)`
```java
/****************************************************************
 Following is the class structure of the Node class:

 class Node {
    public int data;
    public Node next;

    Node() {
        this.data = 0;
        this.next = null;
    }
    Node(int data) {
        this.data = data;
        this.next = null;
    }
    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
 }
 *****************************************************************/

public class Solution {
    public static int findIntersection(Node firstHead, Node secondHead) {
        //Write your code here
        HashMap<Node, Integer> hm = new HashMap<>();

        Node currNode_first = firstHead;
        Node currNode_second = secondHead;

        while(currNode_first != null) {
            hm.put(currNode_first, 1);
            currNode_first = currNode_first.next;
        }

        while(currNode_second != null) {
            if(hm.containsKey(currNode_second)) {
                return currNode_second.data;
            }
            currNode_second = currNode_second.next;
        }

        return -1;
    }
}
```

## `Better`
```java
/****************************************************************
 Following is the class structure of the Node class:

 class Node {
    public int data;
    public Node next;

    Node() {
        this.data = 0;
        this.next = null;
    }
    Node(int data) {
        this.data = data;
        this.next = null;
    }
    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
 }
 *****************************************************************/

public class Solution {

    public static int get_me_intersection(Node firstHead, Node secondHead, int diff) {
        int x = -1;
        Node currNode_first = firstHead, currNode_second = secondHead;
        
        while(diff != 0) {
            currNode_first = currNode_first.next;
            diff--;
        }
        
        while(currNode_first != currNode_second) {
            currNode_first = currNode_first.next;
            currNode_second = currNode_second.next;
        }
        x = currNode_first.data;
        return x;
    }
    public static int findIntersection(Node firstHead, Node secondHead) {
        //Write your code here
        Node currNode_first = firstHead;
        Node currNode_second = secondHead;
        
        int list1_len = 0, list2_len = 0;
        
        while(currNode_first != null) {
            list1_len++;
            currNode_first = currNode_first.next;
        }
        
        while(currNode_second != null) {
            list2_len++;
            currNode_second = currNode_second.next;
        }
        
        int intersection;
        if(list1_len > list2_len) {
            intersection = get_me_intersection(firstHead, secondHead, (list1_len - list2_len));
        } else {
            intersection = get_me_intersection(secondHead, firstHead, (list2_len - list1_len));
        }
        
        return intersection;
    }
}
```
