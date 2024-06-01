import java.util.Queue;
import java.util.LinkedList;

class Custom_Queue {
    Queue<Integer> queue = new LinkedList<>();
    int queue_size = 0;

    public void push(int elem) {
        queue.add(elem);
        if(queue_size > 0) {
            for(int i=0; i<=queue_size-1; i++) {
                queue.add(queue.peek());
                queue.remove();
            }
        }
        queue_size++;
        System.out.printf("Pushed element: %d\n", elem);
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

public class StackUsingQueue {
    public static void main(String[] args) {
        Custom_Queue obj = new Custom_Queue();
        obj.push(10);
        obj.push(20);
        obj.push(30);
        obj.push(40);
        System.out.printf("Top element: %d\n", obj.top());
        System.out.printf("Popped element: %d\n", obj.pop());
        System.out.printf("Top element: %d\n", obj.top());
        System.out.println("Is Stack empty? "+obj.empty());
    }
}

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
