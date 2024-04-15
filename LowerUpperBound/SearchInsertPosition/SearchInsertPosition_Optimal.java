// This "Search Insert Position" is exactly similar to "Lower Bound": Smallest index such as arr[idx] >= target

class Solution {
    static int searchInsertPosition (int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int ans = nums.length;

        while (left <= right) {
            int mid = (left+right)/2;

            // if (nums[mid] == target) {
            //     return mid;
            // }
            // else if (nums[mid] > target) {
            //     right = mid - 1;
            //     ans = mid;
            // }
            if (nums[mid] >= target) {
                ans = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        
        return ans;
    }
}

class SearchInsertPosition_Optimal {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 8, 8, 10, 10, 11};
        int target = 9; // 12; // 9; // 1;
        int ans = Solution.searchInsertPosition(arr, target);
        System.out.println("Index at which Element which is just equal to or greater than is "+ans);
    }
}

// TC: O(log2n)
// SC: O(1)


// You are given a sorted array 'arr' of distinct values and a target value 'm'.
// You need to search for the index of the target value in the array.
// Note:
// If the value is present in the array, return its index.
// If the value is absent, determine the index where it would be inserted in the array while maintaining the sorted order. 
// Example 1:
// Input: nums = [1,3,5,6], target = 5
// Output: 2

// Example 2:
// Input: nums = [1,3,5,6], target = 2
// Output: 1

// Example 3:
// Input: nums = [1,3,5,6], target = 7
// Output: 4
