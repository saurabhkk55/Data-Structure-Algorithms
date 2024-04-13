import java.util.Arrays;

class Solution {
    static int[] bubbleSort(int[] nums) {
        int n = nums.length;
        boolean isSwapped = false;

        for (int i=n-2; i>=0; i--) {
            for (int j=0; j<=i; j++) {
                if (nums[j] > nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    isSwapped = true;
                }
            }
            if (isSwapped == false) {
                break;
            }
        }
        return nums;
    }
}

class BubbleSort {
    public static void main(String[] args) {
        // int[] arr = {13, 46, 24, 52, 20, 9};
        // int[] arr = {1, 2, 3, 4, 5, 6};
        int[] arr = {14, 9, 15, 12, 6, 9, 13};
        int[] ans = Solution.bubbleSort(arr);
        System.out.println("Sorted array via BubbleSort: "+ Arrays.toString(ans));
    }
}

/*
TC:
- Best: O(n)
- Average: O(n^2)
- Besworst: O(n^2)
SC: O(1)

Algorithm:
- Iterative Comparison: Start with the first element of the array and compare it with the next element. If the first element is greater than the second element, swap them.
- Repeat: Move to the next pair of adjacent elements and repeat the comparison and swap process until the end of the array.
- Multiple Passes: After the first pass, the largest (or smallest, depending on sorting order) element will be in its correct position at the end of the array. Repeat steps 1 and 2 for the remaining unsorted portion of the array.
- Optimization: To optimize the algorithm, introduce a flag to track whether any swaps were made during a pass. If no swaps are made during a pass, the array is already sorted, and the algorithm can terminate early.
*/
