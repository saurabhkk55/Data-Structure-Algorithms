import java.util.Arrays;

class Solution {
    public static int maxProduct(int[] nums) {
        // System.out.println(Arrays.toString(nums));
        int n = nums.length, ans = 0, max=Integer.MIN_VALUE;
        for (int i=0; i<n; i++) {
            ans = nums[i];
            for (int j=i+1; j<n; j++) {
                ans = ans * nums[j];
                if (ans > max) {
                    max = ans;
                }
            }
        }
        return max;
    }
}

public class maxProductSubArray_Brute {
    public static void main(String[] args) {
        int[] arr = {2, 3, -2, 4};
        int ans = Solution.maxProduct(arr);
        System.out.println("Maximum product SubArray: "+ ans);
    }
}
