# Find the Largest element in an array
1. Set max_value to arr[0].
2. For each num in arr:
     a. If num > max_value, set max_value to num.
3. return max_value.

#############################################################################

# Second Smallest Element:
1. Initialize small = INF (or a large value) and second_small = INF.
2. For each num in the array:
     a. If num < small:
           Update second_small = small
           Update small = num
     b. Else if num < second_small and num != small:
           Update second_small = num
3. second_small will hold the second smallest element.

# Second Largest Element:
1. Initialize large = -INF (or a small value) and second_large = -INF.
2. For each num in the array:
     a. If num > large:
           Update second_large = large
           Update large = num
     b. Else if num > second_large and num != large:
           Update second_large = num
3. second_large will hold the second largest element.

#############################################################################

# Check if an Array is Sorted
1. If N <= 1 (where N is the size of the array):
		Return True (an empty or single-element array is considered sorted).
2. For i from 1 to N-1:
     If arr[i-1] > arr[i]:
			Return False (array is not sorted).
3. If the loop completes:
     Return True (array is sorted).

#############################################################################

# Remove duplicates from a sorted array in-place
Given a sorted array containing duplicate elements, remove duplicates in-place (modify the original array) and return the number of unique elements. The first k elements of the array should hold the unique elements after modification.. It does not matter what you leave beyond the first k elements.

1. Initialize i = 0 (pointer for unique elements).
2. For j from 1 to length of the array:
     If arr[i] != arr[j]:
		Increment i by 1 (i++).
		Set arr[i] = arr[j] (store the unique element).
3. Return i+1 (size of the array with unique elements).

#############################################################################

# Left Rotate the Array by One
1. Store x = arr[0] (the first element of the array).
2. For i from 0 to n-2:
		Set arr[i] = arr[i+1].
3. Set arr[n-1] = x (put the stored first element at the end of the array).

#############################################################################

# Rotate array by K elements
Given arr = [1, 2, 3, 4, 5, 6, 7] and k = 2:

Step 1: Adjust k to k = 2 % 7 = 2 (since k is within the array size).
Step 2: Reverse the first k elements ([1, 2] becomes [2, 1]).
Step 3: Reverse the remaining elements ([3, 4, 5, 6, 7] becomes [7, 6, 5, 4, 3]).
Step 4: Reverse the entire array ([2, 1, 7, 6, 5, 4, 3] becomes [3, 4, 5, 6, 7, 1, 2]).

#############################################################################

# Move all Zeros to the end of the array
1. Initialize pointers i = 0 and j = 0.
2. Find the first zero in the array and set j to its index:
	while j < n and a[j] != 0:
		j += 1
3. Iterate through the array with i starting from j+1 (after the first zero):
while i < n:
    if a[i] != 0:
        Swap a[i] with a[j].
        j += 1
    i += 1
4. After the loop, all zeros will be moved to the end of the array.

#############################################################################

# Linear Search in an Array
1. We will traverse the whole array and see if the element is present in the array or not
2. If found we will return the index of the element
3. Otherwise, we will return -1.

#############################################################################

# Union of Two Sorted Arrays
Better: works for both sorted and un-sorted arrays
1. Create a HashSet to store unique elements from both arrays
2. Add all elements from arr1 to the HashSet
3. Add all elements from arr2 to the HashSet
4. Create a arrayList (no need to specify the size as it is dynamic in nature) or create a new array of size (arr1.length + arr2.length)
5. Iterate over Hashset and assign its each elements to either array or arrayList as per question need what they have asked to return.

Optimal: works for only sorted arrays
1. Initialize two pointers, `i` = 0 and `j` = 0, pointing to the 0th index of `arr1` and `arr2` respectively.
2. Create an empty list called `union_List` to store the union (unique elements) of `arr1` and `arr2`.
3.  while (i < arr1.length && j < arr2.length)
		if (arr1[i] <= arr2[j])
			// insert arr1[i] into union_list if it's different from the last element in union_list.
			if (union_List.size() == 0 || union_List.get(union_List.size()-1) != arr1[i]) union_List.add(arr1[i]);
			i++;
		else
			// insert arr2[j] into union_list if it's different from the last element in union_list
			if (union_List.size() == 0 || union_List.get(union_List.size()-1) != arr2[j]) union_List.add(arr2[j]);
			j++;
4.  while (i < arr1.length) // IF any element left in arr1
		if (union_List.get(union_List.size()-1) != arr1[i]) union_List.add(arr1[i]);
		i++;
5.  while (j < arr2.length) // If any elements left in arr2
		if (union_List.get(union_List.size()-1) != arr2[j]) union_List.add(arr2[j]);
		j++;
6.  return union_List; // List contains union of two sorted arrays

#############################################################################

## Algorithm to Find the Missing Number in an Array

Given an integer N and an array of size N-1 containing N-1 numbers between 1 to N. Find the number(between 1 to N), that is not present in the given array.

Example:
Input: N = 5, array[] = {1,2,4,5}
Output: 3
Explanation: In the given array, number 3 is missing. So, 3 is the answer.

Optimal 1:
1. Calculate the sum of the first N natural numbers using the formula: **sum_total = (N * (N + 1)) / 2**.
2. Iterate through the array and calculate the sum of all the elements in the array. Let's call this sum **sum_array**.
3. The missing number can be found by subtracting **sum_array** from **sum_total**.
4. The missing number is the result of **sum_total - sum_array**.

