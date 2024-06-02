import java.util.Stack;

class Solution {
    public int precedence_of(char ch) {
        if(ch == '^') return 4;
        if(ch == '/' || ch == '*') return 3;
        if(ch == '+' || ch == '-') return 2;
        else return 1; // if ch is '('
    }

    public String infix_to_postfix(String str) {
        String ans = "";
        Stack<Character> stk = new Stack<>();

        for(char item : str.toCharArray()) {
            if(item == '(') stk.push(item);
            else if((item >= 'a' && item <='z') || (item >= 'A' && item <='Z') || (item >= '0' && item <= '9')) ans = ans + item;
            else if(item == ')') {
                while(!stk.isEmpty() && stk.peek() != '(') {
                    ans = ans + stk.peek();
                    stk.pop();
                }
                if(!stk.isEmpty()) stk.pop();
            }
            else {
                if(stk.isEmpty()) stk.push(item);
                else {
                    char top = stk.peek();
                    if(precedence_of(item) > precedence_of(top)) stk.push(item);
                    else {
                        while(!stk.isEmpty() && precedence_of(stk.peek()) >= precedence_of(item)) {
                            ans = ans + stk.peek();
                            stk.pop();
                        }
                        stk.push(item);
                    }
                }
            }
        }
        while(!stk.isEmpty()) {
            ans = ans + stk.peek();
            stk.pop();
        }
        return ans;
    }
}

public class InfixToPostfix {
    public static void main(String[] args) {
        // String infix_str = "a*b/(d+c)*e"; // its postfix should be ab*dc+/e*
        // String infix_str = "a+b*(d+e)";      // its postfix should be abde+*+
        String infix_str = "h^m^q^(7-4)";      // its postfix should be hm^q^74-^
        Solution obj = new Solution();
        String postfix_str = obj.infix_to_postfix(infix_str);
        System.out.printf("Infix: %S & Postfix: %S", infix_str, postfix_str);
    }
}

/*
### Time and Space Complexity

- **Time Complexity**: O(n) where n is the length of the infix expression, as each character is processed once.
- **Space Complexity**: O(n) for the stack used to hold operators and parentheses.
*/

/*
### Algorithm for Converting Infix to Postfix

1. **Initialize Data Structures**:
    - Create an empty string `ans` to store the postfix expression.
    - Create an empty stack `stk` to hold operators and parentheses.

2. **Define Operator Precedence**:
    - Define a function `precedence_of(char ch)` that returns the precedence of the given operator:
        - `^` has precedence 4
        - `/` and `*` have precedence 3
        - `+` and `-` have precedence 2
        - `(` has precedence 1

3. **Iterate Through the Infix Expression**:
    - For each character `item` in the infix expression:
      - If `item` is `(`, push it onto the stack.
      - If `item` is an operand (between 'a' and 'z' or 'A' and 'Z' or '0' and '9'), append it to `ans`.
      - If `item` is `)`, pop from the stack and append to `ans` until `(` is encountered, then pop `(` from the stack.
      - If `item` is an operator:
        - If the stack is empty, push `item` onto the stack.
        - Otherwise, compare the precedence of `item` with the top of the stack:
          - If `item` has higher precedence, push `item` onto the stack.
          - If `item` has lower or equal precedence, pop from the stack and append to `ans` until an operator with lower precedence or an empty stack is encountered, then push `item` onto the stack.

4. **Pop Remaining Operators**:
    - After processing all characters, pop all remaining operators from the stack and append them to `ans`.

5. **Return the Postfix Expression**:
    - Return the final postfix expression stored in `ans`.
*/
