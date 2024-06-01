import java.util.Queue;
import java.util.LinkedList;

class Custom_Queue {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public void push(int elem) {
        q2.add(elem);

        while(q1.isEmpty() == false) {
            q2.add((q1.peek()));
            q1.remove();
        }

        while(q2.isEmpty() == false) {
            q1.add((q2.peek()));
            q2.remove();
        }
        System.out.printf("Pushed element: %d\n", elem);
    }

    public int pop() {
        return q1.remove();
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }

}

public class StackUsingTwoQueues {
    public static void main(String[] args) {
        Custom_Queue obj = new Custom_Queue();
        obj.push(10);
        obj.push(20);
        obj.push(30);
        System.out.printf("Popped element: %d\n", obj.pop());
        obj.push(40);
        System.out.printf("Top element: %d\n", obj.top());
        System.out.printf("Popped element: %d\n", obj.pop());
        System.out.printf("Popped element: %d\n", obj.pop());
        System.out.println("Is Stack empty? "+obj.empty());
        System.out.printf("Popped element: %d\n", obj.pop());
        System.out.println("Is Stack empty? "+obj.empty());
    }
}

/*
### Algorithm for `push(int elem)`
1. Add the new element `elem` to `q2`.
2. While `q1` is not empty:
    - Move all elements from `q1` to `q2`.
3. While `q2` is not empty:
    - Move all elements from `q2` back to `q1`.
4. Print the pushed element.

### Algorithm for `pop()`
1. Remove and return the front element from `q1`.

### Algorithm for `top()`
1. Return the front element from `q1` without removing it.

### Algorithm for `empty()`
1. Return `true` if `q1` is empty; otherwise, return `false`.
*/
