// Lower Bound: Smallest index such as arr[idx] >= target

class Solution {
    static int lowerBound (int[] nums, int target) {
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

class LowerBound_Optimal {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 8, 8, 10, 10, 11};
        int target = 9; // 12; // 9; // 1;
        int ans = Solution.lowerBound(arr, target);
        System.out.println("Index at which Element which is just equal to or greater than is "+ans);
    }
}

// TC: O(log2n)
// SC: O(1)
