class Solution {
    static int[] findMinMax (int[] arr, int n) {
        int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
        for (int i=0; i<n; i++){
            mini = Math.min(mini, arr[i]);
            maxi = Math.max(maxi, arr[i]);
        }
        int[] temp = {mini, maxi};
        return temp;
    }

    static int bouquetcount (int[] arr, int r, int day) {
        // r: no. of adjacent days
        int cnt = 0, numOfBouquets = 0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] <= day) {
                cnt++;
            } else {
                numOfBouquets += cnt/r;
                cnt = 0;
            }
        }
        numOfBouquets += cnt/r;
        return numOfBouquets;
    }

    static int roseGarden(int[] arr, int r, int b) {
        // Write your code here.
        // r: no. of adjacent days
        // b: no. of bouquets

        int n = arr.length;
        // int ans = Integer.MAX_VALUE;

        // Edge-case
        if ((long) (r*b) > n) {
            return -1;
        }
        
        int[] minMax = findMinMax(arr, n);
        int low = minMax[0], high = minMax[1];

        while (low <= high) {
            int mid = (low+high)/2;

            int bouquetNum = bouquetcount(arr, r, mid);

            if (bouquetNum >= b) {
                // ans = Math.min(ans, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        // return ans;
        return low; // return low or return ans both are correct
    }
}

public class RoseGarden_Optimal {
    public static void main(String[] args) {
    int[] arr = {1, 2, 1, 2, 7, 2, 2, 3, 1};
    int adjDays = 3, reqdBookays = 2;
    int ans = Solution.roseGarden(arr, adjDays, reqdBookays);
    if (ans == -1)
        System.out.println("We cannot make m bouquets.");
    else
        System.out.println("We can make bouquets on day " + ans);
    }
}

/*
Time Complexity: O(log(max(arr[])-min(arr[])+1) * N), where {max(arr[]) -> maximum element of the array, min(arr[]) -> minimum element of the array, N = size of the array}.
Reason: We are applying binary search on our answers that are in the range of [min(arr[]), max(arr[])]. For every possible answer ‘mid’, we will call the possible() function. Inside the possible() function, we are traversing the entire array, which results in O(N).
Space Complexity: O(1) as we are not using any extra space to solve this problem.
 */

/*
Algorithm:
1. If m*k > arr.size: This means we have insufficient flowers. So, it is impossible to make m bouquets and we will return -1.
2. Next, we will find the maximum element i.e. max(arr[]), and the minimum element i.e. min(arr[]) in the array.
3. Place the 2 pointers i.e. low and high: Initially, we will place the pointers. The pointer low will point to min(arr[]) and the high will point to max(arr[]).
4. Calculate the ‘mid’: Now, inside the loop, we will calculate the value of ‘mid’ using the following formula:
mid = (low+high) // 2 ( ‘//’ refers to integer division)
5. Eliminate the halves based on the value returned by possible():
We will pass the potential answer, represented by the variable 'mid' (which corresponds to a specific day), to the 'possible()' function.
    5.1. If possible() returns true: On satisfying this condition, we can conclude that the number ‘mid’ is one of our possible answers. But we want the minimum number. So, we will eliminate the right half and consider the left half(i.e. high = mid-1).
    5.2. Otherwise, the value mid is smaller than the number we want. This means the numbers greater than ‘mid’ should be considered and the right half of ‘mid’ consists of such numbers. So, we will eliminate the left half and consider the right half(i.e. low = mid+1).
6. Finally, outside the loop, we will return the value of low as the pointer will be pointing to the answer.
7. The steps from 3-5 will be inside a loop and the loop will continue until low crosses high.
  */

/*
Problem Statement: You are given 'N’ roses and you are also given an array 'arr'  where 'arr[i]'  denotes that the 'ith' rose will bloom on the 'arr[i]th' day.
You can only pick already bloomed roses that are adjacent to make a bouquet. You are also told that you require exactly 'k' adjacent bloomed roses to make a single bouquet.
Find the minimum number of days required to make at least ‘m' bouquets each containing 'k' roses. Return -1 if it is not possible.

Example 1:
Input Format:
N = 8, arr[] = {7, 7, 7, 7, 13, 11, 12, 7}, m = 2, k = 3
Result:
12
Explanation:
On the 12th the first 4 flowers and the last 3 flowers would have already bloomed. So, we can easily make 2 bouquets, one with the first 3 and another with the last 3 flowers.

Example 2:
Input Format:
N = 5, arr[] = {1, 10, 3, 10, 2}, m = 3, k = 2
Result:
-1
Explanation:
If we want to make 3 bouquets of 2 flowers each, we need at least 6 flowers. But we are given only 5 flowers, so, we cannot make the bouquets.
 */