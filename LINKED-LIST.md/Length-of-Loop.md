# [`Find length of Loop`](https://www.geeksforgeeks.org/problems/find-length-of-loop/1)

## `Better`
```java
import java.util.HashMap;

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
 };

*****************************************************************/

public class Solution
{
    public static int lengthOfLoop(Node head) {
        // Write your code here
        HashMap<Node, Integer> hm = new HashMap<>();
        int len = 0;
        Node currNode = head;
        while((currNode != null) && (currNode.next != null)) {
            len++;
            if(!hm.containsKey(currNode)) {
                hm.put(currNode, len);
            } else {
                len = len - hm.get(currNode);
                return len;
            }
            currNode = currNode.next;
        }
        return 0;
    }
}
```

## `Optimal`
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
 };

*****************************************************************/

public class Solution
{
    public static int loop_length(Node slow, Node fast) {
        int len = 0;
        while((fast != null) && (fast.next != null)) {
            fast = fast.next;
            len++;
            if(slow == fast) return len;
        }
        return 0; // dummy
    }
    public static int lengthOfLoop(Node head) {
        // Write your code here
        Node slow = head, fast = head;
        while((fast != null) && (fast.next != null)) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return loop_length(slow, fast);
        }
        return 0;
    }
}
```
