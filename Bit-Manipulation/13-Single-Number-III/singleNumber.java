import java.util.ArrayList;
import java.util.List;

class Solution {
    static List<Integer> singleNumber (int[] arr, int n) {
        int x = 0;                       // Variable to store XOR of all elements
        int first_set_bit = -1;          // Position of the rightmost set bit
        int ones_bkt = 0, twos_bkt = 0;  // Variables to store the two non-repeating numbers
        
        // Calculate XOR of all array elements
        for (int i=0; i<n; i++) {
            x = x ^ arr[i];
        }
        
        // Approach 1: Find the position of the rightmost set bit in XOR result
        // for (int i=0; i<=31; i++) {
        //     if ((x & (1 << i)) != 0) {
        //         first_set_bit = i;
        //         break;
        //     }
        // }
        
        // Approach 2: Find the position of the rightmost set bit in XOR result, better than Approach 1
        // We are using a more efficient method than iterating through all bit positions
        while (x >= 1) {
            int rem = x % 2;
            first_set_bit++;
            if (rem == 1) break;
            x = x / 2;
        }
        
        // Divide elements into two buckets based on the rightmost set bit
        for (int i=0; i<n; i++) {
            if ((arr[i] & (1 << first_set_bit)) == 0) {
                // Elements with the bit at first_set_bit position as 0
                ones_bkt = ones_bkt ^ arr[i];
            } else {
                // Elements with the bit at first_set_bit position as 1
                twos_bkt = twos_bkt ^ arr[i];
            }
        }
        
        // Add the two non-repeating numbers to the list
        List<Integer> ans = new ArrayList<>();
        ans.add(ones_bkt);
        ans.add(twos_bkt);
        
        return ans;
    }
}

public class singleNumber {
    public static void main(String[] args) {
        // int[] arr = {1, 1, 2, 2, 7, 7, 3, 5};
        // int[] arr = {9, 1, 1, 2, 2, 7, 7, 5};
        // int[] arr = {1, 1, 2, 11, 2, 7, 7, 5};
        int[] arr = {1, 1, 2, Integer.MIN_VALUE, 2, 7, 7, Integer.MAX_VALUE};
        List<Integer> ans = Solution.singleNumber(arr, arr.length);
        System.out.println("Single elements are: "+ans);
    }
}

// TC: O(n) + O(logbase2 of x) + O(n) = O(2n) + O(logbase2 of x)
// SC: O(1)
