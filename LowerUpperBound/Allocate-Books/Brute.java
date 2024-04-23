class Solution {
    static int countStudents (int[] books, int students, int pages) {
        int totalPages = books[0];
        int countStudents = 1;
        for (int i=1; i<books.length; i++) {
            int allocatedPages = totalPages + books[i];
            if (allocatedPages <= pages) {
                totalPages += books[i];
            } else {
                countStudents++;
                totalPages = books[i];
            }
        }
        return countStudents;
    }

    static int allocateBooks (int[] books, int students) {
        int low = Integer.MIN_VALUE, high = 0;
        for (int i=0; i<books.length; i++) {
            low = Math.max(low, books[i]);
            high += books[i];
        }
        
        for (int i=low; i<=high; i++) {
            int countStudents = countStudents(books, students, i);
            System.out.printf("i: %d & countStudents: %d\n", i, countStudents); // Troubleshooting
            if (countStudents == students) {
                return i;
            }
        }
        return 1000;
    }
}

public class Brute {
    public static void main(String[] args) {
        int[] books = {25, 46, 28, 49, 24};
        int students = 4;
        int ans = Solution.allocateBooks(books, students);
        System.out.println("Ans: "+ans);
    }
}

// Naive Approach: 
// The extremely naive approach is to check all possible pages from max(arr[]) to sum(arr[]). The minimum pages for which we can allocate all the books to M students will be our answer.

// Algorithm:
// 1. If m > n: In this case, book allocation is not possible and so, we will return -1.
// 2. Next, we will find the maximum element and the summation of the given array.
// 3. We will use a loop(say pages) to check all possible pages from max(arr[]) to sum(arr[]).
// 4. Next, inside the loop, we will send each ‘pages’, to the function countStudents() function to get the number of students to whom we can allocate the books.
// 4.1. The first number of pages, ‘pages’, for which the number of students will be equal to ‘m’, will be our answer. So, we will return that particular ‘pages’.
// Finally, if we are out of the loop, we will return max(arr[]) as there cannot exist any answer smaller than that.

// Time Complexity: O[(N)+(N * (sum(arr[])-max(arr[])+1))], where N = size of the array, sum(arr[]) = sum of all array elements, max(arr[]) = maximum of all array elements.
// Reason: We are using a loop from max(arr[]) to sum(arr[]) to check all possible numbers of pages. Inside the loop, we are calling the countStudents() function for each number. Now, inside the countStudents() function, we are using a loop that runs for N times.
// Space Complexity:  O(1) as we are not using any extra space to solve this problem.