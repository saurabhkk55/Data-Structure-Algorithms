import java.util.Arrays;

class Solution {
    static int[] insertionSort(int[] nums) {
        int n = nums.length;
        for (int i=1; i<n; i++) {
            int j = i;
            while (j > 0 && nums[j] < nums[j-1]) {
                int temp = nums[j];
                nums[j] = nums[j-1];
                nums[j-1] = temp;
                j--;
            }
        }
        return nums;
    }
}

class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {13, 46, 24, 52, 20, 9};
        // int[] arr = {1, 2, 3, 4, 5, 6};
        // int[] arr = {14, 9, 15, 12, 6, 8, 13};
        // int[] arr = {14, 9, 15, 12, 6, 9, 13};
        // int[] arr = {14};
        int[] ans = Solution.insertionSort(arr);
        System.out.println("Sorted array via InsertionSort: "+ Arrays.toString(ans));
    }
}

/*
TC:
- Best: O(n)
- Average: O(n^2)
- Besworst: O(n^2)
SC: O(1)

Algorithm:
- Iterative Insertion: Start with the second element of the array and consider it as the key for insertion. Compare this key with the elements to its left in the sorted portion of the array.
- Shift and Insert: Move the elements greater than the key one position to the right to make space for the key. Insert the key into the correct position in the sorted portion of the array.
- Repeat: Continue this process for each subsequent element in the unsorted portion of the array until the entire array is sorted.
*/
