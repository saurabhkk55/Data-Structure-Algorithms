


import java.util.*;

public class Brute {
    public static int countPainters(ArrayList<Integer> boards, int time) {
        int n = boards.size(); // size of array.
        int painters = 1;
        long boardsPainter = 0;
        for (int i = 0; i < n; i++) {
            if (boardsPainter + boards.get(i) <= time) {
                // allocate board to current painter
                boardsPainter += boards.get(i);
            } else {
                // allocate board to next painter
                painters++;
                boardsPainter = boards.get(i);
            }
        }
        return painters;
    }

    public static int findLargestMinDistance(ArrayList<Integer> boards, int k) {
        int low = Collections.max(boards);
        int high = boards.stream().mapToInt(Integer::intValue).sum();

        for (int time = low; time <= high; time++) {
            if (countPainters(boards, time) <= k) {
                return time;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        ArrayList<Integer> boards = new ArrayList<>(Arrays.asList(10, 20, 30, 40));
        int k = 2;
        int ans = findLargestMinDistance(boards, k);
        System.out.println("The answer is: " + ans);
    }
}

// Time Complexity: O[(N)+(N * (sum(arr[])-max(arr[])+1))], where N = size of the array, sum(arr[]) = sum of all array elements, max(arr[]) = maximum of all array elements.
// Reason: We are using a loop from max(arr[]) to sum(arr[]) to check all possible values of time. Inside the loop, we are calling the countPainters() function for each number. Now, inside the countPainters() function, we are using a loop that runs for N times.
// Space Complexity:  O(1) as we are not using any extra space to solve this problem.

// Naive Approach: 
// The extremely naive approach is to check all possible answers from max(arr[]) to sum(arr[]). The minimum time for which we can paint all the boards will be our answer.

// Algorithm:
// 1. First, we will find the maximum element and the summation of the given array.
// 2. We will use a loop(say time) to check all possible answers from max(arr[]) to sum(arr[]).
// 3. Next, inside the loop, we will send ‘time’, to the function countPainters() function to get the number of painters to whom we can allocate the boards.
// 3.1. The first value of ‘time’, for which the number of painters will be lesser or equal to ‘k’, will be our answer. So, we will return that particular value of ‘time’.
// 4. Finally, if we are out of the loop, we will return max(arr[]) as there cannot exist any answer smaller than that.
