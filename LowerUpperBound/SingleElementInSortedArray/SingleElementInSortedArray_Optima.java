class Solution {
    static int singleNonDuplicate (int[] nums) {
        int n = nums.length;
        
        // Edge cases:
        if (n == 1) {
            return nums[0];
        } else if (nums[0] != nums[1]) {
            return nums[0];
        } else if (nums[n-1] != nums[n-2]) {
            return nums[n-1];
        } else {
            int low = 1, high = n - 2;
            while (low <= high) {
                int mid = (low+high)/2;
                
                if ((nums[mid] != nums[mid-1]) && (nums[mid] != nums[mid+1])) {
                    return nums[mid];
                }
                
                // We are on the left half
                if ((mid%2 == 1 && nums[mid] == nums[mid-1]) || (mid%2 == 0 && nums[mid] == nums[mid+1])) {
                    low = mid + 1;
                } else { // We are on the right half
                    high = mid - 1;
                }
            }
            return -1; // dummy, this return statement will never execute
        }
    }
}
public class SingleElementInSortedArray_Optima {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6};
        // int[] arr = {1, 1, 3, 5, 5};
        int ans = Solution.singleNonDuplicate(arr);
        System.out.println("Single element in sorted array: "+ans);
    }
}

// Time Complexity: O(logbase2 N), N = size of the given array.
// Reason: We are basically using the Binary Search algorithm.
// Space Complexity: O(1) as we are not using any extra space.

// Algorithm:
// 1. If n == 1: This means the array size is 1. If the array contains only one element, we will return that element only.
// 2. If arr[0] != arr[1]: This means the very first element of the array is the single element. So, we will return arr[0].
// 3. If arr[n-1] != arr[n-2]: This means the last element of the array is the single element. So, we will return arr[n-1].
// 4. Place the 2 pointers i.e. low and high: Initially, we will place the pointers excluding index 0 and n-1 like this: low will point to index 1, and high will point to index n-2 i.e. the second last index.
// 5. Calculate the ‘mid’: Now, inside a loop, we will calculate the value of ‘mid’ using the following formula:
// 	mid = (low+high) / 2
// 6. Check if arr[mid] is the single element:
// 	If arr[mid] != arr[mid-1] and arr[mid] != arr[mid+1]: If this condition is true for arr[mid], we can conclude arr[mid] is the single element. We will return arr[mid].
// 7.If (mid % 2 == 0 and arr[mid] == arr[mid+1]) or (mid%2 == 1 and arr[mid] == arr[mid-1]): This means we are in the left half and we should eliminate it as our single element appears on the right. So, we will do this: low = mid+1.
// 8. Otherwise, we are in the right half and we should eliminate it as our single element appears on the left. So, we will do this: high = mid-1.
// The steps from 5 to 8 will be inside a loop and the loop will continue until low crosses high.
