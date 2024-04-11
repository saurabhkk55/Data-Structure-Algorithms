class Solution {
    public int[] repeat_and_missing(int[] nums) {
        
        // code here
        int[] result = new int[2];

        int n = nums.length;
        int[] temp = new int[n+1];
        
        for (int i=0; i<n; i++){
            temp[nums[i]] = temp[nums[i]] + 1; // temp[nums[i]]++;
        }
        
        int repeat = -1, missing = -1;
        for (int i=1; i<n+1; i++) { // n+1 is the length of temp array
            if (temp[i] == 2) repeat = i;
            else if (temp[i] == 0) missing = i;
            
            if (repeat != -1 && missing != -1) {
                break;
            }
        }
        result[0] = repeat;
        result[1] = missing;
        return result;
    }
}

public class RepeatMissing_Better {
    public static void main(String[] args) {
        int[] arr = {1,4,2,6,3,1};
        Solution solve = new Solution();
        int[] ans = solve.repeat_and_missing(arr);
        System.out.println("Repeating element: "+ans[0]);
        System.out.println("Missing element: "+ans[1]);
    }
}

// TC: O(2n)
// SC: O(n) because of the temp array that is used here to store the frequency of each elements.
