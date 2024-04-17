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
