# [`Two Stacks`](https://www.naukri.com/code360/problems/two-stacks_983634?leftPanelTab=0%3Fsource%3Dyoutube&campaign=YouTube_CodestudioLovebabbar5thfeb&utm_source=youtube&utm_medium=affiliate&utm_campaign=YouTube_CodestudioLovebabbar5thfeb&leftPanelTabValue=PROBLEM)

```java
import java.util.* ;
import java.io.*; 
public class TwoStack {

	// Initialize TwoStack.
	int[] arr;
	int left_top, right_top, arr_len;
	public TwoStack(int s) {
		// Write your code here
		arr = new int[s];
		left_top = -1;
		right_top = s;
		arr_len = s;
	}

	// Push in stack 1.
	public void push1(int num) {
		// Write your code here
		// minimum of 1 space is reqd for new elem
		if(right_top - left_top > 1) {
			left_top++;
			arr[left_top] = num;
		}
	}

	// Push in stack 2.
	public void push2(int num) {
		// Write your code here
		// minimum of 1 space is reqd for new elem
		if(right_top - left_top > 1) {
			right_top--;
			arr[right_top] = num;
		}
	}

	// Pop from stack 1 and return popped element.
	public int pop1() {
		// Write your code here
		if(left_top == -1) return -1;
		int pop_elem = arr[left_top];
		left_top--;
		return pop_elem;
	}

	// Pop from stack 2 and return popped element.
	public int pop2() {
		// Write your code here
		if(right_top == arr_len) return -1;
		int pop_elem = arr[right_top];
		right_top++;
		return pop_elem;
	}

}
```
