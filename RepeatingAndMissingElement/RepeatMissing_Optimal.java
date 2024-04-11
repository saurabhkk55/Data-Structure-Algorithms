class Solution {
    public long[] repeat_and_missing(long[] nums) {
        
        // code here
        long s1 = 0, s2 = 0;
        long sn1, sn2;
        long n = nums.length;

        for (int i=0; i<n; i++){
            s1 = s1 + (long) nums[i];
            s2 = s2 + ((long) nums[i] * (long) nums[i]);
        }

        sn1 = (n*(n+1))/2;         // Sum of first N natural numbers
        sn2 = (n*(n+1)*(2*n+1))/6; // sum of the squares of the first n natural numbers

        long val1 = sn1 - s1;   // x - y
        long val2 = sn2 - s2;   // x^2 - y^2
        val2 = val2/val1;       // (x^2 - y^2)/(x - y)
        val1 = (val1+val2)/2;   // ((x - y) + (x + y))/2 => missing element
        val2 = val2 - val1;     // (x + y) - x => repeating element

        long[] result = {val2, val1};
        return result;
    }
}

public class RepeatMissing_Optimal {
    public static void main(String[] args) {
        long[] arr = {1,4,2,6,3,6};
        // long[] arr = {1,4,2,6,3,1};
        Solution solve = new Solution();
        long[] ans = solve.repeat_and_missing(arr);
        System.out.println("Repeating element: "+ans[0]);
        System.out.println("Missing element: "+ans[1]);
    }
}

// TC: O(n)
// SC:  O(1) only an array for storing only 2 elements that is why it is as good as constant
