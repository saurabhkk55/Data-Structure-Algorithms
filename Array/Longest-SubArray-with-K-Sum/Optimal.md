# [`Longest Subarray With Sum K for Positives & zeroes`](https://www.naukri.com/code360/problems/longest-subarray-with-sum-k_6682399)

<!-- Optimal solution if All elements in the array are positive -->

```java
public class Solution {
    public static int longestSubarrayWithSumK(int []a, long k) {
        // Write your code here
        int left = 0, right = 0, n = a.length;
        long sum = 0;
        int len, maxLen = 0;

        while(right < n) {
            sum += a[right];
            
            while(left <= right && sum > k) {
                sum -= a[left];
                left++;
            }
            
            if(sum == k) {
                len = right - left + 1;
                maxLen = Math.max(maxLen, len);
            }
            
            right++;
        }
        return maxLen;
    }
}

// TC: O(N)
// SC: O(1)
```
## `Algorithm`

1. Initialize `left`, `right`, and `maxLen` to 0.
2. Initialize `sum` to 0.
3. Loop through the array using `right` as the index.
   1. Add the value of the current element (`a[right]`) to `sum`.
   2. While `sum` is greater than `k` and `left` is less than or equal to `right`, subtract `a[left]` from `sum` and increment `left`.
   3. If `sum` equals `k`, calculate the length of the current subarray (`right - left + 1`) and update `maxLen` if this length is greater than the current `maxLen`.
4. Increment `right` and repeat the process until the end of the array.
5. Return `maxLen`, which holds the length of the longest subarray with sum equal to `k`.
