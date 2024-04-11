class Solution {
    public int[] repeat_and_missing(int[] nums) {
        
        // code here
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        
        int n = nums.length;
        for (int i=1; i<=n; i++) {
            int count = 0;
            for (int j=0; j<n; j++) {
                if (nums[j] == i) {
                    count++;
                }
            }
            if (count == 2) result[0] = i; // repeating element
            else if (count == 0) result[1] = i; // missing element
            
            if (result[0] != -1 && result[1] != -1) {
                break;
            }
        }
        return result;
    }
}

public class RepeatMissing_Brute {
    public static void main(String[] args) {
        int[] arr = {1,4,2,6,3,1};
        // int[] arr = {1,4,2,6,3,5};
        Solution solve = new Solution();
        int[] ans = solve.repeat_and_missing(arr);
        System.out.println("Repeating element: "+ans[0]);
        System.out.println("Missing element: "+ans[1]);
    }
}

// TC: O(n*n)
// SC: O(1) only an array for storing only 2 elements that is why it is as good as constant
