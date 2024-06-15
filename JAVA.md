<hr style="border: 10px solid green;">

# Find the Majority Element that occurs more than N/2 times
1. Initialize variables `cnt` and `el` to 0.
2. Iterate through the array:
   - If `cnt` is 0, set `el` to the current element and increment `cnt` to 1.
   - If the current element is equal to `el`, increment `cnt`; otherwise, decrement `cnt`.
3. After the loop, check the frequency of the stored element `el` in the array.
4. If the frequency of `el` is greater than N/2, return `el` as the majority element; otherwise, return -1.

#############################################################################

Kadane's Algorithm : Maximum Subarray Sum in an Array

Problem Statement: Given an integer array arr, find the contiguous subarray (containing at least one number) which
has the largest sum and returns its sum and prints the subarray.

Example 1:
Input: arr = [-2,1,-3,4,-1,2,1,-5,4] 
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6. 
 
1. **Initialization**:
   - Initialize `sum` to 0 (current sum of subarray).
   - Initialize `maxSum` to a very small number or 0 (maximum subarray sum found).
2. **Algorithm**:
   - Iterate through the array:
     - Add the current element to `sum`.
     - Update `maxSum` to be the maximum of `maxSum` and `sum`.
     - If `sum` becomes negative, reset `sum` to 0 (start a new subarray).
3. **Consider Edge Case**:
   - If the array contains all negative numbers, `maxSum` should be 0 (indicating an empty subarray).
4. **Return Result**:
   - After iterating through the array, `maxSum` holds the maximum subarray sum.
   - Return `maxSum` as the result.

#############################################################################

# Stock Buy and Sell

- Problem Statement: You are given an array of prices where prices[i] is the price of a given stock on an ith day.
- You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
- Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Example:
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note: Buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

1. Initialize variables:
	- `maxProfit` to store the maximum profit.
	- `minPrice` to store the minimum price.
2. Iterate through the array using a loop:
	- Update `minPrice` to be the minimum of `minPrice` and `current element`.
		minPrice = Math.min(minPrice, arr[i])
	- Update `maxProfit` to be the maximum of `current element minus minPrice` and `maxProfit`
		maxProfit = Math.max(maxProfit, (arr[i] - minPrice))
3. Return `maxProfit`.

#############################################################################
# `Subarray Sum Equals K`

1. Create a hashmap and insert hm.put(0, 1)
2. Initialize `idx` = 0, `sum` = 0, `cnt` = 0
3. Iterate over the array using a while loop. For each element at index `idx`:
   - Add the current element to the cumulative sum `sum`.
   - Calculate the remaining sum `rem` as `sum - k`.
   - If the hashmap `hm` contains the remaining sum `rem`, increment the count `cnt` by the frequency of `rem` in the hashmap.
   - If the hashmap `hm` contains the current cumulative sum `sum`, increment its frequency by 1. Else, insert the sum with a frequency of 1.
4. After iterating over the entire array, return the count `cnt` of subarrays with a sum equal to `k`.
