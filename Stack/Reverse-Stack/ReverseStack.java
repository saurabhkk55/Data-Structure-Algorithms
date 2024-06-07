import java.util.Stack;

class Solution {
    public Stack<Integer> insert_at_bottom(Stack<Integer> stk, int x) {
        if(stk.isEmpty()) {
            stk.push(x);
            return stk;
        }
        int peek_elem = stk.peek();
        stk.pop();
        insert_at_bottom(stk, x);
        stk.push(peek_elem);
        return stk;
    }
    public Stack<Integer> reverse(Stack<Integer> stk, int peek_elem) {
        if(stk.isEmpty()) {
            return stk;
        }
        peek_elem = stk.peek();
        stk.pop();
        reverse(stk, peek_elem);
        insert_at_bottom(stk, peek_elem);
        return stk;
    }
    public void reverse_stack(Stack<Integer> stk, int peek_elem) {
        reverse(stk, stk.peek());
    }
}

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();
        stk.push(10);
        stk.push(20);
        stk.push(30);
        stk.push(40);
        stk.push(50);
        System.out.println("Before reverse: "+stk);
        Solution obj = new Solution();
        obj.reverse_stack(stk, 50);
        System.out.println("After  reverse: "+stk);
    }
}

/*
Pre-requisite:
We must know how to insert an element at the bottom of a stack.

### Steps:
1. **Base Case:**
    - If the stack `stk` is empty:
        - Return the stack `stk`.

2. **Recursive Case:**
    - If the stack `stk` is not empty:
        - Save the Top element as peek_elem
        - Pop the Top element
        - Recursively call the `reverse` function until the stack becomes empty (hit the base condition).
        - Recursively call the `insert_at_bottom` function to insert `peek_elem` into the now smaller stack. [look into the algo of insert element at bottom of the stack, path: Stack\Insert-At-Bottom\InsertATBottom.java]
        - Return the stack `stk`.
 */
