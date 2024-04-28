class Solution {
    static int upperBound (int[] temp, int k) {
        int n = temp.length;
        // int ans = n;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high)/2;
            
            if (temp[mid] <= k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low; // number of elements smaller than k
    }

    static int countSmallerEquals (int[][] mat, int x) {
        int rows = mat.length, totalSmallerEquals = 0;
        for (int i=0; i< rows; i++) {
            int smallerElements = upperBound(mat[i], x);
            totalSmallerEquals += smallerElements;
        }
        // System.out.println("x: "+ x +"cnt: "+ totalSmallerEquals);
        return totalSmallerEquals;
    }

    static int median (int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for (int i=0; i<rows; i++) {
            low = Math.min(low, mat[i][0]);
            high = Math.max(high, mat[i][cols-1]);
        }
        
        int reqd = (rows * cols) /2;
        while (low <= high) {
            int mid = (low + high)/2;
            
            int smallerEquals = countSmallerEquals (mat, mid);
            if (smallerEquals <= reqd) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }
}
public class Optimal {
    public static void main(String[] args) {
        int[][] matrix = {
            {1,  5,  7,  9, 11},
            {2,  3,  4,  5, 10},
            {9, 10, 12, 14, 16}
        };
        int ans = Solution.median(matrix);
        System.out.printf("Median in a 2d array: %d", ans);
    }
}

// TC: O[(logbase2 (10^9)) * (rows) * (logbas2 (cols))]
// sc: O(1)

// Brute:
// - convert 2d array into 1d array via traversing each elements of the 2d array
// - sort the 1d array in asscending order
// then just do arr[n*m/2], here arr is the 1d array and n & m reprsents total no. of rows & columns in an 2d array respectively.
