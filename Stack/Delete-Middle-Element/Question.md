# [Delete middle element from stack](https://www.naukri.com/code360/problems/delete-middle-element-from-stack_985246?leftPanelTab=0%3Fsource%3Dyoutube&campaign=Lovebabbarcodestudio&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbarcodestudio&leftPanelTabValue=PROBLEM)

```java
import java.util.* ;
import java.io.*; 
public class Solution {
	public static Stack<Integer> delete_middle(Stack<Integer> stk, int stk_original_size, int count) {
		if(count == stk_original_size/2) {
			stk.pop();
			return stk;
		}
		int top_elem = stk.peek();
        stk.pop();
        count++;
        delete_middle(stk, stk_original_size, count);
        stk.push(top_elem);
        return stk;
	}

	public static void deleteMiddle(Stack<Integer> inputStack, int N) {
		// WRITE YOUR CODE HERE
		int inputStack_original_size = N+1;
		int count = 1;
		delete_middle(inputStack, inputStack_original_size, count);
	}
}
```
