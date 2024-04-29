class Solution {
    public static int findMin(int[] nums) {
        int n = nums.length;
        int low = 0, high = n- 1, minValue = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = (low+high)/2;

            if (nums[low] <= nums[high]) {
                minValue = Math.min(minValue, nums[low]);
                break;
            }

            if (nums[low] <= nums[mid]) {
                minValue = Math.min(minValue, nums[low]);
                low = mid + 1;
            } else {
                minValue = Math.min(minValue, nums[mid]);
                high = mid - 1;
            }
        }
        return minValue;
    }
}

public class MinimuminRotatedSortedArray_Optima {
    public static void main(String[] args) {
        // int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int[] arr = {7, 8, 1, 2, 3, 4, 5, 6};
        int ans = Solution.findMin(arr);
        System.out.println("Minimum in Rotated sorted array: "+ans);
    }
}

// Time Complexity: O(logbase2 N), N = size of the given array.
// Reason: We are basically using binary search to find the minimum. 
// Space Complexity: O(1)
// Reason: We have not used any extra data structures, this makes space complexity, even in the worst case as O(1).

// Algorithm:
// 1. Place the 2 pointers i.e. low and high: Initially, we will place the pointers like this: low will point to the first index, and high will point to the last index.
// 2. Calculate the ‘mid’: Now, inside a loop, we will calculate the value of ‘mid’ using the following formula:
//      mid = (low+high) / 2
// 3. If arr[low] <= arr[high]: In this case, the array from index low to high is completely sorted. Therefore, we can select the minimum element, arr[low], and update the 'minValue' variable with the minimum value i.e. min(minValue, arr[low]). Once this is done, there is no need to continue with the binary search algorithm. So, we will break from this step.
// 4. Identify the sorted half, and after picking the leftmost element, eliminate that half.
//      4.1. If arr[low] <= arr[mid]: This condition ensures that the left part is sorted. So, we will pick the leftmost element i.e. arr[low]. Now, we will compare it with 'minValue' and update 'minValue' with the smaller value (i.e., min(minValue, arr[low])). Now, we will eliminate this left half(i.e. low = mid+1).
// 	    4.2. Otherwise, if the right half is sorted:  This condition ensures that the right half is sorted. So, we will pick the leftmost element i.e. arr[mid]. Now, we will compare it with 'minValue' and update 'minValue' with the smaller value (i.e., min(minValue, arr[mid])). Now, we will eliminate this right half(i.e. high = mid-1).
// 5. This process will be inside a loop and the loop will continue until low crosses high. Finally, we will return the 'minValue' variable that stores the minimum element.
