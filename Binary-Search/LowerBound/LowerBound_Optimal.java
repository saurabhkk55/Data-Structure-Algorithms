// Lower Bound: Smallest index such as arr[idx] >= target

class Solution {
    static int lowerBound (int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        // int ans = nums.length;

        while (low <= high) {
            int mid = (low+high)/2;

            if (nums[mid] >= target) {
                // ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        
        // return ans;
        return low;
    }
}

class LowerBound_Optimal {
    public static void main(String[] args) {
        // int[] arr = {1, 2, 3, 4, 5, 8, 8, 10, 10, 11};
        int[] arr = {1, 8, 8, 8, 8, 8, 8, 10, 10, 11};
        int target = 8; // 12; // 9; // 1;
        int ans = Solution.lowerBound(arr, target);
        System.out.println("Index at which Element which is just equal to or greater than is "+ans);
    }
}

// TC: O(log2n)
// SC: O(1)
