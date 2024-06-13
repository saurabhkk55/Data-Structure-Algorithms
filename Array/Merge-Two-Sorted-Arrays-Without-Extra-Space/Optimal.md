# [Merge Two Sorted Arrays Without Extra Space](https://www.naukri.com/code360/problems/merge-two-sorted-arrays-without-extra-space_6898839)

```java
public class Solution {
    public static void mergeTwoSortedArraysWithoutExtraSpace(long []a, long []b){
        // Write your code here.
        int i = a.length - 1, j = 0;
        
        while(i >= 0 && j < b.length ) {
            if(a[i] > b[j]) {
                a[i] = a[i] ^ b[j];
                b[j] = a[i] ^ b[j];
                a[i] = a[i] ^ b[j];
            } else {
                // arraya are sorted no need to check further
                break;
            }
            i--;
            j++;
        }
        Arrays.sort(a);
        Arrays.sort(b);
    }
}

// TC: O(minimum(n,m)) + (nlogn) + (mlogm)
```

## `Alogorithm`
1. **Initialize Pointers**:
   - Set `i` to the last index of array `a` (`a.length - 1`).
   - Set `j` to the first index of array `b` (`0`).

2. **Swap Elements Using XOR (or use 3rd variable) Swap**:
   - While `i >= 0` and `j < b.length`:
     - If `a[i] > b[j]`:
       - Swap `a[i]` and `b[j]` using XOR operations:
         ```java
         a[i] = a[i] ^ b[j];
         b[j] = a[i] ^ b[j];
         a[i] = a[i] ^ b[j];
         ```
     - Else:
       - `break` no need to check further as both arrays are sorted
     - Decrement `i` by 1.
     - Increment `j` by 1.

3. **Sort Arrays**:
   - Use `Arrays.sort(a)` to sort array `a`.
   - Use `Arrays.sort(b)` to sort array `b`.
