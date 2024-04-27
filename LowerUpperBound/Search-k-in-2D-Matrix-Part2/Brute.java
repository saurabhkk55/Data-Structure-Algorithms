class Solution {
    static int[] search(int[][] mat, int k) {
        int rows = mat.length, cols = mat[0].length;
        
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (mat[i][j] == k) {
                    return new int[]{i+1, j+1};
                }
            }
        }
        return new int[]{-1, -1};
    }
}

public class Brute {
    public static void main(String[] args) {
        int[][] matrix = {
            { 1,  4,  7, 11, 15},
            { 2,  5,  8, 12, 19},
            { 3,  6,  9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };
        int target = 100;
        int[] ans = Solution.search(matrix, target);
        System.out.printf("Target: %d | Found at row: %d & column: %d", target, ans[0], ans[1]);
    }
}

// Time Complexity: O(N X M), where N = given row number, M = given column number.
// Reason: In order to traverse the matrix, we are using nested loops running for n and m times respectively.
// Space Complexity: O(1) as we are not using any extra space.
