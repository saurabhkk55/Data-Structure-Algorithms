class Solution
{
    static int isNthRoot (int mid, int n, int m) {
        //Return 0 if ans == m
        //Return 1 if ans < m
        //Return 2 if ans > m
        long ans = 1;
        for (int i=1; i<=n; i++) {
            ans = ans * (long) mid;
            if (ans > m) return 2;
        }
        if (ans == m) return 0;
        else return 1;
    }
    public static int NthRoot(int n, int m)
    {
        int low = 1, high = m;
        
        while (low <= high) {
            int mid = (low+high)/2;
            
            int ans = isNthRoot(mid, n, m);
            
            if (ans == 0) return mid;
            else if (ans == 1) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}

public class FindNthRoot_Optimal {
    public static void main(String[] args) {
        // int n = 3, m = 27;
        int n = 9, m = 1953125;
        int ans = Solution.NthRoot(n, m);
        System.out.printf("%dth Root of a %d is: %d", n, m, ans);
    }
}

// Complexity Analysis
// Time Complexity: O(logbase2 N), N = size of the given array.
// Reason: We are basically using binary search to find the minimum.
// Space Complexity: O(1)
// Reason: We have not used any extra data structures, this makes space complexity, even in the worst case as O(1).
// ---------------------------------------
// Problem Statement: Given two numbers N and M, find the Nth root of M. The nth root of a number M is defined as a number X when raised to the power N equals M. If the 'nth root is not an integer, return -1.
// Example 1:
// Input Format:
//  N = 3, M = 27
// Result:
//  3
// Explanation:
//  The cube root of 27 is equal to 3.
// Example 2:
// Input Format:
//  N = 4, M = 69
// Result:
//  -1
// Explanation:
//  The 4th root of 69 does not exist. So, the answer is -1.
// ---------------------------------------
// Algorithm:
// 1. Place the 2 pointers i.e. low and high: Initially, we will place the pointers. The pointer low will point to 1 and the high will point to m.
// 2. Calculate the ‘mid’: Now, inside a loop, we will calculate the value of ‘mid’ using the following formula:
// mid = (low+high) // 2 ( ‘//’ refers to integer division)
// 3. Eliminate the halves accordingly: 
// 3.1. If func(n, m, mid) == 0: On satisfying this condition, we can conclude that the number ‘mid’ is our answer. So, we will return to ‘mid’.
// 3.2. If func(n, m, mid) == 1: On satisfying this condition, we can conclude that the number ‘mid’ is smaller than our answer. So, we will eliminate the left half and consider the right half(i.e. low = mid+1).
// 3.3. If func(n, m, mid) == 2: the value mid is larger than the number we want. This means the numbers greater than ‘mid’ will not be our answers and the right half of ‘mid’ consists of such numbers. So, we will eliminate the right half and consider the left half(i.e. high = mid-1).
// 4. Finally,  if we are outside the loop, this means no answer exists. So, we will return -1.
// The steps from 2-3 will be inside a loop and the loop will continue until low crosses high.
