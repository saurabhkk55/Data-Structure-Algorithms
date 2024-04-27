class Solution {
    // cols = 
    // int row = 0, col = 
    static int[] search (int[][] mat, int k) {
        int rows = mat.length, cols = mat[0].length;
        int row = 0, col = cols - 1;

        while (row < rows && col >= 0) {
            if (mat[row][col] == k) return new int[]{row+1, col+1};
            else if (mat[row][col] > k) col--;
            else row++; 
        }
        return new int[]{-1, -1};
    }
}

public class Optimal {
    public static void main(String[] args) {
        int[][] matrix = {
            { 1,  4,  7, 11, 15},
            { 2,  5,  8, 12, 19},
            { 3,  6,  9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };
        int target = 21;
        int[] ans = Solution.search(matrix, target);
        System.out.printf("Target: %d | Found at row: %d & column: %d", target, ans[0], ans[1]);
    }
}

// Time Complexity: O(N+M), where N = given row number, M = given column number.
// Reason: We are starting traversal from (0, M-1), and at most, we can end up being in the cell (M-1, 0). So, the total distance can be at most (N+M). So, the time complexity is O(N+M).
// Space Complexity: O(1) as we are not using any extra space.
