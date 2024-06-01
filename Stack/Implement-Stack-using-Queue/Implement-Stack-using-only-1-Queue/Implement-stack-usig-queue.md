# [225](https://leetcode.com/problems/implement-stack-using-queues/description/). Implement Stack using Queue


```java
class MyStack {
    Queue<Integer> queue;
    int queue_size;

    public MyStack() {
        queue = new LinkedList<>();
        queue_size = 0;
    }
    
    public void push(int x) {
        queue.add(x);
        if(queue_size > 0) {
            for(int i=0; i<=queue_size-1; i++) {
                queue.add(queue.peek());
                queue.remove();
            }
        }
        queue_size++;
    }
    
    public int pop() {
        queue_size--;
        return queue.remove();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/*
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

/*
### Algorithm for `push(int elem)`
1. Add the new element `elem` to the queue.
2. If the current size of the queue (`queue_size`) is greater than 0:
    - For each element already in the queue (except the newly added one):
        - Add the front element of the queue to the back of the queue.
        - Remove the front element of the queue.
3. Increment `queue_size` by 1.
4. Print the pushed element.

### Algorithm for `pop()`
1. Decrement `queue_size` by 1.
2. Remove and return the front element of the queue.

### Algorithm for `top()`
1. Return the front element of the queue without removing it.

### Algorithm for `empty()`
1. Return `true` if the queue is empty; otherwise, return `false`.
*/
```
