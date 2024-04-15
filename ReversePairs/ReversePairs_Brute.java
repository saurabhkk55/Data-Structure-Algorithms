class Solution {
    static long reversePairs (long[] nums) {
        int n = nums.length;
        long count = 0;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                if (nums[i] > 2*nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
class ReversePairs_Brute {
    public static void main(String[] args) {
        long[] arr = {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647}; // {40, 25, 19, 12, 9, 6, 2}; // {40, 25, 19, 12, 9, 6, 2}; // {4, 1, 2, 3, 1};
        long ans = Solution.reversePairs(arr);
        System.out.println("Reversed pair counts: "+ans);
    }
}

// TC: O(n^2)
// SC: O(1)
