class Solution {
    // Method to find the single number in an array where every other element appears three times
    static int singleNum (int[] arr) {
        int ones = 0; // To store the number which appear once
        int twos = 0; // To store the number which appear twice
        
        for (int i=0; i<arr.length; i++) {
            ones = ((ones ^ arr[i]) & (~twos));
            twos = ((twos ^ arr[i]) & (~ones));
        }

        return ones;
    }
}

public class singleNumber_Optimal {
    public static void main(String[] args) {
        int[] arr = {4, 4, 2, 9, 2, 4, 2};
        // int[] arr = {4, 4, 2, 3, 2, 4, 2};
        // int[] arr = {4, 4, 2, 1, 2, 4, 2};
        int ans = Solution.singleNum(arr);
        System.out.println("The Single element: "+ ans);
    }
}

// TC: O(n)
// SC: O(1)
// where, n = length of the given array
