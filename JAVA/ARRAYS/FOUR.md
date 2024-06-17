<hr style="border: 10px solid green;">

# 1. `Find the Majority Element that occurs more than N/2 times` : `Boyer Moore’s Voting Algorithm`

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

# 2. `Find the Majority Element that occurs more than N/3 times`

```java
// Input-1
int N = 9;
int[] arr = {3, 3, 4, 2, 4, 4, 2, 4, 4};

// OUTPUT-1
[4]

// Input-1
int N = 6;
int[] arr = {1, 1, 1, 2, 2, 2};

// OUTPUT-1
[1, 2]
```

## `Brute`
```java
public static List<Integer> majorityElement(int[] arr) {
    int n = arr.length;
    int mini_freq = (n / 3) + 1; // Minimum frequency required to be a majority element
    
    List<Integer> result = new ArrayList<>();
    
    // Iterate through the array
    for (int i = 0; i < n; i++) {
        int cnt = 0;
        
        // Check if current element is already in result list to avoid redundant checks
        if (result.isEmpty() || result.get(result.size() - 1) != arr[i]) {
            // Count frequency of arr[i] in the array
            for (int j = 0; j < n; j++) {
                if (arr[i] == arr[j]) {
                    cnt++;
                    if (cnt == mini_freq) {
                        result.add(arr[i]);             // If arr[i] appears more than n/3 times, add it to the result list
                        if(result.size() == 2) break;   // There can only be up to 2 elements more than N/3 times
                        break;                          // Once frequency requirement is met, stop counting for the same element
                    }
                }
            }
        }
    }
    Collections.sort(numbers);  // Optional, use only if sequence of element is asked to be sorted
    return result;              // Return the list of majority elements (elements appearing more than n/3 times)
}
```

## `Better`
```java
public static List<Integer> majorityElement(int[] arr) {
    int n = arr.length;
    int mini_freq = (n / 3) + 1; // Minimum frequency required to be a majority element
    
    List<Integer> result = new ArrayList<>();
    HashMap<Integer, Integer> hm = new HashMap<>();
    
    // Step 1: Iterate through the array
    for (int i = 0; i < n; i++) {
        // Step 2: Update frequency of current element in HashMap
        if(!hm.containsKey(arr[i])) hm.put(arr[i], 1);
        else hm.put(arr[i], (hm.get(arr[i])+1));
        
        // Step 3: Check if current element has reached the required minimum frequency
        if(hm.get(arr[i]) == mini_freq) {
            result.add(arr[i]);
            if(result.size() == 2) break; // There can only be up to 2 elements more than N/3 times
        }
    }
    Collections.sort(numbers);  // Optional, use only if sequence of element is asked to be sorted
    return result;              // Return the list of majority elements (elements appearing more than n/3 times)
}
```

## `Optimal`

```java
public static List<Integer> majorityElement(int[] arr) {
    int n = arr.length;
    int mini_freq = (n / 3) + 1; // Minimum frequency required to be a majority element
    
    int el1 = 0, el2 = 0;   // Variables to store potential candidates for majority elements
    int cnt1 = 0, cnt2 = 0; // Counters for the potential majority elements
    
    List<Integer> result = new ArrayList<>();
    
    // Phase 1: Find potential candidates for majority elements
    for (int i = 0; i < n; i++) {
        if (cnt1 == 0 && arr[i] != el2) {
            el1 = arr[i];
            cnt1 = 1;
        } else if (cnt2 == 0 && arr[i] != el1) {
            el2 = arr[i];
            cnt2 = 1;    
        }
        else if (arr[i] == el1) cnt1++;
        else if (arr[i] == el2) cnt2++;
        else {
            cnt1--;
            cnt2--;
        }
    }
    
    // Phase 2: Manual verification of candidates to confirm they occur more than n/3 times
    cnt1 = 0;
    cnt2 = 0;
    
    for (int num : arr) {
        if (num == el1) cnt1++;
        if (num == el2) cnt2++;
    }
    
    // Add the elements to the result list if they meet the required frequency
    if (cnt1 >= mini_freq) result.add(el1);
    if (cnt2 >= mini_freq) result.add(el2);
    
    return result;
}
```