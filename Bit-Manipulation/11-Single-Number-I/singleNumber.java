class Solution {
    static int singleNum (int[] arr) {
        int xor = 0;
        
        for (int i=0; i<arr.length; i++) {
            xor = xor ^ arr[i];
        }
        
        return xor;
    }
}

public class singleNumber {
    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 1, 2};
        int ans = Solution.singleNum(arr);
        System.out.println("The Single element: "+ ans);
    }
}

// TC: O(n)
// SC: O(1)
