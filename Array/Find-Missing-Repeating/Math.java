class Solution {
    public int[] missing_repeating(int[] arr) {
        int[] ans = new int[2];
        int i = 0, n = arr.length;
        
        long sum = 0, sum_n;
        long sum_sqr = 0, sum_n_sqr = 0;
        
        for(i=0; i<n; i++) {
            sum += arr[i];
            sum_sqr += (arr[i] * arr[i]);
        }
        
        sum_n = (n*(n+1))/2;
        sum_n_sqr = (n*(n+1)*(2*n+1))/6;
        
        long x_minus_y = sum - sum_n;
        long x_sqr_minus_y_sqr = sum_sqr - sum_n_sqr;
        
        long x_plus_y = x_sqr_minus_y_sqr / x_minus_y;
        
        long x = (x_plus_y + x_minus_y) / 2; // repeating
        long y = x_plus_y - x;  // missing
        
        ans[0] = (int) (x);
        ans[1] = (int) (y);
        return ans;
    }
}

public class Math {
    public static void main(String[] args) {
        int[] arr = {4, 1, 3, 2, 1, 6};
        
        Solution obj = new Solution();
        int[] ans = new int[2];
        ans = obj.missing_repeating(arr);

        System.out.printf("Repeating: %d | Missing: %d", ans[0], ans[1]);
    }
}

// TC: O(n)
// SC: O(1) using array of size 2 which is as good as constant space.

// ## Algorithm Steps

// 1. Initialize `sum`, `sum_sqr`, `sum_n`, and `sum_n_sqr` to 0.
// 2. Traverse the array to compute `sum` and `sum_sqr`.
// 3. Compute `sum_n` as `(n*(n+1))/2`.
// 4. Compute `sum_n_sqr` as `(n*(n+1)*(2*n+1))/6`.
// 5. Compute `x_minus_y` as `sum - sum_n`.
// 6. Compute `x_sqr_minus_y_sqr` as `sum_sqr - sum_n_sqr`.
// 7. Compute `x_plus_y` as `x_sqr_minus_y_sqr / x_minus_y`.
// 8. Compute `x` as `(x_plus_y + x_minus_y) / 2`.
// 9. Compute `y` as `x_plus_y - x`.
// 10. Return `x` (repeating elem) and `y` (missing elem).
