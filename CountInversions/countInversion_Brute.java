class Solution {
    static int countInversion (int[] nums) {
        int n = nums.length, count = 0;
        
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
        }
        
        return count;
    }
}

class countInversion_Brute {
    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 4, 1};
        int ans = Solution.countInversion(arr);
        System.out.println("Total Inversion pairs: "+ ans);
    }
}

// TC: O(n^2)
// SC: O(1)
