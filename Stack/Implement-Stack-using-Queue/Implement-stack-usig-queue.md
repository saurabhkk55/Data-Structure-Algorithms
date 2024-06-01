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
```
