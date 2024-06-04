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
                    if(precedence_of(item) >= precedence_of(top)) stk.push(item);
                    else {
                        while(!stk.isEmpty() && precedence_of(stk.peek()) > precedence_of(item)) {
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

    public String reverse(String str) {
        char[] charArray = str.toCharArray(); // Convert the String to a char array
        int i = 0;
        int j = charArray.length - 1;
    
        while (i <= j) {
            // Swap parentheses if found
            if (charArray[i] == '(') charArray[i] = ')';
            else if (charArray[i] == ')') charArray[i] = '(';
            
            if(j != i) {
                if (charArray[j] == ')') charArray[j] = '(';
                else if (charArray[j] == '(') charArray[j] = ')';
                
                // Swap characters
                char temp = charArray[i];
                charArray[i] = charArray[j];
                charArray[j] = temp;
            }
            
            i++;
            j--;
        }
        
        return new String(charArray); // Convert the char array back to a String and return it
    }
    

    public String infix_to_prefix(String str) {
        String reversed_str = reverse(str);
        System.out.println("Reversed Str: "+reversed_str);
        String infix_to_postfix_string = infix_to_postfix(reversed_str);
        System.out.println("infix_to_postfix_string: "+infix_to_postfix_string);
        String infix_to_prefix = reverse(infix_to_postfix_string);
        return infix_to_prefix;
    }
}

public class InfixToPrefix {
    public static void main(String[] args) {
        String infix_str = "a*b/(d+c)*e";           // its postfix should be */*ab+dce 
        // String infix_str = "a+b*(d+e)";          // its postfix should be +a*b+de
        // String infix_str = "h^m^q^(7-4)";        // its postfix should be ^^^hmq-74
        // String infix_str = "(a-b/c)*(a/k-l)";    // its postfix should be *-a/bc-/akl
        Solution obj = new Solution();
        String prefix_str = obj.infix_to_prefix(infix_str);
        System.out.printf("Infix: %s & Pretfix: %s", infix_str, prefix_str);
    }
}

/*
### Algorithm Steps:

1. **Reverse the Infix Expression:**
    - Reverse the input infix string.
    - While reversing, replace each '(' with ')' and vice versa.

2. **Convert Reversed Infix to Postfix:**
    - Use the algorithm for infix to postfix conversion on the reversed string with a single change mentioned below.
    - If an operator with equal or greater precedence than the top of the stack is encountered, push it onto the stack.
    - If an operator with lower precedence than the top of the stack is encountered, pop from the stack and append to `ans` until an operator with lower precedence or an empty stack is encountered, then push `item` onto the stack.

3. **Reverse the Postfix Expression:**
    - Reverse the postfix expression obtained from the previous step.
    - While reversing, replace each '(' with ')' and vice versa.

4. **The Resulting String is the Prefix Expression:**
    - The final reversed string from step 3 is the desired prefix expression.
 */
