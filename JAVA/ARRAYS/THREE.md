<hr style="border: 10px solid green;">

# 16. `To sort an array containing only 0s, 1s, and 2s:`

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

# 17. `Find the Majority Element that occurs more than N/2 times`

```java
// Input
int[] nums = {2, 2, 1, 1, 1, 2, 2}; // OUTPUT: 2
```

```java
public static int findMajorityElement(int[] nums) {
   // Step 1: Initialize the count and potential majority element
   int cnt = 0;
   int el = 0;
   
   // Step 2: Find the potential majority element using Boyer-Moore Voting Algorithm
   for (int num : nums) {
      if (cnt == 0) {
            // If count is 0, set the current element as the candidate and reset the count
            el = num;
            cnt = 1;
      } else if (num == el) {
            // If the current element is the candidate, increment the count
            cnt++;
      } else {
            // If the current element is different, decrement the count
            cnt--;
      }
   }
   
   // Step 3: Verify if the candidate is actually the majority element
   cnt = 0;  // Reset count to zero for the verification step
   for (int num : nums) {
      if (num == el) cnt++;  // Count the occurrences of the candidate in the array
   }
   
   // Step 4: Check if the candidate occurs more than N/2 times
   if (cnt > nums.length / 2) return el;  // If true, return the candidate as the majority element
   else return -1;                        // If false, return -1 indicating no majority element exists
}
```

<hr style="border: 10px solid green;">

# 18. `Kadane's Algorithm` : `Maximum Subarray Sum in an Array`

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

# 19. `Stock Buy and Sell`

## `Question`

```markdown
- You are given an array of prices where prices[i] is the price of a given stock on an ith day.
- You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
- Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
```

```java
// Input
int[] prices = {7, 1, 5, 3, 6, 4};

// OUTPUT
5

// Explanation
Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.

// Note: Buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
```

```java
public static int maxProfit(int[] prices) {
   // Initializing variables
   int currentProfit, maxProfit = 0;
   int minBuyPrice = prices[0];
   
   // Iterate through the array
   for (int i = 0; i < prices.length; i++) {
      int currentSellPrice = prices[i];
      
      currentProfit = currentSellPrice - minBuyPrice; // Calculate the current profit if sold at currentSellPrice
      maxProfit = Math.max(maxProfit, currentProfit); // Update maxProfit if currentProfit is higher
      minBuyPrice = Math.min(currentSellPrice, minBuyPrice); // Update minBuyPrice to be the minimum of minBuyPrice and currentSellPrice
   }
   return maxProfit; // Return the maximum profit found
}
```

<hr style="border: 10px solid green;">

# 20. `Count total number of Subarrays Sum Equals K`

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
      else hm.put(sum, 1); . Else, insert the sum with a frequency of 1.
      
      idx++;
   }
   return cnt;
}
```

<hr style="border: 10px solid green;">
