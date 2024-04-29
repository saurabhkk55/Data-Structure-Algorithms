


import java.util.*;

public class Brute {
    public static int countPartitions(int[] a, int maxSum) {
        int n = a.length; //size of array.
        int partitions = 1;
        long subarraySum = 0;
        for (int i = 0; i < n; i++) {
            if (subarraySum + a[i] <= maxSum) {
                //insert element to current subarray
                subarraySum += a[i];
            } else {
                //insert element to next subarray
                partitions++;
                subarraySum = a[i];
            }
        }
        return partitions;
    }

    public static int largestSubarraySumMinimized(int[] a, int k) {
        int low = a[0];
        int high = 0;
        //find maximum and summation:
        for (int i = 0; i < a.length; i++) {
            low = Math.max(low, a[i]);
            high += a[i];
        }

        for (int maxSum = low; maxSum <= high; maxSum++) {
            if (countPartitions(a, maxSum) == k)
                return maxSum;
        }
        return low;
    }

    public static void main(String[] args) {
        int[] a = {10, 20, 30, 40};
        int k = 2;
        int ans = largestSubarraySumMinimized(a, k);
        System.out.println("The answer is: " + ans);
    }
}

// Time Complexity: O[(N)+(N * (sum(arr[])-max(arr[])+1))], where N = size of the array, sum(arr[]) = sum of all array elements, max(arr[]) = maximum of all array elements.
// Reason: We are using a loop from max(arr[]) to sum(arr[]) to check all possible values of time. Inside the loop, we are calling the countPartitions() function for each number. Now, inside the countPartitions() function, we are using a loop that runs for N times.
// Space Complexity:  O(1) as we are not using any extra space to solve this problem.

// Naive Approach: 
// The extremely naive approach is to check all possible answers from max(arr[]) to sum(arr[]). The minimum value for which we can make k subarrays will be our answer.

// Algorithm:
// 1. First, we will find the maximum element and the summation of the given array.
// 2. We will use a loop(say maxSum) to check all possible answers from max(arr[]) to sum(arr[]).
// 3. Next, inside the loop, we will send ‘maxSum’, to the function countPartitions() function to get the number of partitions.
// 3.1. The first value of ‘maxSum’, for which the number of partitions will be equal to ‘k’, will be our answer. So, we will return that particular value of ‘maxSum’.
// 4. Finally, if we are out of the loop, we will return max(arr[]) as there cannot exist any answer smaller than that.
