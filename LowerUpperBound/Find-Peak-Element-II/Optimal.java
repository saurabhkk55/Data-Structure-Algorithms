class Solution {
    static int findMaxIdx (int[][] temp, int at_column) {
        int rows = temp.length;
        int maxValue = -1, maxValueIdx = -1;
        for (int i=0; i<rows; i++) {
            if (temp[i][at_column] > maxValue) {
                maxValue = temp[i][at_column];
                maxValueIdx = i;
            }
        }
        return maxValueIdx;
    }
    static int[] peak (int[][] mat) {
        int cols = mat[0].length;
        int low = 0, high = cols - 1;
        while (low <= high) {
            int mid = (low + high)/2;
            
            int maxIdx = findMaxIdx(mat, mid);
            int left = (mid > 0) ? mat[maxIdx][mid - 1] : -1;
            int right = (mid < (cols -1)) ? mat[maxIdx][mid + 1] : -1;
            
            if (mat[maxIdx][mid] > left && mat[maxIdx][mid] > right) return new int[]{maxIdx, mid};
            else if (left > mat[maxIdx][mid]) high = mid - 1;
            else low = mid + 1;
        }
        return new int[]{-1, -1};
    }
}

public class Optimal {
    public static void main(String[] args) {
        int[][] matrix = {
            {4, 2, 5, 1, 4, 5},
            {2, 9, 3, 2, 3, 2},
            {1, 7, 6, 0, 1, 3},
            {3, 6, 2, 3, 7, 2}
        };
        int[] ans = Solution.peak(matrix);
        System.out.printf("Peak element foundt at row (0-based indexing): %d & column (0-based indexing): %d", ans[0], ans[1]);
    }
}