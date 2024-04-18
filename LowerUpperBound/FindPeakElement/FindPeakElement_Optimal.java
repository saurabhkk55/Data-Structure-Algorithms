class Solution {
    static int findPeak (int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        else if (nums[0] > nums[1]) return 0;
        else if (nums[n-1] > nums[n-2]) return (n-1);
        else {
            int low = 1, high = n-2;
            
            while (low <= high) {
                int mid = (low+high)/2;
                
                if ((nums[mid] > nums[mid+1]) && (nums[mid] > nums[mid-1])) {
                    return mid;
                }
                
                if (nums[mid] < nums[mid+1]) 
                {
                    low = mid + 1;
                }
                // else if (nums[mid] > nums[mid-1]) 
                // {
                //     high = mid - 1;
                // } 
                // else 
                // {
                //     high = mid - 1; // do either of low = mid + 1 or high = mid - 1
                // }
                
                // These above 2 condition can be re-written together like this:
                else
                {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
public class FindPeakElement_Optimal {
    public static void main(String[] args) {
        // int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 1, 5};
        // int[] arr = {1, 2, 1, 3, 5, 6, 4};
        int[] arr = {1, 2, 3, 4, 5};
        int ans = Solution.findPeak(arr);
        System.out.println("Peak element found at index: "+ans);
    }
}

// Problem statement
// You are given an array 'arr' of length 'n'. Find the index(0-based) of a peak element in the array. If there are multiple peak numbers, return the index of any peak number.
// ---
// Peak element is defined as that element that is greater than both of its neighbors. If 'arr[i]' is the peak element, 'arr[i - 1]' < 'arr[i]' and 'arr[i + 1]' < 'arr[i]'.
// ---
// Assume 'arr[-1]' and 'arr[n]' as negative infinity.
// ---
// Note:
// 1.  There are no 2 adjacent elements having same value (as mentioned in the constraints).
// 2.  Do not print anything, just return the index of the peak element (0 - indexed).
// 3. 'True'/'False' will be printed depending on whether your answer is correct or not.
// ---
// Example:
// Input: 'arr' = [1, 8, 1, 5, 3]
// Output: 3
// Explanation: There are two possible answers. Both 8 and 5 are peak elements, so the correct answers are their positions, 1 and 3.

// Time Complexity: O(logbase2 N), N = size of the given array.
// Reason: We are basically using binary search to find the peak.
// Space Complexity: O(1)
// Reason: We have not used any extra data structures, this makes space complexity, even in the worst case as O(1).

// Algorithm:
// 1. If n == 1: This means the array size is 1. If the array contains only one element, we will return that index i.e. 0.
// 2. If arr[0] > arr[1]: This means the very first element of the array is the peak element. So, we will return the index 0.
// 3. If arr[n-1] > arr[n-2]: This means the last element of the array is the peak element. So, we will return the index n-1.
// 4. Place the 2 pointers i.e. low and high: Initially, we will place the pointers excluding index 0 and n-1 like this: low will point to index 1, and high will point to index n-2 i.e. the second last index.
// 5. Calculate the ‘mid’: Now, inside a loop, we will calculate the value of ‘mid’ using the following formula:
//      mid = (low+high) / 2
// 6. Check if arr[mid] is the peak element:
// 7. If arr[mid] > arr[mid-1] and arr[mid] > arr[mid+1]: If this condition is true for arr[mid], we can conclude arr[mid] is the peak element. We will return the index ‘mid’.
// 8. If arr[mid] > arr[mid-1]: This means we are in the left half and we should eliminate it as our peak element appears on the right. So, we will do this:
//      low = mid+1.
// 9. Otherwise, we are in the right half and we should eliminate it as our peak element appears on the left. So, we will do this: high = mid-1. This case also handles the case for the index ‘mid’ being a common point of a decreasing and increasing sequence. It will consider the left peak and eliminate the right peak.
