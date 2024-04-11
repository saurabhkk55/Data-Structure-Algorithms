import java.util.Arrays;

class Solution
{
    //Function to merge the arrays.
    public static void merge(long arr1[], long arr2[], int n, int m) 
    {
        // code here
        int i, j;
        i = n-1;
        j = 0;
        
        while (i>=0 && j<m) {
            if (arr1[i] > arr2[j]) {
                long temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
            } else {
                break;
            }
            i--;
            j++;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        System.out.println("ARRAY 1: "+Arrays.toString(arr1));
        System.out.println("ARRAY 2: "+Arrays.toString(arr2));
    }
}

public class Merge_Optimal {
    public static void main(String[] args) {
        int n = 4; long[] arr1 = {1, 3, 5, 7};
        int m = 5; long[] arr2 = {0, 2, 6, 8, 9};
        Solution.merge(arr1, arr2, n, m);
    }
}

// TC: O[min(n, m) + nlogn + mlogn]
// SC: O(1) No extra space is used here
