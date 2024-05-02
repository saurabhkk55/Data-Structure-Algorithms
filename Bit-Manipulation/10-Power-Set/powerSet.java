import java.util.ArrayList;
import java.util.List;

class Solution {
    static List<List<Integer>> subSet(int[] arr, int n) {
        // Calculate the total number of subsets
        int num_of_subset = 1 << n; // same as 2 to the power of n
        
        List<List<Integer>> result = new ArrayList<>(); // List to store all subsets
        
        // Iterate over all numbers from 0 to (num_of_subset - 1)
        for (int i = 0; i < num_of_subset; i++) {
            List<Integer> temp = new ArrayList<>(); // List to store elements of current subset
            
            // Iterate over each bit of the current number (i)
            for (int j = 0; j < n; j++) {
                // Check if the j-th bit of i is set (1)
                // If bit is set, include corresponding element from array in subset
                if ((i & (1 << j)) != 0) {
                    temp.add(arr[j]);
                }
            }
            result.add(temp); // Add the current subset to the result list
        }
        
        return result; // Return the list of all subsets
    }
}

// Main class to test the subset generation method
public class powerSet {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3}; // Input array
        
        List<List<Integer>> subsets = new ArrayList<>(); // List to store subsets
        subsets = Solution.subSet(arr, arr.length); // Generate all subsets
        
        System.out.println("All subsets of " + java.util.Arrays.toString(arr)+ " are: "+ subsets);
    }
}

// Given, arr = {1, 2, 3}
// Length of arr = 3

// Formula: Num of subsets = 2 to the power of n,
// Here n is is the length of arr.

// So, total of subset this arr array can have = 2 to the power of (length of arr) = 8

// | Decimal Number | Binary | Set-bit indexes    | Sub-Array              | Re-write sub-array |
// |----------------|--------|--------------------|------------------------|--------------------|
// | 0              | 0 0 0  | N/A                | []                     | []                 |
// | 1              | 0 0 1  | 0th bit            | arr[0]                 | 1                  |
// | 2              | 0 1 0  | 1st bit            | arr[1]                 | 2                  |
// | 3              | 0 1 1  | 0th & 1st bit      | arr[0], arr[1]         | 1, 2               |
// | 4              | 1 0 0  | 2nd bit            | arr[2]                 | 3                  |
// | 5              | 1 0 1  | 0th & 2nd bit      | arr[0], arr[2]         | 1, 3               |
// | 6              | 1 1 0  | 1st & 2nd bit      | arr[1], arr[2]         | 2, 3               |
// | 7              | 1 1 1  | 0th, 1st & 2nd bit | arr[0], arr[1], arr[2] | 1, 2, 3            |
