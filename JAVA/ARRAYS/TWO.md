<hr style="border: 10px solid green;">

# 11. `Find the Missing Number in an Array`

## `Question`

```markdown
- Given an integer N and an array of size N-1 containing N-1 numbers between 1 to N.
- Find the number (between 1 to N), that is not present in the given array.
```

```java
// Input
int N = 5;
int[] array = {1, 2, 4, 5};

// Output
3
```

## `Optimal-1`
```java
public static int findMissingNumber(int N, int[] array) {
   // Calculate the sum of first N natural numbers
   int sumTotal = (N * (N + 1)) / 2;

   // Calculate the sum of elements in the array
   int sumArray = 0;
   for (int num : array) {
      sumArray += num;
   }

   // The missing number is the difference between sumTotal and sumArray
   return sumTotal - sumArray;
}
```

## `Optimal-2: Better than Optimal 1`
```java
public static int findMissingNumber(int N, int[] array) {
   int xor1 = 0; // XOR of numbers from 1 to N
   int xor2 = 0; // XOR of elements in the array

   // Calculate xor1 = XOR of numbers from 1 to N
   for (int i = 1; i <= N; i++) {
      xor1 ^= i;
   }
   // xor1 = (1^2^3^4^5)

   // Calculate xor2 = XOR of elements in the array
   for (int num : array) {
      xor2 ^= num;
   }
   // xor2 = (1^2^4^5)

   // XOR of xor1 and xor2 gives the missing number
   return xor1 ^ xor2;
}
```
<hr style="border: 10px solid green;">

# 12. `Count Maximum Consecutive One's in the array`

```java
// Input
int[] nums = {1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1};    // OUTPUT: 4
```

```java
public static int findMaxConsecutiveOnes(int[] nums) {
   int maxCount = 0;
   int count = 0;

   for (int num : nums) {
      if (num == 1) {
            count++;
            maxCount = Math.max(maxCount, count);
      } else {
            count = 0;
      }
   }

   return maxCount;
}
```
   
<hr style="border: 10px solid green;">

# 13. `Find the number that appears once, and the other numbers twice`

```java
// Input
int[] nums = {4, 1, 2, 1, 2};    // OUTPUT: 4
```

```java
public static int findSingleNumber(int[] nums) {
   int singleNumber = 0;

   for (int num : nums) {
      singleNumber ^= num;
   }

   return singleNumber;
}
```

### `Explanation`

```markdown
XOR of all elements = 4^1^2^1^2 = 4 ^ (1^1) ^ (2^2) = 4 ^ 0 ^ 0 = 4^0 = 4
Hence, 4 is the single element in the array.
```

<hr style="border: 10px solid green;">

# 14. `Longest Subarray with given Sum K`

```java
// Input
int[] A = {10, 2, -2, -20, 10};
int N = A.length;
int K = -10;

// OUTPUT
4
```

## `Optimal: if array contains +ve, -ve and zeroes`

```java
public static int lenOfLongSubarr (int A[], int N, int K) {
   // Initialize variables
   int idx = 0;          // Index to iterate through the array
   int sum = 0;          // To store the cumulative sum
   int maxLen = 0;       // To store the maximum length of subarray with sum K
   HashMap<Integer, Integer> hm = new HashMap<>();  // HashMap to store cumulative sums and their indices
   
   // Iterate through the array
   while(idx < N) {
      sum += A[idx]; // Update cumulative sum
      
      // If the cumulative sum equals K, update maxLen
      if(sum == K) maxLen = idx + 1;
      
      // Calculate the remaining sum needed to form sum K
      int rem = sum - K;
      
      // If the remaining sum exists in the HashMap, update maxLen
      if(hm.containsKey(rem)) {
            len = idx - hm.get(rem);         // Calculate the length of the subarray
            maxLen = Math.max(maxLen, len);  // Update maxLen if the current subarray is longer
      }
      
      // Store the cumulative sum and its index in the HashMap if not already present
      if(!hm.containsKey(sum)) hm.put(sum, idx);
      
      idx++;   // Move to the next index
   }

   return maxLen; // Return the maximum length of the subarray with sum K
}
```

## `Optimal: if All the elements in the array are positive (including zeroes)`

```java
public static int findLongestSubarrayWithSumK(int[] arr, int K) {
   int left = 0, right = 0, sum = 0, maxLen = 0;

   // Iterate through the array using 'right' as the index
   while (right < arr.length) {
      // Add the value of the current element to 'sum'
      sum += arr[right];

      // While 'sum' is greater than 'K' and 'left' is less than or equal to 'right'
      while (sum > K && left <= right) {
            sum -= arr[left]; // Subtract the value at 'left' from 'sum'
            left++;           // Increment 'left'
      }

      // If 'sum' equals 'K', update 'maxLen' if the current subarray is longer
      if (sum == K) {
            maxLen = Math.max(maxLen, right - left + 1);
      }

      // Increment 'right' to process the next element
      right++;
   }

   // Return the maximum length of subarray with sum 'K'
   return maxLen;
}
```

<hr style="border: 10px solid green;">

# 15. `Two Sum : Check if a pair with given sum exists in Array`

- ### `Variant 1`: `Just check 2sum is possible or not`
- ### `Variant 2`: `If 2sum pair is possible, return the indices of the pair`


```java
// Input
int[] arr = {2, 7, 11, 15};
int target = 9;

// OUTPUT
true

// Explanation
arr[0] + arr[1] = 9. 
So, the answer is true for the first variant,
and indexes [1, 3] for 2nd variant.
```

**`NOTE`**: 
- Variant - 1: This java code is `BETTER` if we just have to check 2 sum pair is exist or not.
- Variant - 2: However, this same java code becomes `OPTTIMAL` if we have to find indexes of the pair if exist
```java
public static boolean isTwoSumPossible(int[] arr, int target) {
   // Initialize an empty HashMap to store elements and their indices
   HashMap<Integer, Integer> hm = new HashMap<>();
   
   // Iterate through the array
   for (int i = 0; i < arr.length; i++) {
      // Calculate the required complement
      int remaining = target - arr[i];
      
      // Check if the remaining is present in the HashMap
      if (hm.containsKey(remaining)) {
         // VARIANT - 1
         return true;   // If present, return true
         
         // VARIANT - 2
         // return new int[]{hm.get(remaining), i};   // If present, return the indices of the pair
      }
      
      // Add the current element and its index to the HashMap
      hm.put(arr[i], i);
   }
   
   // VARIANT - 1
   return false;  // If no pair is found, return false
   
   // VARIANT - 2
   // return null; // If no pair is found, return null
}
```

## `Optimal Solution for Variant - 1`

```java
public static boolean isTwoSumPossible(int[] arr, int target) {
   Arrays.sort(arr); // Sort the array
   
   // Initialize pointers
   int left = 0;
   int right = arr.length - 1;
   
   // Search for the pair
   while (left < right) {
      int sum = arr[left] + arr[right];
      
      // If the sum matches the target, return true
      if (sum == target) return true;
      
      if (sum > target) right--; // If the sum is greater than the target, move the right pointer to the left
      else left++;               // If the sum is less than the target, move the left pointer to the right
   }

   // If no pair is found, return false
   return false;
}
```

<hr style="border: 10px solid green;">
