import java.util.Stack;

class Solution {
    public boolean balanced_parentheses(String str) {
        Stack<Character> st = new Stack<>();
        for (char it : str.toCharArray()) {
            if (it == '(' || it == '{' || it == '[') {
                st.push(it);
                // System.out.println("Pushed to stack: " + it);
            } else {
                if (st.isEmpty()) {
                    // System.out.println("Unbalanced! Encountered closing bracket '" + it + "' but stack is empty.");
                    return false;
                } else {
                    char top = st.peek();
                    if ((it == ')' && top == '(') || (it == '}' && top == '{') || (it == ']' && top == '[')) {
                        st.pop();
                        // System.out.println("Popped from stack: " + top + " as it matches closing bracket: " + it);
                    } else {
                        // System.out.println("Unbalanced! Top of stack: '" + top + "' does not match closing bracket: '" + it + "'");
                        return false;
                    }
                }
            }
        }
        if (st.isEmpty()) {
            // System.out.println("All brackets matched. Stack is empty. The parentheses are balanced.");
            return true;
        } else {
            // System.out.println("Unbalanced! Stack is not empty: " + st);
            return false;
        }
    }
}

public class BalancedParentheses {
    public static void main(String[] args) {
        String str = "[()[{()}]]";
        // String str = "]()";
        // String str = "[()";
        // String str = "[(()]";
        // String str = "(]";
        boolean ans = new Solution().balanced_parentheses(str);
        if (ans) {
            System.out.printf("String: %s is a balanced parentheses\n", str);
        } else {
            System.out.printf("String: %s is not a balanced parentheses\n", str);
        }
    }
}

// TC: O(N) as completely iterating over the given string
// SC: O(N) as using stack

/*
1. **Initialize a Stack**:
    - Create an empty stack to keep track of opening parentheses.

2. **Iterate through each character in the string**:
    - For each character in the string, check if it is an opening parenthesis (`(`, `{`, `[`). If it is, push it onto the stack.
    - If the character is a closing parenthesis (`)`, `}`, `]`), check the following:
        - If the stack is empty, return `false` (this means there is no corresponding opening parenthesis).
        - Otherwise, check the top element of the stack:
            - If the top element is the corresponding opening parenthesis (`(` for `)`, `{` for `}`, `[` for `]`), pop the top element from the stack.
            - If it is not the corresponding opening parenthesis, return `false`.

3. **Final Check**:
    - After processing all characters in the string, check if the stack is empty:
        - If the stack is empty, return `true` (this means all parentheses were balanced).
        - If the stack is not empty, return `false` (this means there are unmatched opening parentheses).
*/
