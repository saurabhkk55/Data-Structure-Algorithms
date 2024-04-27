class Solution {
    // Lower Bound
    static int countOnes (int[] a) {
        int n = a.length; // number of columns in the current row
        int low = 0, high = n-1;

        while (low <= high) {
            int mid = (low + high)/2;

            if (a[mid] >= 1) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return n - low;
    }

    static int rowWithMaxOnes (int[][] a) {
        int rows = a.length, maxCount = -1, idx = -1;

        for (int i=0; i<rows; i++) {
            int count = countOnes(a[i]);
            if (count > maxCount) {
                maxCount = count;
                idx = i;
            }
        }
        return idx;
    }
}

public class Optimal {
    public static void main(String[] args) {
        // int[] arr = {0, 0, 0, 1, 1, 1, 1, 1};
        int[][] arr = {
            {0, 0, 1, 1, 1},
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1},
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1}
        };
        int ans = Solution.rowWithMaxOnes(arr);
        System.out.println("First row that contains maximum number of ones: "+ans);
    }
}

// Time Complexity: O(n * logm), where n = given row number, m = given column number.
// Reason: We are using a loop running for n times to traverse the rows. Then we are applying binary search on each row with m columns.
// Space Complexity: O(1) as we are not using any extra space.
