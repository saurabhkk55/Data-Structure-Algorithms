import java.util.Stack;

class Pair {
    public int val;
    public int min;

    public Pair(int val, int min) {
        this.val = val;
        this.min = min;
    }
}


class MinStack {
    Stack<Pair> stk;
    int min = Integer.MAX_VALUE;
    
    public MinStack() {
        stk = new Stack<>();
    }
    
    public void push(int val) {
        if(stk.isEmpty()) stk.push(new Pair(val, val));
        else {
            min = Math.min(stk.peek().min, val);
            stk.push(new Pair(val, min));
        }
    }
    
    public void pop() {
        stk.pop();
    }
    
    public int top() {
        return stk.peek().val;
    }
    
    public int getMin() {
        return stk.peek().min;
    }
}

public class Better {
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(-2);
        obj.push(0);
        obj.push(-3);
        System.out.println("Minimum value: "+obj.getMin());
        System.out.println("Top element: "+obj.top());
        obj.pop();
        System.out.println("Minimum value: "+obj.getMin());
        System.out.println("Top element: "+obj.top());
    }
}

// TC: O(1)
// SC: O(2N) beacuse of a pair contains 2 value

/*
### Algorithm for MinStack

1. **Initialize Data Structures**:
    - Create a stack `stk` to store pairs of integers (`Pair` objects), where each pair consists of:
        - `val`: the value being pushed.
        - `min`: the minimum value in the stack up to this point.
    - Initialize `min` to `Integer.MAX_VALUE`.

2. **Push Operation**:
    - If `stk` is empty:
        - Push `new Pair(val, val)` onto the stack.
    - Else:
        - Retrieve `min` from `stk.peek().min`.
        - Update `min` to `Math.min(stk.peek().min, val)`.
        - Push `new Pair(val, min)` onto the stack.

3. **Pop Operation**:
    - Remove the top element from the stack using `stk.pop()`.

4. **Top Operation**:
    - Retrieve and return `stk.peek().val`.

5. **GetMin Operation**:
    - Retrieve and return `stk.peek().min`.
 */
