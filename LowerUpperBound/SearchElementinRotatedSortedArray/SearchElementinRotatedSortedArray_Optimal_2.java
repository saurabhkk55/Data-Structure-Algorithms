// Search Element in Rotated Sorted Array that may contains duplicate elements as well 
public class SearchElementinRotatedSortedArray_Optimal_2 {
    static int searchElement (int[] nums, int n, int x) {
        int low = 0, high = n-1;
        
        while (low <= high) {
            int mid = (low+high)/2;
            if (nums[mid] == x) {
                return mid;
            }
            
            if (nums[mid] == nums[low] && nums[mid] == nums[high]) {
                low = low + 1;
                high = high - 1;
                continue;
            }
            
            // Left is sorted
            if (nums[low] <= nums[mid]) {
                if (x >= nums[low] && x <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else { // Right is sorted
                if (x >= nums[mid] && x <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 3, 3, 3, 3};
        int target = 2; // 8;
        int ans = searchElement(arr, arr.length, target);
        System.out.println("Found at: "+ans);
    }
}


// TC: 
// - Average: O(log-base-2 n)
// - Worst: O(n/2)
// SC: O(1)

// Algorithm: Search Element in Rotated Sorted Array that contains only unique elements
// 1. Place the 2 pointers i.e. low and high: Initially, we will place the pointers like this: low will point to the first index, and high will point to the last index.
// 2. Calculate the ‘mid’: Now, inside a loop, we will calculate the value of ‘mid’ using the following formula:
//     mid = (low+high) // 2 ( ‘//’ refers to integer division)
// 3. Check if arr[mid] == target: If it is, return the index mid.
// 4. Check if arr[low] = arr[mid] = arr[high]: If this condition is satisfied, we will just increment the low pointer and decrement the high pointer by one step. We will not perform the later steps until this condition is no longer satisfied. So, we will continue to the next iteration from this step.
// 5. Identify the sorted half, check where the target is located, and then eliminate one half accordingly:
//     5.1 If arr[low] <= arr[mid]: This condition ensures that the left part is sorted.
//         5.1.1 If arr[low] <= target && target <= arr[mid]: It signifies that the target is in this sorted half. So, we will eliminate the right half (high = mid-1).
//         5.1.2 Otherwise, the target does not exist in the sorted half. So, we will eliminate this left half by doing low = mid+1.
// 6. Otherwise, if the right half is sorted:
//     5.1 If arr[mid] <= target && target <= arr[high]: It signifies that the target is in this sorted right half. So, we will eliminate the left half (low = mid+1).
//     5.2 Otherwise, the target does not exist in this sorted half. So, we will eliminate this right half by doing high = mid-1.
// 7. Once, the ‘mid’ points to the target, the index will be returned.
// 8. This process will be inside a loop and the loop will continue until low crosses high. If no index is found, we will return -1.
