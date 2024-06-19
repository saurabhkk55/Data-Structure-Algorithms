
```java
// Input
long[] arr = {40, 25, 19, 12, 9, 6, 2};

// OUTPUT
15
```

## Brute
```java
class Solution {
    static long reversePairs (long[] nums) {
        int n = nums.length;
        long count = 0;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                if (nums[i] > 2*nums[j]) count++;
            }
        }
        return count;
    }
}
class ReversePairs_Brute {
    public static void main(String[] args) {
        long[] arr = {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647}; // {40, 25, 19, 12, 9, 6, 2}; // {40, 25, 19, 12, 9, 6, 2}; // {4, 1, 2, 3, 1};
        long ans = Solution.reversePairs(arr);
        System.out.println("Reversed pair counts: "+ans);
    }
}
```

## Optimal
```java
class Solution {
    // Merge two sorted halves of the array
    static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();  // Temporary list to store merged result
        int left = low, right = mid + 1;  // Pointers for left and right halves
        
        // Merge elements into temp list in sorted order
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);  // Add smaller element from left half
                left++;
            } else {
                temp.add(arr[right]);  // Add smaller element from right half
                right++;
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
        
        // Copy sorted elements from temp list back to original array
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }
    
    // Count pairs where a[i] > 2 * a[j] in the merged array segments
    static int countPairs(int[] a, int low, int mid, int high) {
        int left = low, right = mid + 1;
        int count = 0;
        
        // Iterate through left half and count valid pairs in the right half
        while (left <= mid && right <= high) {
            if ((long) a[left] > 2 * (long) a[right]) {
                count += (mid - left + 1);  // Increment count by number of valid pairs found
                right++;
            } else {
                left++;
            }
        }
        return count;
    }
    
    // Modified merge sort to count reverse pairs
    static int ms(int[] a, int low, int high) {
        int count = 0;  // Initialize count of reverse pairs
        
        if (low >= high) return count;  // Base case: if array has 0 or 1 element
        
        int mid = (low + high) / 2;  // Calculate middle index
        
        // Recursively sort and count in left and right halves
        count += ms(a, low, mid);
        count += ms(a, mid + 1, high);
        
        // Count reverse pairs across the two halves and merge them
        count += countPairs(a, low, mid, high);
        merge(a, low, mid, high);
        
        return count;
    }
    
    // Function to find total number of reverse pairs in the array
    public int reversePairs(int[] nums) {
        int low = 0, high = nums.length - 1;  // Initial indices of the array
        return ms(nums, low, high);  // Call merge sort function with counting
    }
}
```
