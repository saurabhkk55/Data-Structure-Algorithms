import java.io.*; 

class Solution {

	static int sqrtN(long N) {
		long low  = 0, high = N; 
		int ans = 0;

		while (low <= high) {
			long mid = (low+high)/2;

			if (mid*mid <= N) {
				ans = (int) mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		// We can return either of ans or high, both store our correct answer
		return ans; // or return (int) high;
	}
}

public class SquareRoot_Optimal {
	public static void main(String[] args) {
		long findMyRoot = 28;
		int ans = Solution.sqrtN(findMyRoot);
		System.out.printf("Square root of %d is: %d%n", findMyRoot, ans);
		// System.out.println(String.format("Square root of %d is: %d", findMyRoot, ans));
		// System.out.println("Square root of "+findMyRoot+"is: "+ans);
	}
}

// Time Complexity: O(logbase2 N), N = size of the given array.
// Reason: We are basically using the Binary Search algorithm.
// Space Complexity: O(1) as we are not using any extra space.

// Algorithm:
// We will declare a variable called ‘ans’.

// 1. Place the 2 pointers i.e. low and high: Initially, we will place the pointers. The pointer low will point to 1 and the high will point to n.
// 2. Calculate the ‘mid’: Now, inside a loop, we will calculate the value of ‘mid’ using the following formula:
// mid = (low+high) // 2 ( ‘//’ refers to integer division)
// 3. Eliminate the halves accordingly: 
// 3.1. If mid*mid <= n: On satisfying this condition, we can conclude that the number ‘mid’ is one of the possible answers. So, we will store ‘mid’ in the variable ‘ans’. But we want the maximum number that holds this condition. So, we will eliminate the left half and consider the right half(i.e. low = mid+1).
// 3.2. Otherwise, the value mid is larger than the number we want. This means the numbers greater than ‘mid’ will not be our answers and the right half of ‘mid’ consists of such numbers. So, we will eliminate the right half and consider the left half(i.e. high = mid-1).
// 4. Finally, the ‘ans’ variable will be storing our answer. In addition to that, the high pointer will also point to the same number i.e. our answer. So, we can return either of the ‘ans’ or ‘high’.
// The steps from 2-3 will be inside a loop and the loop will continue until low crosses high.
