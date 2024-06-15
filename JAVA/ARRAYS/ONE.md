<hr style="border: 10px solid green;">

# 1. `Find the Largest element in an array`

```java
// Input
int[] array = { 12, 35, 1, 10, 34, 1 };
```

```java
int maxValue = array[0];

for (int num : array) {
   if (num > maxValue) maxValue = num;
}

return maxValue;
```

<hr style="border: 10px solid green;">

# 2. `Finding the Second Smallest Element`

```java
// Input
int[] array = { 12, 35, 1, 10, 34, 1 };
```

```java
int smallest = Integer.MAX_VALUE;
int secondSmallest = Integer.MAX_VALUE;

for (int num : array) {
   if (num < smallest) {
         secondSmallest = smallest;
         smallest = num;
   } else if (num < secondSmallest && num != smallest) {
         secondSmallest = num;
   }
}

return secondSmallest;
```

<hr style="border: 10px solid green;">

# 3. `Second Largest Element:`

```java
// Input
int[] array = { 12, 35, 1, 10, 34, 1 };
```

```java
int largest = Integer.MIN_VALUE;
int secondLargest = Integer.MIN_VALUE;

for (int num : array) {
   if (num > largest) {
         secondLargest = largest;
         largest = num;
   } else if (num > secondLargest && num != largest) {
         secondLargest = num;
   }
}

return secondLargest;
```

<hr style="border: 10px solid green;">

# 4. `Check if an Array is Sorted`

```java
// Inputs
int[] arr1 = { 1, 2, 3, 4, 5 };
int[] arr2 = { 7, 2, 8, 5, 3 };
```

```java
public static boolean isSorted(int[] arr) {
   int N = arr.length;
   // If N <= 1, return true (empty or single-element array is considered sorted)
   if (N <= 1) return true;

   for (int i = 1; i < N; i++) {
      if (arr[i - 1] > arr[i]) return false; // array is not sorted
   }

   return true; // array is sorted
}
```

<hr style="border: 10px solid green;">

# 5. `Remove duplicates from a sorted array in-place`

### `Question`
```markdown
- Given a sorted array containing duplicate elements.
- Remove duplicates in-place (modify the original array) and return the number of unique elements.
- The first k elements of the array should hold the unique elements after modification.
- It does not matter what you leave beyond the first k elements.
```
```java
// Inputs
int[] arr1 = { 1, 1, 2, 2, 3, 4, 4, 4, 5 };
int[] arr2 = { 1, 1, 1, 1, 1 };
```

```java
public static int removeDuplicates(int[] arr) {
   int i = 0;

   for (int j = 1; j < arr.length; j++) {
      if (arr[i] != arr[j]) {
            i++;
            arr[i] = arr[j];
      }
   }

   return i + 1; // Return the size of the array with unique elements
}
```

<hr style="border: 10px solid green;">

# 6. `Left Rotate the Array by One`

```java
// Inputs
int[] arr1 = { 1, 2, 3, 4, 5 }; // OUTPUT: [2, 3, 4, 5, 1]
int[] arr2 = { 9, 8, 7, 6 };    // OUTPUT: [8, 7, 6, 9]
```

```java
public static void leftRotateByOne(int[] arr) {
   // Step 1: Store the first element of the array
   int x = arr[0];

   // Step 2: Shift elements to the left by one position
   for (int i = 0; i < arr.length - 1; i++) {
      arr[i] = arr[i + 1];
   }

   // Step 3: Place the stored first element at the end of the array
   arr[arr.length - 1] = x;
}
```

<hr style="border: 10px solid green;">

# 7. `Rotate array by K elements`

```java
// Input
int[] array = { 1, 2, 3, 4, 5, 6, 7 };
int k = 2;

// OUTPUT:
[3, 4, 5, 6, 7, 1, 2]
```


```markdown
# Step 1: Adjust k to k = 2 % 7 = 2 (since k is within the array size).
# Step 2: Reverse the first k elements ([1, 2] becomes [2, 1]).
# Step 3: Reverse the remaining elements ([3, 4, 5, 6, 7] becomes [7, 6, 5, 4, 3]).
# Step 4: Reverse the entire array ([2, 1, 7, 6, 5, 4, 3] becomes [3, 4, 5, 6, 7, 1, 2]).
```

<hr style="border: 10px solid green;">

