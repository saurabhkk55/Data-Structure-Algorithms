import java.util.Arrays;

class Solution {
    static void swapTwo(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    static int partition(int[] arr, int low, int high) {
        int pivot = low;
        int i = low, j = high;
        
        while (i < j) {
            while (arr[i] <= arr[pivot] && i <= high-1) i++;
            while (arr[j] > arr[pivot] && j >= low+1) j--;
            if (i < j) {
                swapTwo(arr, i, j);
            }
        }
        swapTwo(arr, pivot, j);
        return j;
    }
    
    static void quick_sort(int[] nums, int low, int high) {
        if (low < high) {
            int partition = partition(nums, low, high);
            quick_sort(nums, low, partition - 1);
            quick_sort(nums, partition + 1, high);
        }
    }
    
    static int[] quickSort(int[] nums) {
        int n = nums.length;
        int low = 0, high = n-1;
        quick_sort(nums, low, high);
        return nums;
    }
}

class QuickSort {
    public static void main(String[] args) {
        int[] arr = {4, 6, 2, 5, 7, 9, 1, 3};
        // int[] arr = {1, 3, 2};
        // int[] arr = {1, 2, 3, 4, 5, 6};
        // int[] arr = {14, 9, 15, 12, 6, 8, 13};
        // int[] arr = {14, 9, 15, 12, 6, 9, 13};
        // int[] arr = {14};
        int[] ans = Solution.quickSort(arr);
        System.out.println("Sorted array via QuickSort:\n"+ Arrays.toString(ans));
    }
}


/*
TC:
Best Case Time Complexity: O(n log n)
The best case occurs when the pivot elements are chosen in such a way that each partition splits the array into roughly equal halves. This results in balanced partitions and optimal sorting performance.

Worst Case Time Complexity: O(n^2)
The worst case occurs when the pivot elements are consistently chosen poorly, such as always selecting the smallest or largest element as the pivot. This can lead to highly unbalanced partitions, resulting in a time complexity similar to that of insertion sort.

Average Case Time Complexity: O(n log n)
The average case time complexity of quick sort is O(n log n), assuming that the pivot elements are chosen randomly or using a method that ensures balanced partitions most of the time. In practice, quick sort tends to perform very close to its average time complexity.

SC: O(1)

Algorithm:
- Choose a Pivot: Select a pivot element from the array. The choice of pivot can be made in various ways, such as selecting the first element, the last element, or a random element.
- Partitioning: Rearrange the elements of the array so that all elements less than the pivot are moved to its left, and all elements greater than the pivot are moved to its right. After this process, the pivot element is in its correct sorted position.
- Recursion: Recursively apply the above steps to the sub-arrays on the left and right of the pivot until the entire array is sorted.
*/