Optimal 2: Better than Optimal 1
1. Assume the given array is: {1, 2, 4, 5} and N = 5.
2. XOR of (1 to 5) i.e. xor1 = (1^2^3^4^5) // use loop as, for (i=1; i<N; i++)
3. XOR of array elements i.e. xor2 = (1^2^4^5) // use loop as, for (i=0; i<N-1; i++), N-1 is the length of the given array
4. XOR of xor1 and xor2 = (1^2^3^4^5) ^ (1^2^4^5)
	= (1^1)^(2^2)^(3)^(4^4)^(5^5)
	= 0^0^3^0^0 = 0^3 = 3.
5. The missing number is 3.

#############################################################################

# Count Maximum Consecutive One's in the array
1. Initialization:
   - Set `count` = 0 (for current consecutive 1's)
   - Set `max_count` = 0 (for maximum consecutive 1's encountered)

2. Iterate through the array:
   - If current element is `1`:
     - Increment `count` by 1
     - Update `max_count` as max(`max_count`, `count`)
   - If current element is `0`:
     - Reset `count` to 0 (consecutive 1's sequence is broken)

3. Result:
   - `max_count` holds the length of the longest sequence of consecutive 1's.
   
#############################################################################

# Find the number that appears once, and the other numbers twice
1. Assume the given array is: [4,1,2,1,2]
2. XOR of all elements = 4^1^2^1^2
	= 4 ^ (1^1) ^ (2^2)
	= 4 ^ 0 ^ 0 = 4^0 = 4
3. Hence, 4 is the single element in the array.

#############################################################################

# `Longest Subarray with given Sum K`

## 1.  `Optimal: if array contains +ve, -ve and zeroes`
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

## 2. `Optimal: if All the elements in the array are positive (including zeroes)`
1. Initialize `left`, `right`, and `maxLen` to 0.
2. Initialize `sum` to 0.
3. Loop through the array using `right` as the index.
   1. Add the value of the current element (`a[right]`) to `sum`.
   2. While `sum` is greater than `k` and `left` is less than or equal to `right`, subtract `a[left]` from `sum` and increment `left`.
   3. If `sum` equals `k`, calculate the length of the current subarray (`right - left + 1`) and update `maxLen` if this length is greater than the current `maxLen`.
4. Increment `right` and repeat the process until the end of the array.
5. Return `maxLen`, which holds the length of the longest subarray with sum equal to `k`.

#############################################################################

# Two Sum : Check if a pair with given sum exists in Array

Example 1:
Input Format: N = 5, arr[] = {2,6,5,8,11}, target = 14
Result: YES (for 1st variant)
       [1, 3] (for 2nd variant)
Explanation: arr[1] + arr[3] = 14. So, the answer is “YES” for the first variant and [1, 3] for 2nd variant.

Better: Variant 1: just tell 2sum is possible or not
1. Initialize an empty HashMap named hm to store the elements and their indices.
2. Iterate through the array:
   - For each element `arr[i]`:
     - Calculate the required complement `remaining = target - arr[i]`.
     - Check if the remaining is present in the HashMap.
       - If present, return true
     - Add the current element and its index to the hm HashMap.
3. If no pair is found, return false

Better & Optimal both for Variant 2: Find Indexes of Elements if 2Sum is Possible
1. Initialize an empty HashMap named hm to store the elements and their indices.
2. Initialize an array named ans of size 2 with values [-1, -1] to store the indices of elements if a 2Sum pair is found.
3. Iterate through the array:
   - For each element `arr[i]`:
     - Calculate the required complement `remaining = target - arr[i]`.
     - Check if the remaining is present in the hm HashMap.
       - If present, 
			- ans[0] = i
			- ans[1] = hm.get(remaining) // index of the remaining element
			- return ans
     - Add the current element (`arr[i]`) and its index (`i`) to the hm HashMap.
4. If no pair is found, return ans

Optimal: only possible for Variant 1: just tell 2sum is possible or not
1. Sort the array: Start by sorting the given array.
2. Initialize pointers: Set `left` to the beginning (index 0) and `right` to the end (index n-1) of the sorted array.
3. Search for pair: Use a loop to check the sum of arr[left] and arr[right] while left < right.
   a. If arr[left] + arr[right] == target, return true.
   b. If arr[left] + arr[right] > target, do right--
   c. If arr[left] + arr[right] < target, do left++
4. If the loop ends without finding a pair whose sum equals the target, return false.

#############################################################################

# To sort an array containing only 0s, 1s, and 2s:
1. Initialize three pointers:
   - `low` points to the start of the array (index 0).
   - `mid` starts at the beginning of the array (index 0).
   - `high` points to the end of the array (index n-1).
2. Use a loop with the condition `mid <= high`:
   - Check the value of `arr[mid]`:
     - If `arr[mid]` is 0:
       - Swap `arr[low]` with `arr[mid]`.
       - Increment both `low` and `mid`.     
     - If `arr[mid]` is 1, Just increment `mid`.
     - If `arr[mid]` is 2:
       - Swap `arr[mid]` with `arr[high]`.
       - Decrement `high`.
3. Continue this process until `mid` surpasses `high`.
4. After the loop ends, the array should be sorted into sections of 0s, 1s, and 2s.


#############################################################################

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
