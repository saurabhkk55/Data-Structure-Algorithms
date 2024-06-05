// Delete middle element from stack
// - If stack size is even then delete the first middle
// - If stack size is odd then there will be only 1 middle, just delete that

import java.util.Stack;

class Solution {
    public Stack<Integer> remove_middle_recursively(Stack<Integer> stk, int stk_orginal_size, int count) {
        if(count == stk_orginal_size/2) {
            stk.pop();
            return stk;
        }
        int top_elem = stk.peek();
        stk.pop();
        count++;
        remove_middle_recursively(stk, stk_orginal_size, count);
        stk.push(top_elem);
        return stk;
    }
    public Stack<Integer> remove_middle(Stack<Integer> stk) {
        int stk_orginal_size = stk.size();
        int count = 0;
        return remove_middle_recursively(stk, stk_orginal_size, count);
    }
}

public class Code {
    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();
        stk.push(10);
        stk.push(20);
        stk.push(30);
        stk.push(40);
        stk.push(50);
        Solution obj = new Solution();
        System.out.println(obj.remove_middle(stk));
    }
}
