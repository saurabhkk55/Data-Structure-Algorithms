class Solution {
    static boolean binarySearch(int[] a, int x) {
        int low = 0;
        int high = a.length - 1;
        return doBinarySearch(a, x, low, high);
    }

    static boolean doBinarySearch(int[] a, int x, int low, int high) {
        // Base case: If low index exceeds high index, element not found
        if (low > high) {
            return false;
        }

        int mid = low + ((high - low) / 2); // Calculate the middle index

        if (a[mid] == x) {
            return true; // Element found
        } else if (a[mid] < x) {
            // Search in the right half
            return doBinarySearch(a, x, mid + 1, high);
        } else {
            // Search in the left half
            return doBinarySearch(a, x, low, mid - 1);
        }
    }
}

public class Codez {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 6, 7, 8, 9, 10};
        int target = 9;
        boolean found = Solution.binarySearch(arr, target);
        System.out.println("Element found: " + found);
    }
}

// TC: O(logbase2 n), here n = length of the given array
// SC: O(1)
