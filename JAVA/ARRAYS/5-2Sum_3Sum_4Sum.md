# 5. `2 Sum : Check if a pair with given sum exists in Array`

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

# `3 Sum`

```java
// Input
int[] nums = {-1, 0, 1, 2, -1, -4};
int target = 0;

// OUTPUT
Triplets that sum up to zero:
[-1, -1, 2]
[-1, 0, 1]
```

```java
public List<List<Integer>> threeSum(int[] nums, int target) {
	Arrays.sort(nums);  // Sort the array to allow for efficient two-pointer search
	
	int left = 0, middle = left+1, right = nums.length-1;
	List<List<Integer>> ans_list = new ArrayList<>();

	while(left < nums.length){
        // Skip duplicates
		while((left != 0) && (left < nums.length) && (nums[left] == nums[left-1])) {
			left++;
		}
		middle = left + 1;
		right = nums.length-1;
		while(middle < right) {
			int three_sum = nums[left] + nums[middle] + nums[right];
            
			if(three_sum == target) {
				List<Integer> temp_list = new ArrayList<>();
				temp_list.add(nums[left]);
				temp_list.add(nums[middle]);
				temp_list.add(nums[right]);
				ans_list.add(temp_list);
                
				middle++;
				right--;
                
                // Skip duplicates
				while((middle < nums.length) && (nums[middle] == nums[middle-1])) {
					middle++;
				}
                // Skip duplicates
				while((right > 0) && (nums[right] == nums[right+1])) {
					right--;
				}
			} 
            else if (three_sum < target) middle++;
			else right--;
		}
		left++;
	}
	return ans_list;
}
```

<hr style="border: 10px solid green;">

# `4 sum`

```java

```

```java

```
