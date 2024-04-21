class Solution {
    static int findKthMissing (int[] arr, int k) {
        for (int i=0; i<arr.length; i++) {
            if (arr[i] <= k) {
                k++;
            }
        }
        return k;
    }
}

public class Brute {
    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 7};
        int k = 3;
        int ans = Solution.findKthMissing(arr, k);
        System.out.printf("%dth missing element is: %d", k, ans);
    }
}

// Time Complexity: O(N), N = size of the given array.
// Reason: We are using a loop that traverses the entire given array in the worst case.
// Space Complexity: O(1) as we are not using any extra space to solve this problem.

// Algorithm:
// 1. We will use a loop to traverse the array.
// 2. Inside the loop,
//     2.1. If vec[i] <= k: we will simply increase the value of k by 1.
//     2.2. Otherwise, we will break out of the loop.
// 3. Finally, we will return the value of k.

// Note: The main idea is to shift k by 1 step if the current element is smaller or equal to k. And whenever we get a number > k, we can conclude that k is the missing number.
