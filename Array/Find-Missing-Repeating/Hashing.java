class Solution {
    public int[] missing_repeating(int[] arr) {
        int n = arr.length;

        int[] ans = new int[n+1];
        int i = 0;
        
        for(i=0; i<n; i++) {
            ans[arr[i]]++;
        }
        
        int repeating = -1, missing = -1;
        for(i=1; i<=n; i++) {
            if(ans[i] == 2) repeating = i;
            else if(ans[i] == 0) missing = i;
            else if(missing != -1 && repeating != -1) break;
        }
        
        int[] missing_repeat = new int[2];
        missing_repeat[0] = repeating;
        missing_repeat[1] = missing;
        
        return missing_repeat;
    }
}

public class hashing {
    public static void main(String[] args) {
        int[] arr = {4, 1, 3, 2, 1, 6};
        
        Solution obj = new Solution();
        int[] ans = new int[2];
        ans = obj.missing_repeating(arr);
        
        System.out.printf("Repeating: %d | Missing: %d", ans[0], ans[1]);
    }
}

// TC: O(2n)
// SC: O(n) ussing array for hashing

// ## Algorithm Steps

// 1. Initialize an array `ans` of size `n+1` to zero.
// 2. Traverse the input array `arr`:
//    - For each element `arr[i]`, increment `ans[arr[i]]` by 1.
// 3. Initialize `repeating` and `missing` to -1.
// 4. Traverse the `ans` array from 1 to `n`:
//    - If `ans[i]` is 2, set `repeating` to `i`.
//    - If `ans[i]` is 0, set `missing` to `i`.
//    - If both `repeating` and `missing` are found, break the loop.
// 5. Store `repeating` and `missing` in an array `missing_repeat`.
// 6. Return `missing_repeat`.

