import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    static void merge (List<Integer> arr, int low, int mid, int high) {
        int left = low, right = mid+1;
        List<Integer> temp = new ArrayList<>();
        
        while (left <= mid && right <= high) {
            if (arr.get(left) <= arr.get(right)){
                temp.add(arr.get(left));
                left++;
            } else {
                temp.add(arr.get(right));
                right++;
            }
        }
        
        while (left <= mid) {
            temp.add(arr.get(left));
            left++;
        }
        
        while (right <= high) {
            temp.add(arr.get(right));
            right++;
        }
        
        for (int i=low; i<=high; i++) {
            arr.set(i, temp.get(i-low));
        }
    }

    static List<Integer> initiate_merge_sort (List<Integer> arr, int low, int high) {
        if (low == high) return Arrays.asList();
        int mid = (low+high)/2;
        initiate_merge_sort(arr, low, mid);     // The call will sort the left subarray
        initiate_merge_sort(arr, mid+1, high);  // The call will sort the right subarray
        merge(arr, low, mid, high);             // Merge the two sorted halves into a single sorted subarray
        return arr;
    }

    static List<Integer> mergeSort(List<Integer> nums) {
        int low = 0, high = nums.size()-1;
        initiate_merge_sort(nums, low, high);
        return nums;
    }
}

class MergeSort {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        // arr = Arrays.asList(3, 2, 4, 1, 5);
        // arr = Arrays.asList(4, 6, 2, 5, 7, 9, 1, 3);
        // arr = Arrays.asList(1, 3, 2);
        // arr = Arrays.asList(1, 2, 3, 4, 5, 6);
        // arr = Arrays.asList(14, 9, 15, 12, 6, 8, 13);
        // arr = Arrays.asList(14, 9, 15, 12, 6, 9, 13);
        // arr = Arrays.asList(14);
        List<Integer> ans = Solution.mergeSort(arr);
        System.out.println("Sorted array via MergeSort:\n"+ ans);
    }
}

/*
TC:
- Best Case Time Complexity: O(n log n)
- Worst Case Time Complexity: O(n log n)
- Average Case Time Complexity: O(n log n)
SC: O(n)

Algorithm:
- Divide: The array is divided into two halves recursively until each sub-array contains only one element.
- Conquer: After the division, the sub-arrays are merged back together in a sorted manner.
- Merge: During the merging process, elements from the two sub-arrays are compared and placed in the correct order.
*/
