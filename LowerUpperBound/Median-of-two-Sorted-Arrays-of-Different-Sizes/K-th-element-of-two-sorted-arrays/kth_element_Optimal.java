class Solution {
    public static double median(int[] a, int[] b, int k) {
        int n1 = a.length, n2 = b.length;
        //if n1 is bigger swap the arrays:
        if (n1 > n2) return median(b, a, k);

        int left = k;
        //apply binary search:
        int low = Math.max(k-n2, 0), high = Math.min(k, n1);
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;
            //calculate l1, l2, r1 and r2;
            int l1 = (mid1 > 0) ? a[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? b[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? a[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? b[mid2] : Integer.MAX_VALUE;
            
            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            } 
            else if (l1 > r2) high = mid1 - 1;
            else low = mid1 + 1;
        }
        return 0; //dummy statement
    }
}

public class kth_element_Optimal {
    public static void main(String[] args) {
        int[] a1 = {1,3,4,7,10,12};
        int[] a2 = {2,3,6,15};
        int kth_element = 4;
        double ans = Solution.median(a1, a2, kth_element);
        System.out.println("Ans: "+ans);
    }
}

// Time Complexity : log(min(m,n))
// Reason: We are applying binary search in the array with minimum size among the two. And we know the time complexity of the binary search is log(N) where N is the size of the array. Thus, the time complexity of this approach is log(min(m,n)), where m, and n are the sizes of two arrays.
// Space Complexity: O(1)
// Reason: Since no extra data structure is used, making space complexity to O(1).
