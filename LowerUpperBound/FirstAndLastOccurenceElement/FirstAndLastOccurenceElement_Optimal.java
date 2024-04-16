// Find First and Last Position of Element in Sorted Array

class Solution {
    // Lower Bound concept: Smallest index such as arr[idx] >= target
    static int first (int[] nums, int n, int x) {
        int low = 0, high = n-1, ans = -1;

        while (low <= high) {
            int mid = (low+high)/2;

            if (nums[mid] >= x) {
                if (nums[mid] == x) {
                    ans = mid;
                }
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    // Upper Bound concept: Smallest index such as arr[idx] > target
    static int last (int[] nums, int n, int x) {
        int low = 0, high = n-1, ans = n;

        while (low <= high) {
            int mid = (low+high)/2;

            if (nums[mid] <= x) {
                low = mid + 1;
            } else {
                ans = mid;
                high = mid - 1;
            }
        }
        return ans-1;
    }

    static int[] firstAndLast (int[] nums, int n, int x) {
        int[] ans = {-1, -1};
        
        int firstIdx = first(nums, n, x);
        if (firstIdx == -1) {
            return ans;
        } else {
            int lastIdx = last(nums, n, x);
            ans[0] = firstIdx;
            ans[1] = lastIdx;
            return ans;
        }
    }
}

public class FirstAndLastOccurenceElement_Optimal {
    public static void main(String[] args) {
        // int[] arr = {2, 4, 6, 8, 8, 8, 11, 13};
        // int[] arr = {1, 8, 8, 8, 8, 8, 8, 10, 10, 11};
        int[] arr = {0, 0, 1, 1, 2, 2, 2, 2};
        int target = 2;
        int[] ans = Solution.firstAndLast(arr, arr.length, target);
        System.out.println("First: "+ans[0]+" & Last: "+ans[1]);
    }
}

// TC: O(log-base-2 n)+O(log-base-2 n) => O(2(log-base-2 n))
// SC: O(1)
