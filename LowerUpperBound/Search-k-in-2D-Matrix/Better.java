class Solution {
    static boolean isTargetPresent (int[] temp, int k) {
        int low = 0, high = temp.length - 1;
        
        while(low <= high) {
            int mid = (low + high)/2;
            
            if (temp[mid] == k) {
                return true;
            } else if (temp[mid] < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
    
    static boolean search(int[][] mat, int k) {
        int rows = mat.length, cols = mat[0].length;
        
        for (int i=0; i<rows; i++) {
            if (mat[i][0] <= k && k <= mat[i][cols-1]) {
                return isTargetPresent(mat[i], k);
            }
        }
        return false;
    }
}

public class Better {
    public static void main(String[] args) {
        int[][] matrix = {
            {3, 4, 6, 8},
            {10, 12, 13, 15},
            {17, 18, 19, 20}
        };
        int target = 20;
        boolean ans = Solution.search(matrix, target);
        System.out.printf("Target: %d | Found: %b", target, ans);
    }
}

// Time Complexity: O(N + logM), where N = given row number, M = given column number.
// Reason: We are traversing all rows and it takes O(N) time complexity. But for all rows, we are not applying binary search rather we are only applying it once for a particular row. That is why the time complexity is O(N + logM) instead of O(N*logM).
// Space Complexity: O(1) as we are not using any extra space.
