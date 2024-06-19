<hr style="border: 10px solid green;">

# `Count Inversion`

```java
// Input
int[] arr = {1, 20, 6, 4, 5};

// OUTPUT
Number of inversions: 5
```

```java
import java.util.*;

class Solution {
    
    // Function to merge two sorted halves and count inversions
    static int merge(int[] arr, int low, int mid, int high) {
        // Temporary list to store merged result
        List<Integer> temp = new ArrayList<>();
        int left = low, right = mid + 1;
        int count = 0; // Count of inversions
        
        // Merge elements from both halves into temp list
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
                // If arr[left] > arr[right], then all elements from left to mid are greater than arr[right]
                // Hence, count inversions
                count += (mid - left + 1);
            }
        }
        
        // Add remaining elements from left half
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        
        // Add remaining elements from right half
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }
        
        // Copy merged elements from temp list back to original array
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
        
        return count;
    }
    
    // Function to recursively divide and merge while counting inversions
    static int merge_sort(int[] arr, int low, int high) {
        if (low >= high) return 0; // Base case: if single element or empty array, no inversion
        
        int mid = (low + high) / 2;
        int count = 0;
        
        // Recursively count inversions in left and right halves
        count += merge_sort(arr, low, mid);
        count += merge_sort(arr, mid + 1, high);
        
        // Merge two halves and count inversions
        count += merge(arr, low, mid, high);
        
        return count;
    }
    
    // Function to count inversions in an array
    static int countInversion(int[] nums) {
        int low = 0, high = nums.length - 1;
        return merge_sort(nums, low, high);
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 20, 6, 4, 5};
        int inversionCount = countInversion(arr);
        
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Number of inversions: " + inversionCount);
    }
}
```

<hr style="border: 10px solid green;">
