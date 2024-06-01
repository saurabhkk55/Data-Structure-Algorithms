# [`Implement Queue using Linked List`](https://www.geeksforgeeks.org/problems/implement-queue-using-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=implement-queue-using-linked-list)

```java
class MyQueue
{
    QueueNode front, rear;
    
    //Function to push an element into the queue.
	void push(int a)
	{
        // Your code here
        QueueNode newNode = new QueueNode(a);
        if(front == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
	}
	
    //Function to pop front element from the queue.
	int pop()
	{
        // Your code here
        if(front == null) return -1;
        int pop_elem = front.data;
        front = front.next;
        return pop_elem;
	}
}

// TC: O(1)
// SC: O(N)
```
