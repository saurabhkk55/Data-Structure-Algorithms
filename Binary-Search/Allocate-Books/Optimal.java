class Solution {
    static int countStudents (int[] books, int pages) {
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
        if (students > books.length) {
            return -1;
        }

        int low = Integer.MIN_VALUE, high = 0;
        for (int i=0; i<books.length; i++) {
            low = Math.max(low, books[i]);
            high += books[i];
        }
        
        while (low <= high) {
            int mid = (low + high)/2;
            int countStudents = countStudents(books, mid);
            if (countStudents <= students) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}

public class Optimal {
    public static void main(String[] args) {
        int[] books = {25, 46, 28, 49, 24};
        int students = 4;
        int ans = Solution.allocateBooks(books, students);
        System.out.println("Ans: "+ans);
    }
}

// Algorithm:
// 1. If m > n: In this case, book allocation is not possible and so, we will return -1.
// 2. Place the 2 pointers i.e. low and high: Initially, we will place the pointers. The pointer low will point to max(arr[]) and the high will point to sum(arr[]).
// 3. Calculate the ‘mid’: Now, inside the loop, we will calculate the value of ‘mid’ using the following formula:
// mid = (low+high) // 2 ( ‘//’ refers to integer division)
// 4. Eliminate the halves based on the number of students returned by countStudents():
// We will pass the potential number of pages, represented by the variable 'mid', to the ‘countStudents()' function. This function will return the number of students to whom we can allocate the books.
// 4.1. If students > m: On satisfying this condition, we can conclude that the number ‘mid’ is smaller than our answer. So, we will eliminate the left half and consider the right half(i.e. low = mid+1).
// 4.2. Otherwise, the value mid is one of the possible answers. But we want the minimum value. So, we will eliminate the right half and consider the left half(i.e. high = mid-1).
// 5. Finally, outside the loop, we will return the value of low as the pointer will be pointing to the answer.
// The steps from 3-4 will be inside a loop and the loop will continue until low crosses high.

// Time Complexity: O[(N)+(N * log(sum(arr[])-max(arr[])+1))], where N = size of the array, sum(arr[]) = sum of all array elements, max(arr[]) = maximum of all array elements.
// Reason: We are applying binary search on [max(arr[]), sum(arr[])]. Inside the loop, we are calling the countStudents() function for the value of ‘mid’. Now, inside the countStudents() function, we are using a loop that runs for N times.
// Space Complexity:  O(1) as we are not using any extra space to solve this problem.
