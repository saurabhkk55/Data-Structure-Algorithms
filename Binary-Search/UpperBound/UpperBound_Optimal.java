// Upper Bound:  Smallest index such as arr[idx] > target

class Solution {
    static int upperBound (int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        // int ans = nums.length;

        while (low <= high) {
            int mid = (low+high)/2;

            if (nums[mid] <= target) {
                low = mid + 1;
            }
            else {
                // ans = mid;
                high = mid - 1;
            }
        }
        
        // return ans;
        return low;
    }
}

class UpperBound_Optimal {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 8, 8, 10, 10, 11};
        int target = 1; // 12; // 9; // 1 // 0;
        int ans = Solution.upperBound(arr, target);
        System.out.println("Index at which Element which is just greater than target is "+ans);
    }
}

// TC: O(log2n)
// SC: O(1)
