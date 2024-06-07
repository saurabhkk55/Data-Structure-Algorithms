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
}

public class InsertATBottom {
    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();
        stk.push(10);
        stk.push(20);
        stk.push(30);
        stk.push(40);
        stk.push(50);
        System.out.println(stk);
        int insert_me_at_bottom = 60;
        Solution obj = new Solution();
        System.out.println(obj.insert_at_bottom(stk, insert_me_at_bottom));
    }
}

/*
### Algorithm: Insert an Element at the Bottom of a Stack

**Input:** 
- A stack `stk` of integers.
- An integer `x` to be inserted at the bottom of the stack.

### Steps:
1. **Base Case:**
    - If the stack `stk` is empty:
        - Push `x` onto the stack `stk`.
        - Return the stack `stk`.

2. **Recursive Case:**
    - If the stack `stk` is not empty:
        - Pop the top element from the stack and store it in a variable `peek_elem`.
        - Recursively call the `insert_at_bottom` function to insert `x` into the now smaller stack.
        - Push `peek_elem` back onto the stack `stk` to restore its original order.
        - Return the stack `stk`.
*/
