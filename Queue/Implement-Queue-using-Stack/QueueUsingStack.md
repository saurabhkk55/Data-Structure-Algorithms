# [232](https://leetcode.com/problems/implement-queue-using-stacks/). Implement Queue using Stack

```java
class MyQueue {
    Stack<Integer> input;
    Stack<Integer> output;

    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }
    
    public void push(int x) {
        input.push(x);
    }
    
    public int pop() {
        if(output.isEmpty() == false) {
            return output.pop();
        } else {
            while(input.isEmpty() == false) {
                output.push(input.peek());
                input.pop();
            }
            return output.pop();
        }
    }
    
    public int peek() {
        if(output.isEmpty() == false) {
            return output.peek();
        } else {
            while(input.isEmpty() == false) {
                output.push(input.peek());
                input.pop();
            }
            return output.peek();
        }
    }
    
    public boolean empty() {
        if((input.isEmpty() == true) && (output.isEmpty() == true)) {
            return true;
        }
        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

// TC: O(1) amortised (not O(1) time complexity but mostly it is that only)
// SC: O(2N)

/*
### Algorithm for `push(int elem)`
1. Push `elem` onto `input`.
2. Print the pushed element.

### Algorithm for `pop()`
1. If `output` is not empty:
    - Return `output.pop()`.
2. If `output` is empty:
    - Transfer all elements from `input` to `output`.
    - Return `output.pop()`.

### Algorithm for `peek()`
1. If `output` is not empty:
    - Return `output.peek()`.
2. If `output` is empty:
    - Transfer all elements from `input` to `output`.
    - Return `output.peek()`.
*/
```
