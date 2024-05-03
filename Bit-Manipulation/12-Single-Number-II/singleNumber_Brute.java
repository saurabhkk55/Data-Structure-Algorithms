import java.util.HashMap;

class Solution {
    // Method to find the single number in an array where every other element appears three times
    static int singleNum (int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i=0; i<arr.length; i++) {
            if (hm.containsKey(arr[i]) == false) {
                hm.put(arr[i], 1);
            } else {
                int val = hm.get(arr[i]) + 1;
                hm.put(arr[i], val);
            }
        }
        // System.out.println(hm); // debugger
        for (Integer hm_key : hm.keySet()) {
            Integer hm_val = hm.get(hm_key);
            if (hm_val == 1) {
                return hm_key;
            }
        }
        return -1; // dummy, bcoz array will always contain an element which occurs only once
    }
}

public class singleNumber_Brute {
    public static void main(String[] args) {
        int[] arr = {4, 4, 2, 9, 2, 4, 2};
        // int[] arr = {2, 2, 2, 5, 5, 5, 9};/
        int ans = Solution.singleNum(arr);
        System.out.println("The Single element: "+ ans);
    }
}

// TC: O(nlogm) + O(m)
// SC: O(m)
// where: m = (n/3)+1
// n = length of the given array
