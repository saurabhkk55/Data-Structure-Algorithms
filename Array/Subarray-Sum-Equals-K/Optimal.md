# [560](https://leetcode.com/problems/subarray-sum-equals-k/description/) . `Subarray Sum Equals K`

```java
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);

        int idx = 0, sum = 0, cnt = 0;

        while(idx < nums.length) {
            sum += nums[idx];

            int rem = sum - k;
            if(hm.containsKey(rem)) cnt += hm.get(rem);

            if(hm.containsKey(sum)) hm.put(sum, (hm.get(sum) + 1));
            else hm.put(sum, 1);
            
            idx++;
        }
        return cnt;
    }
}
```

## `Algorithm`
1. Create a hashmap and insert hm.put(0, 1)
2. Initialize `idx` = 0, `sum` = 0, `cnt` = 0
3. Iterate over the array using a while loop. For each element at index `idx`:
   - Add the current element to the cumulative sum `sum`.
   - Calculate the remaining sum `rem` as `sum - k`.
   - If the hashmap `hm` contains the remaining sum `rem`, increment the count `cnt` by the frequency of `rem` in the hashmap.
   - If the hashmap `hm` contains the current cumulative sum `sum`, increment its frequency by 1. Else, insert the sum with a frequency of 1.
4. After iterating over the entire array, return the count `cnt` of subarrays with a sum equal to `k`.
