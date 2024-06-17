# [`Subarrays with XOR ‘K’`](https://www.naukri.com/code360/problems/subarrays-with-xor-k_6826258)

```java
import java.util.HashMap;

public class Solution {
    public static int subarraysWithSumK(int []a, int b) {
        // Write your code here
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);

        int idx = 0, cnt = 0, total_xor = 0, rem_xor;

        while(idx < a.length) {
            total_xor = total_xor ^ a[idx]; // Calculate cumulative XOR
            rem_xor = total_xor ^ b;        // XOR of the remaining part we need to find to get K

            if(hm.containsKey(rem_xor)) cnt += hm.get(rem_xor); // If the required XOR exists in the map, add its frequency to count
            
            if(hm.containsKey(total_xor)) hm.put(total_xor, (hm.get(total_xor)+1)); // Update the frequency of current XOR in the map
            else hm.put(total_xor, 1);
            
            idx++;
        }
        return cnt;
    }
}

// TC: O(n)
// SC: O(1)
```
