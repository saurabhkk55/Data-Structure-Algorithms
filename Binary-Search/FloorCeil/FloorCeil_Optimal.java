// floor: a[idx] <= target: largest number in the arr that is equal to or just smaller than the target
// Ceil: a[idx] >= target: Smallest number in the arr that is equal to or just greater than the target
import java.util.* ;

class Solution {
  static int[] getFloorAndCeil(int[] a, int n, int x) {
    int[] ans  = new int[2];
    ans[0] = -1; // floor 
    ans[1] = -1; // ceil

    int low = 0, high = n-1;
    
    while (low <= high) {
      int mid=(low+high)/2;
      
      if (a[mid] == x) {
        ans[0] = a[mid];
        ans[1] = a[mid];
        return ans;
      } else if (a[mid] > x) {
        ans[1] = a[mid];
        high = mid - 1;
      } else {
        ans[0] = a[mid];
        low = mid + 1;
      }
    }
    return ans;
  }
}

class FloorCeil_Optimal {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 8, 8, 10, 10, 11};
        int target = 9; // 12; // 9; // 1;
        int[] ans = Solution.getFloorAndCeil(arr, arr.length, target);
        System.out.println("Floor: "+ ans[0]+ " and Ceil: "+ans[1]);
    }
}

// TC: O(log2n)
// SC: O(1)