# 8. `Move all Zeros to the end of the array`
```java
// Inputs
int[] arr1 = { 0, 1, 0, 3, 12 };       // OUTPUT: [1, 3, 12, 0, 0]
int[] arr2 = { 1, 0, 0, 2, 0, 5, 9 };  // OUTPUT: [1, 2, 5, 9, 0, 0, 0]
int[] arr2 = { 0, 0, 0, 2, 9 };        // OUTPUT: [2, 9, 0, 0, 0]
```

```java
public void pushZerosToEnd(int[] arr, int n) {
   int i = 0; // index i points to a zero element always
   
   // Find the first zero element in the array
   while(i < n && arr[i] != 0) {
      i++;
   }
   
   // Start looking for the non-zero element after the first occurrence of zero element
   int j = i + 1;
   
   while(j < n) {
      // swap non-zero arr[j] with zero arr[i]
      if(arr[j] != 0) {
            arr[i] = arr[i] ^ arr[j];
            arr[j] = arr[i] ^ arr[j];
            arr[i] = arr[i] ^ arr[j];
            i++;
      }
      j++;
   }
   // After the loop, all zeros will be moved to the end of the array.
}
```

<hr style="border: 10px solid green;">

# 9. `Linear Search in an Array`

```java
// Input
int[] arr = { 10, 25, 6, 48, 15, 3 };
int target1 = 15;

// OUTPUT: 4
```

```java
public static int linearSearch(int[] arr, int target) {
   // Traverse the array to find the target element
   for (int i = 0; i < arr.length; i++) {
      if (arr[i] == target) return i; // Return the index if element is found
   }
   return -1; // Return -1 if element is not found
}
```

<hr style="border: 10px solid green;">

# 10. `Union of Two Sorted Arrays`

## `BETTER: Works for both sorted and un-sorted arrays`
```java
// Input
      int[] arr1 = { 1, 2, 3, 4, 5 };
      int[] arr2 = { 3, 4, 5, 6, 7 };

// OUTPUT: 4
[1, 2, 3, 4, 5, 6, 7]
```

```java
public static int[] findUnion(int[] arr1, int[] arr2) {
   // Step 1: Use HashSet to store unique elements
   Set<Integer> set = new HashSet<>();

   // Step 2: Add all elements from arr1 to the HashSet
   for (int num : arr1) {
      set.add(num);
   }

   // Step 3: Add all elements from arr2 to the HashSet
   for (int num : arr2) {
      set.add(num);
   }

   // Step 4: Create an array to store union elements
   int[] unionArray = new int[set.size()];
   int index = 0;

   // Step 5: Iterate over the HashSet and populate the union array
   for (int num : set) {
      unionArray[index++] = num;
   }

   return unionArray;
}
```

## `OPTIMAL: Works for only sorted arrays`
```java
public static List<Integer> findUnion(int[] arr1, int[] arr2) {
	List<Integer> unionList = new ArrayList<>(); 	// List to store union of elements
	int i = 0, j = 0; 								// Pointers for arr1 and arr2

	// Merge arr1 and arr2 into unionList
	while (i < arr1.length && j < arr2.length) {
		if (arr1[i] < arr2[j]) {
			// Add arr1[i] to unionList if it's different from the last element in unionList
			if (unionList.isEmpty() || unionList.get(unionList.size() - 1) != arr1[i]) {
				unionList.add(arr1[i]);
			}
			i++; // Move to the next element in arr1
		} else if (arr1[i] > arr2[j]) {
			// Add arr2[j] to unionList if it's different from the last element in unionList
			if (unionList.isEmpty() || unionList.get(unionList.size() - 1) != arr2[j]) {
				unionList.add(arr2[j]);
			}
			j++; // Move to the next element in arr2
		} else { // arr1[i] == arr2[j]
			// Add arr1[i] (or arr2[j]) to unionList if it's different from the last element in unionList
			if (unionList.isEmpty() || unionList.get(unionList.size() - 1) != arr1[i]) {
				unionList.add(arr1[i]);
			}
			i++; // Move to the next element in arr1
			j++; // Move to the next element in arr2
		}
	}

	// Add remaining elements of arr1 to unionList
	while (i < arr1.length) {
		if (unionList.isEmpty() || unionList.get(unionList.size() - 1) != arr1[i]) {
			unionList.add(arr1[i]);
		}
		i++; // Move to the next element in arr1
	}

	// Add remaining elements of arr2 to unionList
	while (j < arr2.length) {
		if (unionList.isEmpty() || unionList.get(unionList.size() - 1) != arr2[j]) {
			unionList.add(arr2[j]);
		}
		j++; // Move to the next element in arr2
	}

	return unionList; // Return the List containing union of arr1 and arr2
}
```
<hr style="border: 10px solid green;">
