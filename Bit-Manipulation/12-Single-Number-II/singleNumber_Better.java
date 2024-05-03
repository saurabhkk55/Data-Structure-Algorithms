class Solution {
    // Method to find the single number in an array where every other element appears three times
    static int singleNum (int[] arr) {
        int len = arr.length, temp_ans = 0;
        
        for (int i=0; i<=31; i++) {
            int cnt = 0;
            for (int j=0; j<len; j++) {
                if ((arr[j] & (1 << i)) != 0) cnt++;
            }
            // System.out.println("cnt: "+cnt);
            temp_ans = (temp_ans | ((cnt % 3) << i));
        }
        return temp_ans;
    }
}

public class singleNumber_Better {
    public static void main(String[] args) {
        // int[] arr = {4, 4, 2, 9, 2, 4, 2};
        // int[] arr = {4, 4, 2, 3, 2, 4, 2};
        // int[] arr = {4, 4, 2, 1, 2, 4, 2};
        // int[] arr = {4, 4, 2, 2, 4, 2, Integer.MAX_VALUE};
        int[] arr = {4, 4, 2, 2, 4, 2, Integer.MIN_VALUE};
        int ans = Solution.singleNum(arr);
        System.out.println("The Single element: "+ ans);
    }
}

// TC: O(n*32)
// SC: O(1)
// where, n = length of the given array
