class Solution {
    static boolean search(int[][] mat, int k) {
        int rows = mat.length, cols = mat[0].length;
        int low = 0, high = (rows * cols -1);
        while (low <= high) {
            int mid = (low + high)/2;
            
            int row_idx = mid / cols;
            int col_idx = mid % cols;
            
            if (mat[row_idx][col_idx] == k) return true;
            else if (mat[row_idx][col_idx] < k) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
}

public class Optimal {
    public static void main(String[] args) {
        int[][] matrix = {
            {3, 4, 6, 8},
            {10, 12, 13, 15},
            {17, 18, 19, 20}
        };
        int target = 19;
        boolean ans = Solution.search(matrix, target);
        System.out.printf("Target: %d | Found: %b", target, ans);
    }
}

// Time Complexity: O(log(NxM)), where N = given row number, M = given column number.
// Reason: We are applying binary search on the imaginary 1D array of size NxM.
// Space Complexity: O(1) as we are not using any extra space

// Algorithm:
// 1. Place the 2 pointers i.e. low and high: Initially, we will place the pointers. The pointer low will point to 0 and the high will point to (NxM)-1.
// 2. Calculate the ‘mid’: Now, inside the loop, we will calculate the value of ‘mid’ using the following formula: mid = (low+high) // 2 ( ‘//’ refers to integer division)
// 3. Eliminate the halves based on the element at index mid: To get the element, we will convert index ‘mid’ to the corresponding cell using the above formula. Here no. of columns of the matrix = M.
//     row = mid / M, col = mid % M.
//     3.1. If matrix[row][col] == target: We should return true here, as we have found the ‘target’.
//     3.2. If matrix[row][col] < target: In this case, we need bigger elements. So, we will eliminate the left half and consider the right half (low = mid+1).
//     3.3. If matrix[row][col] > target: In this case, we need smaller elements. So, we will eliminate the right half and consider the left half (high = mid-1).
// 4. Steps 2-3 will be inside a while loop and the loop will end once low crosses high (i.e. low > high). If we are out of the loop, we can say the target does not exist in the matrix. So, we will return false.
