import java.util.Stack;

class MinStack {
    Stack<Long> stk;
    long min = -1;
    
    public MinStack() {
        stk = new Stack<>();
    }
    
    public void push(int val) {
        if(stk.isEmpty()) {
            min = val;
            stk.push((long) val);
        } else {
            if(val < min) {
                stk.push((2 * ((long) (val))) - min);
                min = val;
            } else {
                stk.push((long) val);
                min = Math.min(min, val);
            }
        }
    }
    
    public void pop() {
        long top_elem = stk.peek();
        
        if(top_elem < min) {
            min = (2 * min) - top_elem;
            stk.pop();
        } else {
            stk.pop();
        }
    }
    
    public int top() {
        long top_elem = stk.peek();
        
        if(top_elem < min) return (int) min;
        else return (int) top_elem;
    }
    
    public int getMin() {
        return (int) min;
    }
}

public class Optima {
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
// SC: O(N)

/*
### Algorithm for MinStack

1. **Initialization**:
    - Create an empty stack `stk` of `Long` objects.
    - Initialize `min` to a default value (-1 in this case).

2. **Push Operation**:
    - If `stk` is empty:
        - Set `min` to `val`.
        - Push `(long) val` onto the stack.
    - Else:
        - If `val` < `min`:
            - Push `(2 * (long)val) - min` onto the stack.
            - Update `min` to `val`.
        - Else:
            - Push `(long) val` onto the stack.
            - Update `min` to `Math.min(min, val)`.

3. **Pop Operation**:
    - Retrieve `top_elem` from `stk.peek()`.
    - If `top_elem` < `min`:
        - Update `min` to `(2 * min) - top_elem`.
        - Pop `top_elem` from the stack.
    - Else:
        - Pop `top_elem` from the stack.

4. **Top Operation**:
    - Retrieve `top_elem` from `stk.peek()`.
    - If `top_elem` < `min`, return `min`.
    - Else, return `top_elem`.

5. **GetMin Operation**:
    - Return `min`.
 */
