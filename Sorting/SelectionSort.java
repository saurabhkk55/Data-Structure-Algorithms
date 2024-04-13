import java.util.Arrays;

class Solution {
    static int[] selectionSort(int[] nums) {
        int n = nums.length;

        for (int i=0; i<n-1; i++) {
            for (int j=i+1; j<n; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }
}

class SelectionSort {
    public static void main(String[] args) {
        // int[] arr = {13, 46, 24, 52, 20, 9};
        // int[] arr = {1, 2, 3, 4, 5, 6};
        int[] arr = {14, 9, 15, 12, 6, 9, 13};
        int[] ans = Solution.selectionSort(arr);
        System.out.println("Sorted array via SelectionSort: "+ Arrays.toString(ans));
    }
}

/*
TC:
- Best: O(n^2)
- Average: O(n^2)
- Besworst: O(n^2)
SC: O(1)

Algorithm:
- Find the minimum: Start by assuming the first element of the array is the smallest. Then, iterate through the array to find the actual minimum element.
- Swap: Once the minimum element is found, swap it with the first element of the array.
- Repeat: Repeat steps 1 and 2 for the remaining unsorted portion of the array, starting from the second element, then the third, and so on.
- Termination: The above steps are repeated until the entire array is sorted.
*/
