import java.util.ArrayList;

class Solution {
    static double median (int[] a1, int[] a2, int n1, int n2) {
        int i = 0, j = 0;
        ArrayList<Integer> sort = new ArrayList<>();
        while(i < n1 && j < n2) {
            if (a1[i] <= a2[j]) {
                sort.add(a1[i]);
                i++;
            } else {
                sort.add(a2[j]);
                j++;
            }
        }
        while (i < n1) {
            sort.add(a1[i]);
            i++;
        }
        while (j < n2) {
            sort.add(a2[j]);
            j++;
        }
        System.out.println(sort);
        int n = sort.size();
        if (n%2 == 1) {
            return sort.get(n/2);
        } else {
            return (double) (((double) (sort.get(((n)/2))) + (double) (sort.get((((n)/2)-1))))/2);
        }
    }
}
public class Brute {
    public static void main(String[] args) {
        int[] a1 = {1,3,4,7,10,12};
        int[] a2 = {2,3,6,15};
        double ans = Solution.median(a1, a2, a1.length, a2.length);
        System.out.println("Ans: "+ans);
    }
}

// Complexity Analysis
// Time Complexity: O(n1+n2), where  n1 and n2 are the sizes of the given arrays.
// Reason: We traverse through both arrays linearly.
// Space Complexity: O(n1+n2), where  n1 and n2 are the sizes of the given arrays.
// Reason: We are using an extra array of size (n1+n2) to solve this problem.

// Algorithm:
// 1. We will use a third array i.e. arr3[] of size (n1+n2) to store the elements of the two sorted arrays. 
// 2. Now, we will take two pointers i and j, where i points to the first element of arr1[] and j points to the first element of arr2[].
// 3. Next, using a while loop( while(i < n1 && j < n2)), we will select two elements i.e. arr1[i] and arr2[j], and consider the smallest one among the two. Then, we will insert the smallest element in the third array and increase that specific pointer by 1.
// 	3.1. If arr1[i] < arr2[j]: Insert arr1[i] into the third array and increase i by 1.
// 	3.2. Otherwise: Insert arr2[j] into the third array and increase j by 1.
// 4. After that, the left-out elements from both arrays will be copied as it is into the third array.
// 5. Now, the third array i.e. arr3[] will be the sorted merged array. Now the median will be the following:
// 	5.1. If the length of arr3[] i.e. (n1+n2) is even: The median is the average of the two middle elements. index = (n1+n2) / 2, median = (arr3[index] + arr3[index-1]) / 2.0.
// 	5.2. If the length of arr3[] i.e. (n1+n2) is odd: index = (n1+n2) / 2,
// median = arr3[index].
// 6. Finally, we will return the value of the median.
