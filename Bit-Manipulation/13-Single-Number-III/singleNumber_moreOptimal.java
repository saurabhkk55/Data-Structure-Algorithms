import java.util.ArrayList;
import java.util.List;

class Solution {
    static List<Integer> singleNumber (int[] arr, int n) {
        List<Integer> ans = new ArrayList<>();
        int x = 0, first_set_bit = -1, ones_bkt = 0, twos_bkt = 0;
        for (int i=0; i<n; i++) {
            x = x ^ arr[i];
        }

        // Approach 3: find first righmost set bit, better than both Approach 1 & 2
        first_set_bit = (x & (-x)); // Here, -x represents the 2's compliment of x
        
        for (int i=0; i<n; i++) {
            if ((arr[i] & first_set_bit) == 0) {
                ones_bkt = ones_bkt ^ arr[i];
            } else {
                twos_bkt = twos_bkt ^ arr[i];
            }
        }
        ans.add(ones_bkt);
        ans.add(twos_bkt);
        return ans;
    }
}

public class singleNumber_moreOptimal {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 7, 7, 3, 5};
        // int[] arr = {9, 1, 1, 2, 2, 7, 7, 5};
        // int[] arr = {1, 1, 2, 11, 2, 7, 7, 5};
        // int[] arr = {1, 1, 2, Integer.MIN_VALUE, 2, 7, 7, Integer.MAX_VALUE};
        List<Integer> ans = Solution.singleNumber(arr, arr.length);
        System.out.println("Single elements are: "+ans);
    }
}

// TC: O(2n)
// SC: O(1)
