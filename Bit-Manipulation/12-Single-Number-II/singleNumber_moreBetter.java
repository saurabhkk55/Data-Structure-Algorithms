import java.util.Arrays;

class Solution {
    // Method to find the single number in an array where every other element appears three times
    static int singleNum (int[] arr) {
        Arrays.sort(arr);
        
        for (int i=1; i<arr.length; i=i+3) {
            if (arr[i] != arr[i-1]) {
                return arr[i-1];
            }
        }
        
        return arr[arr.length-1];
    }
}

public class singleNumber_moreBetter {
    public static void main(String[] args) {
        int[] arr = {4, 4, 2, 9, 2, 4, 2};
        // int[] arr = {4, 4, 2, 3, 2, 4, 2};
        // int[] arr = {4, 4, 2, 1, 2, 4, 2};
        int ans = Solution.singleNum(arr);
        System.out.println("The Single element: "+ ans);
    }
}

// TC: O(nlogn) + O(n/3)
// SC: O(1)
// where, n = length of the given array
