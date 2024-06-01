# [`Implement Stack using Linked List`](https://www.geeksforgeeks.org/problems/implement-stack-using-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=implement-stack-using-linked-list)

```java
class MyStack 
{
    // class StackNode {
    //     int data;
    //     StackNode next;
    //     StackNode(int a) {
    //         data = a;
    //         next = null;
    //     }
    // }   
    StackNode top;
    
    //Function to push an integer into the stack.
    void push(int a) 
    {
        // Add your code here
        StackNode newNode = new StackNode(a);
        newNode.next = top;
        top = newNode;
    }
    
    //Function to remove an item from top of the stack.
    int pop() 
    {
        // Add your code here
        if(top == null) return -1;
        int popped_elem = top.data;
        // StackNode next_node_addr = top.next;
        // top.next = null;
        // top = next_node_addr;
        top = top.next;
        return popped_elem;
    }
}
```
