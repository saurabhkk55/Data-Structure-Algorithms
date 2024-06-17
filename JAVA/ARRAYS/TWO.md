<hr style="border: 10px solid green;">

# 1. `Find the Missing Number in an Array`

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

# 2. `Count Maximum Consecutive One's in the array`

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

# 3. `Find the number that appears once, and the other numbers twice`

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

# 4. `Stock Buy and Sell`

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

# 5. [`Merge Two Sorted Arrays Without Extra Space`](https://www.naukri.com/code360/problems/merge-two-sorted-arrays-without-extra-space_6898839)

```java
// Input arrays
long[] a = {1, 3, 5, 7};
long[] b = {2, 4, 6};

// OUTPUT
Merged array a: [1, 2, 3, 4]
Merged array b: [5, 6, 7]
```

```java
public static void mergeTwoSortedArraysWithoutExtraSpace(long []a, long []b){
   // Initialize pointers for array a and b
   int i = a.length - 1;  // Pointer for array a, starting from end
   int j = 0;             // Pointer for array b, starting from beginning
   
   // Iterate until all elements of 'a' are checked or all elements of 'b' are checked
   while(i >= 0 && j < b.length ) {
      // If the current element of 'a' is greater than the current element of 'b'
      if(a[i] > b[j]) {
         // Swap elements of a[i] and b[j]
         a[i] = a[i] ^ b[j];
         b[j] = a[i] ^ b[j];
         a[i] = a[i] ^ b[j];
      } else {
         // Since a and b are already sorted individually, no need to check further
         break;
      }
      
      // Move to the next element in 'a' and 'b'
      i--;
      j++;
   }
   
   // Sort arrays 'a' and 'b' individually (only necessary if some elements of b were merged into a)
   Arrays.sort(a);
   Arrays.sort(b);
}

// TC: O(minimum(n,m)) + (nlogn) + (mlogm)
```