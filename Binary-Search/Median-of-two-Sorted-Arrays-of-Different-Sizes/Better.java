import java.util.ArrayList;

class Solution {
    static double median (int[] a1, int[] a2, int n1, int n2) {
        int i = 0, j = 0, n = (n1+n2);
        int idx1 = (n/2) - 1, idx1_element = -1;
        int idx2 = (n/2), idx2_element = -1;

        int cnt = 0;

        while(i < n1 && j < n2) {
            if (a1[i] <= a2[j]) {
                if (cnt == idx1) idx1_element = a1[i];
                if (cnt == idx2) idx2_element = a1[i];
                cnt++;
                i++;
            } else {
                if (cnt == idx1) idx1_element = a2[j];
                if (cnt == idx2) idx2_element = a2[j];
                cnt++;
                j++;
            }
        }
        while (i < n1) {
            if (cnt == idx1) idx1_element = a1[i];
            if (cnt == idx2) idx2_element = a1[i];
            cnt++;
            i++;
        }
        while (j < n2) {
            if (cnt == idx1) idx1_element = a2[j];
            if (cnt == idx2) idx2_element = a2[j];
            cnt++;
            j++;
        }
        System.out.printf("idx1_element: %d | idx2_element: %d\n", idx1_element, idx2_element);
        if (n%2 == 1) return idx2_element;

        return (double) (((double) (idx1_element + idx2_element))/2);
    }
}

public class Better {
    public static void main(String[] args) {
        int[] a1 = {1,3,4,7,10,12};
        int[] a2 = {2,3,6,15};
        double ans = Solution.median(a1, a2, a1.length, a2.length);
        System.out.println("Ans: "+ans);
    }
}

// Time Complexity: O(n1+n2), where  n1 and n2 are the sizes of the given arrays.
// Reason: We traverse through both arrays linearly.
// Space Complexity: O(1), as we are not using any extra space to solve this problem.

// Algorithm / Intuition
// To optimize the space used in the previous approach, we can eliminate the third array used to store the final merged result. After closer examination, we realize that we only need the two middle elements at indices (n1+n2)/2 and ((n1+n2)/2)-1, rather than the entire merged array, to solve the problem effectively.

// We will stick to the same basic approach, but instead of storing elements in a separate array, we will use a counter called 'cnt' to represent the imaginary third array's index. As we traverse through the arrays, when 'cnt' reaches either index (n1+n2)/2 or ((n1+n2)/2)-1, we will store that particular element. This way, we can achieve the same goal without using any extra space.

// Algorithm:
// 1. We will call the required indices as ind2 = (n1+n2)/2 and ind1 = ((n1+n2)/2)-1. Now we will declare the counter called ‘cnt’ and initialize it with 0.
// 2. Now, as usual, we will take two pointers i and j, where i points to the first element of arr1[] and j points to the first element of arr2[].
// 3. Next, using a while loop( while(i < n1 && j < n2)), we will select two elements i.e. arr1[i] and arr2[j], and consider the smallest one among the two. Then, we will increase that specific pointer by 1.
// In addition to that, in each iteration, we will check if the counter ‘cnt’ hits the indices ind1 or ind2. when 'cnt' reaches either index ind1 or ind2, we will store that particular element. We will also increase the ‘cnt’ by 1 every time regardless of matching the conditions.
// 	3.1. If arr1[i] < arr2[j]: Check ‘cnt’ to perform necessary operations and increase i and ‘cnt’ by 1.
// 	3.2. Otherwise: Check ‘cnt’ to perform necessary operations and increase j and ‘cnt’ by 1.
// 4. After that, the left-out elements from both arrays will be copied as it is into the third array. While copying we will again check the above-said conditions for the counter, ‘cnt’ and increase it by 1.
// 5. Now, let’s call the elements at the required indices as ind1el(at ind1) and ind2el(at ind2):
// 	5.1. If the total length i.e. (n1+n2) is even: The median is the average of the two middle elements. median = (ind1el + ind2el) / 2.0.
// 	5.2. If the total length i.e. (n1+n2) is odd: median = ind2el.
// Finally, we will return the value of the median.
