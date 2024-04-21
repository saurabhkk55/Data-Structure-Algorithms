public class Optimal {
    public static int missingK(int[] vec, int n, int k) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int missing = vec[mid] - (mid + 1);
            if (missing < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return k + high + 1; // or return low + k;
    }
    public static void main(String[] args) {
        int[] vec = {4, 7, 9, 10};
        int n = 4, k = 4;
        int ans = missingK(vec, n, k);
        System.out.println("The missing number is: " + ans);
    }
}

// Time Complexity: O(logbase2 N), N = size of the given array.
// Reason: We are using the simple binary search algorithm.
// Space Complexity: O(1) as we are not using any extra space to solve this problem.

// Problem Statement: You are given a strictly increasing array ‘vec’ and a positive integer 'k'. Find the 'kth' positive integer missing from 'vec'.
// Example 1:
// Input Format:
// vec[]={4,7,9,10}, k = 1
// Result:
// 1
// Explanation:
// The missing numbers are 1, 2, 3, 5, 6, 8, 11, 12, ……, and so on. Since 'k' is 1, the first missing element is 1.
// Example 2:
// Input Format:
// vec[]={4,7,9,10}, k = 4
// Result:
// 5
// Explanation:
// The missing numbers are 1, 2, 3, 5, 6, 8, 11, 12, ……, and so on. Since 'k' is 4, the fourth missing element is 5.

// Algorithm:
// 1. Place the 2 pointers i.e. low and high: Initially, we will place the pointers. The pointer low will point to index 0 and the high will point to index n-1 i.e. the last index.
// 2. Calculate the ‘mid’: Now, inside the loop, we will calculate the value of ‘mid’ using the following formula:
// mid = (low+high) // 2 ( ‘//’ refers to integer division)
// 3. Eliminate the halves based on the number of missing numbers up to index ‘mid’:
// We will calculate the number of missing numbers using the above-said formula like this: missing_numbers = vec[mid] - (mid+1).
// 3.1. If missing_numbers < k: On satisfying this condition, we can conclude that we are currently at a smaller index. But we want a larger index. So, we will eliminate the left half and consider the right half(i.e. low = mid+1).
// 3.2. Otherwise, we have to consider smaller indices. So, we will eliminate the right half and consider the left half(i.e. high = mid-1).
// 4. Finally, when we are outside the loop, we will return the value of (k+high+1) i.e. the kth missing number.
// The steps from 2-3 will be inside a loop and the loop will continue until low crosses high.
