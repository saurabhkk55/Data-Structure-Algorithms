import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    // public static List<Integer> merge(List<Integer> arr, int low, int mid, int high, int cnt) {
    public static int merge(List<Integer> arr, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        
        int left = low, right = mid + 1, cnt = 0;

        while(left <= mid && right <= high) {
            if(arr.get(left) <= arr.get(right)) {
                temp.add(arr.get(left));
                left++;
            } else {
                temp.add(arr.get(right));
                right++;
                cnt += (mid-left+1);
            }
        }
        while(left <= mid) {
            temp.add(arr.get(left));
            left++;
        }
        while(right <= high) {
            temp.add(arr.get(right));
            right++;
        }
        
        for(int i=low; i<=high; i++) {
            arr.set(i, temp.get(i-low));
        }
        
        return cnt;
    }
    
    public static int init_merge_sort(List<Integer> arr, int low, int high) {
        if(low == high) return 0;
        int mid = (low+high)/2;
        int cnt = 0;
        cnt += init_merge_sort(arr, low, mid);
        cnt += init_merge_sort(arr, mid+1, high);
        cnt += merge(arr, low, mid, high);
        return cnt;
    }
    public static List<Integer> mergeSort(List<Integer> arr) {
        int low = 0, high = arr.size() - 1, cnt = 0;
        cnt = init_merge_sort(arr, low, high);
        System.out.println("Pairs: "+cnt);
        return arr;
    }
}

class MergeSort {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr = Arrays.asList(5, 3, 2, 4, 1);
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
