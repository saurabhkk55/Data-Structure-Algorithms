# [`Longest Subarray With Sum K for +ve, -ve & zeroes`](https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1)

```java
class Solution{
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr (int A[], int N, int K) {
        // Write your code here
        int idx = 0;
        int sum = 0;
        int len, maxLen = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        while(idx < N) {
            sum += A[idx];
            
            if(sum == K) maxLen = idx + 1;
            
            int rem = sum - K;
            
            if(hm.containsKey(rem)) {
                len = idx - hm.get(rem);
                maxLen = Math.max(maxLen, len);
            }
            
            if(!hm.containsKey(sum)) hm.put(sum, idx);
            
            idx++;
        }
        return maxLen;
    }
}
```

# `Algorithm`
1. Initialize `idx`, `sum`, and `maxLen` to 0.
2. Create an empty HashMap `hm` to store cumulative sums and their indices.
3. Loop through the array using `idx` as the index.
   1. Add the value of the current element (`A[idx]`) to `sum`.
   2. If `sum` equals `K`, set `maxLen` to `idx + 1` because the subarray from the start to the current index has a sum of `K`.
   3. Calculate the remaining sum `rem` as `sum - K`.
   4. If `hm` contains the key `rem`, calculate the length of the subarray as `idx - hm.get(rem)` and update `maxLen` if this length is greater than the current `maxLen`.
   5. If `hm` does not contain the key `sum`, store the pair `(sum, idx)` in `hm`.
4. Increment `idx` and repeat the process until the end of the array.
5. Return `maxLen`, which holds the length of the longest subarray with sum equal to `K`.
