import java.util.Arrays;

class Solution {
    public static int maxProduct(int[] nums) {
        int n = nums.length, ans = Integer.MIN_VALUE, prefix = 1, suffix = 1;
        for (int i=0; i<n; i++) {
            if (prefix == 0) prefix = 1;
            if (suffix == 0) suffix = 1;
            prefix = prefix * nums[i];
            suffix = suffix * nums[n-i-1];
            ans = Math.max(ans, Math.max(prefix, suffix));
        }
        return ans;
    }
}

public class maxProductSubArray_Optimal {
    public static void main(String[] args) {
        // int[] arr = {2, 3, -2, 4, 5, 0, 12};
        int[] arr = {2, 3, 8, 0, -2, 4, 5, 0, 12};
        int ans = Solution.maxProduct(arr);
        System.out.println("Maximum product SubArray: "+ ans);
    }
}
