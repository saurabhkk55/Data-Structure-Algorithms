class Solution {
    static boolean search(int[][] mat, int k) {
        int rows = mat.length, cols = mat[0].length;
        
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (mat[i][j] == k) {
                    return true;
                }
            }
        }
        return false;
    }
}

public class Brute {
    public static void main(String[] args) {
        int[][] matrix = {
            {3, 4, 6, 8},
            {10, 12, 13, 15},
            {17, 18, 19, 20}
        };
        int target = 15;
        boolean ans = Solution.search(matrix, target);
        System.out.printf("Target: %d | Found: %b", target, ans);
    }
}

// Time Complexity: O(N X M), where N = given row number, M = given column number.
// Reason: In order to traverse the matrix, we are using nested loops running for n and m times respectively.
// Space Complexity: O(1) as we are not using any extra space.
