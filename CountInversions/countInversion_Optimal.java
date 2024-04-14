import java.util.ArrayList;
import java.util.List;

class Solution {
    static int merge (int[] arr, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>();
        int left = low, right = mid+1, count = 0;
        
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
                count = count + (mid + 1) - left;
            }
        }
        
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }
        
        for (int i=low; i<=high; i++) {
            arr[i] = temp.get(i-low);
        }
        return count;
    }

    static int merge_sort (int[] arr, int low, int high) {
        if (low >= high) return 0;
        int mid=(low+high)/2;
        int count = 0;
        count = count + merge_sort(arr, low, mid);
        count = count + merge_sort(arr, mid+1, high);
        count = count + merge(arr, low, mid, high);
        return count;
    }

    static int countInversion (int[] nums) {
        int low = 0, high = nums.length-1;
        return merge_sort(nums, low, high);
    }
}

class countInversion_Optimal {
    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 4, 1};
        int count = 0;
        int ans = Solution.countInversion(arr);
        System.out.println("Total Inversion pairs: "+ ans);
    }
}

// TC: O(n log n)
// SC: O(n)
