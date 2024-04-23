import java.util.*;

public class Brute {
    public static boolean canWePlace(int[] stalls, int dist, int cows) {
        int n = stalls.length; //size of array
        int cntCows = 1; //no. of cows placed
        int last = stalls[0]; //position of last placed cow.
        for (int i = 1; i < n; i++) {
            if (stalls[i] - last >= dist) {
                cntCows++; //place next cow.
                last = stalls[i]; //update the last location.
            }
            if (cntCows >= cows) return true;
        }
        return false;
    }
    public static int aggressiveCows(int[] stalls, int k) {
        int n = stalls.length; //size of array
        //sort the stalls[]:
        Arrays.sort(stalls);

        int limit = stalls[n - 1] - stalls[0];
        for (int i = 1; i <= limit; i++) {
            if (canWePlace(stalls, i, k) == false) {
                return (i - 1);
            }
        }
        return limit;
    }
    public static void main(String[] args) {
        int[] stalls = {0, 3, 4, 7, 10, 9};
        int k = 4;
        int ans = aggressiveCows(stalls, k);
        System.out.println("The maximum possible minimum distance is: " + ans);
    }
}

// Complexity Analysis
// Time Complexity: O(NlogN) + O(N *(max(stalls[])-min(stalls[]))), where N = size of the array, max(stalls[]) = maximum element in stalls[] array, min(stalls[]) = minimum element in stalls[] array.
// Reason: O(NlogN) for sorting the array. We are using a loop from 1 to max(stalls[])-min(stalls[]) to check all possible distances. Inside the loop, we are calling canWePlace() function for each distance. Now, inside the canWePlace() function, we are using a loop that runs for N times.
// Space Complexity: O(1) as we are not using any extra space to solve this problem.

// Naive Approach:
// The extremely naive approach is to check all possible distances from 1 to max(stalls[])-min(stalls[]). The maximum distance for which the function canWePlace() returns true, will be our answer.
// Algorithm:
// 1. First, we will sort the given stalls[] array.
// 2. We will use a loop(say i) to check all possible distances.
// 3. Next, inside the loop, we will send each distance, i, to the function canWePlace() function to check if it is possible to place the cows.
// 3.1. We will return (i-1), where i is the minimum distance for which the function canWePlace() returns false. Because (i-1) is the maximum distance for which we can place all the cows and for the distances >= i, it becomes impossible.
// 4. Finally, if we are outside the loop, we can conclude the minimum possible distance should be max(stalls[])-min(stalls[]). And we will return this value.
