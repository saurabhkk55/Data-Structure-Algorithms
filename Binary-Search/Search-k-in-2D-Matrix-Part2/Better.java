class Solution {
    static int isTargetPresent (int[] temp, int k) {
        int low = 0, high = temp.length - 1;
        
        while(low <= high) {
            int mid = (low + high)/2;
            
            if (temp[mid] == k) {
                return mid;
            } else if (temp[mid] < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1; // target does not exist
    }
    
    static int[] search(int[][] mat, int k) {
        int rows = mat.length;
        
        for (int i=0; i<rows; i++) {
            int column = isTargetPresent(mat[i], k);
            if (column != -1) {
                return new int[]{i+1, column+1};
            }
        }
        return new int[]{-1, -1};
    }
}

public class Better {
    public static void main(String[] args) {
        int[][] matrix = {
            { 1,  4,  7, 11, 15},
            { 2,  5,  8, 12, 19},
            { 3,  6,  9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };
        int target = 14;
        int[] ans = Solution.search(matrix, target);
        System.out.printf("Target: %d | Found at row: %d & column: %d", target, ans[0], ans[1]);
    }
}

// Time Complexity: O(N*logM), where N = given row number, M = given column number.
// Reason: We are traversing all rows and it takes O(N) time complexity. And for all rows, we are applying binary search. So, the total time complexity is O(N*logM).
// Space Complexity: O(1) as we are not using any extra space.
