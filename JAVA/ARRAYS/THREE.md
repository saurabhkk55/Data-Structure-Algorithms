<hr style="border: 10px solid green;">

# 1. `To sort an array containing only 0s, 1s, and 2s:`

```java
// Input
int[] arr = {0, 1, 2, 0, 1, 2, 1, 0};

// OUTPUT
[0, 0, 0, 1, 1, 1, 2, 2]
```

```java
public static void sortColors(int[] arr) {
        int low = 0;                // Pointer for 0s
        int mid = 0;                // Pointer for current element
        int high = arr.length - 1;  // Pointer for 2s
      
   while (mid <= high) {
      if (arr[mid] == 0) {
            // Swap arr[low] and arr[mid]
            int temp = arr[low];
            arr[low] = arr[mid];
            arr[mid] = temp;
            low++;
            mid++;
      } else if (arr[mid] == 1) {
            mid++;
      } else if (arr[mid] == 2) {
            // Swap arr[mid] and arr[high]
            int temp = arr[mid];
            arr[mid] = arr[high];
            arr[high] = temp;
            high--;
      }
   }
}
```

<hr style="border: 10px solid green;">

# 2. `Kadane's Algorithm` : `Maximum Subarray Sum in an Array`

## `Question 1`: `Find the Maximum Subarray Sum`

```markdown
Given an integer array arr, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
```

```java
// Input
int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

// OUTPUT
The maximum subarray sum is: 6
```

```java
public static int findMaxSubarraySum(int[] arr) {
   // Step 1: Initialization
   int sum = 0;
   int maxSum = 0;
   
   // Step 2: Iterate through the array
   for (int num : arr) {
      sum += num;                     // Add the current element to `sum`
      maxSum = Math.max(maxSum, sum); // Update `maxSum` to be the maximum of `maxSum` and `sum`
      if (sum < 0) sum = 0;           // If `sum` becomes negative, reset `sum` to 0 (start a new subarray)

   // Step 3: Return Result
   return maxSum;
}
```

## `Question 2`: `find the Subarray with the Maximum Sum`

```markdown
Given an integer array arr, find the contiguous subarray (containing at least one number) which has the largest sum
```

```java
// Input
int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

// OUTPUT
The subarray with the largest sum is: 4 -1 2 1 
```

```java
public static int[] findMaxSubarray(int[] arr) {
   // Step 1: Initialization
   int sum = 0;         // Current sum of the subarray
   int maxSum = 0;      // Maximum subarray sum found
   int start = 0;       // Start index of the maximum subarray
   int end = 0;         // End index of the maximum subarray
   int tempStart = 0;   // Temporary start index for the current subarray
   
   // Step 2: Iterate through the array
   for (int i = 0; i < arr.length; i++) {
      sum += arr[i];    // Add the current element to `sum`
      
      if (sum > maxSum) {
            maxSum = sum;        // Update maxSum if current sum is greater
            start = tempStart;   // Update start index of the maximum subarray
            end = i;             // Update end index of the maximum subarray
      }
      
      if (sum < 0) {
            sum = 0;             // Reset current sum to 0
            tempStart = i + 1;   // Update tempStart to the next index
      }
   }
   
   // Return the start and end indices of the maximum subarray
   return new int[]{start, end};
}
```

<hr style="border: 10px solid green;">

# 3. `Longest Subarray with given Sum K`

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

# 4. `Count total number of Subarrays Sum Equals K`

```java
// Input
int[] nums = {1, 1, 1};
int k = 2;

// OUTPUT
2
```

```java
public int subarraySum(int[] nums, int k) {
   // Create a hashmap and insert hm.put(0, 1)
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
```

<hr style="border: 10px solid green;">

# 5. `Count total number of Subarrays Sum Equals K using XOR`

```java
public static int subarraysWithSumK(int []a, int b) {
      // Create a hashmap and insert hm.put(0, 1)
      HashMap<Integer, Integer> hm = new HashMap<>();
      hm.put(0, 1);
      
      int idx = 0, cnt = 0, total_xor = 0, rem_xor;
      
      while(idx < a.length) {
            total_xor = total_xor ^ a[idx]; // Calculate cumulative XOR
            
            rem_xor = total_xor ^ b;        // XOR of the remaining part we need to find to get K
            if(hm.containsKey(rem_xor)) cnt += hm.get(rem_xor); 
            
            if(hm.containsKey(total_xor)) hm.put(total_xor, (hm.get(total_xor)+1));
            else hm.put(total_xor, 1);
            
            idx++;
      }
      return cnt;
}
// TC: O(n)
// SC: O(1)
```

<hr style="border: 10px solid green;">
