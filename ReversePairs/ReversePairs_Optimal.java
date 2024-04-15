import java.util.ArrayList;

class Solution {
    static void merge (long[] arr, int low, int mid, int high) {
        ArrayList<Long> temp = new ArrayList<>();
        int left = low, right = mid+1;
        
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
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
    }

    static long countPairs (long[] a, int low, int mid, int high) {
        int right = mid+1;
        long count = 0;

        for (int i=low; i<=mid; i++) {
            while (right <= high && a[i] > 2*a[right]) {
                right++;
            }
            count += (right - (mid+1));
        }
        return count;
    }

    static long ms (long[] a, int low, int high) {
        long count = 0;
        if (low >= high) return count;

        int mid = (low+high)/2;
        count += ms(a, low, mid);
        count += ms(a, mid+1, high);
        count += countPairs(a, low, mid, high);
        merge(a, low, mid, high);
        return count;
    }

    static long reversePairs (long[] nums) {
        int low = 0, high = nums.length-1;
        return ms(nums, low, high);
    }
}
class ReversePairs_Optimal {
    public static void main(String[] args) {
        long[] arr = {2147483647,2147483647,2147483647,2147483647,2147483647,2147483647}; // {40, 25, 19, 12, 9, 6, 2}; // {4, 1, 2, 3, 1};
        long ans = Solution.reversePairs(arr);
        System.out.println("Reversed pair counts: "+ans);
    }
}

// TC: O(2nlogn)
// SC: O(n)
