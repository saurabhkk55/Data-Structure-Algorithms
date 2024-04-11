import java.util.ArrayList;
import java.util.Arrays;

class Solution
{
    //Function to merge the arrays.
    public static void merge(long arr1[], long arr2[], int n, int m) 
    {
        // code here
        int i, j;
        i = 0;
        j = 0;

        ArrayList<Long> temp = new ArrayList<>();
        while (i<arr1.length && j<arr2.length) {
            if (arr1[i] <= arr2[j]) {
                temp.add(arr1[i]);
                i++;
            } else {
                temp.add(arr2[j]);
                j++;
            }
        }
        
        while(i<arr1.length) {
            temp.add(arr1[i]);
            i++;
        }

        while(j<arr2.length) {
            temp.add(arr2[j]);
            j++;
        }
        
        System.out.println("ANSWER LIST: "+temp);
    }
}

public class Merge_Brute {
    public static void main(String[] args) {
        int n = 4; long[] arr1 = {1, 3, 5, 7};
        int m = 5; long[] arr2 = {0, 2, 6, 8, 9};
        Solution.merge(arr1, arr2, n, m);
    }
}

// TC: O(n+m)
// SC: O(n+m)

// This solution will not work because question itself ask for no extra.
