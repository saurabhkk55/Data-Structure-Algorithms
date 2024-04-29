import java.util.*;

public class FindSmallestDivisorGivenThreshold_Optimal {
    public static int sumByD(int[] arr, int div) {
        int n = arr.length; //size of array
        //Find the summation of division values:
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.ceil((double)(arr[i]) / (double)(div));
        }
        return sum;
    }

    public static int smallestDivisor(int[] arr, int limit) {
        int n = arr.length; //size of array.
        if(n > limit) return -1;
        
        //Find the maximum element:
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, arr[i]);
        }
        
        int low = 1, high = maxi;
        
        //Apply binary search:
        while (low <= high) {
            int mid = (low + high) / 2;
            if (sumByD(arr, mid) <= limit) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int limit = 8;
        int ans = smallestDivisor(arr, limit);
        System.out.println("The minimum divisor is: " + ans);
    }
}

/*
Time Complexity: O(logbase2(max(arr[]))*N), where max(arr[]) = maximum element in the array, N = size of the array.
Reason: We are applying binary search on our answers that are in the range of [1, max(arr[])]. For every possible divisor ‘mid’, we call the sumByD() function. Inside that function, we are traversing the entire array, which results in O(N).
Space Complexity: O(1) as we are not using any extra space to solve this problem.
*/

/*
Problem Statement: You are given an array of integers 'arr' and an integer i.e. a threshold value 'limit'. Your task is to find the smallest positive integer divisor, such that upon dividing all the elements of the given array by it, the sum of the division's result is less than or equal to the given threshold value.

Example 1:
Input Format:
N = 5, arr[] = {1,2,3,4,5}, limit = 8
Result:
3
Explanation:
We can get a sum of 15(1 + 2 + 3 + 4 + 5) if we choose 1 as a divisor. 
The sum is 9(1 + 1 + 2 + 2 + 3)  if we choose 2 as a divisor. Upon dividing all the elements of the array by 3, we get 1,1,1,2,2 respectively. Now, their sum is equal to 7 <= 8 i.e. the threshold value. So, 3 is the minimum possible answer.

Example 2:
Input Format:
N = 4, arr[] = {8,4,2,3}, limit = 10
Result:
2
Explanation:
If we choose 1, we get 17 as the sum. If we choose 2, we get 9(4+2+1+2) <= 10 as the answer. So, 2 is the answer.

Point to remember:
While dividing the array elements with a chosen number, we will always take the ceiling value. And then we will consider their summation. For example, 3 / 2 = 2.

Observation: 
Minimum possible divisor: We can easily consider 1 as the minimum divisor as it is the smallest positive integer.
Maximum possible divisor: If we observe, we can conclude the maximum element in the array i.e. max(arr[]) is the maximum possible divisor. Any number > max(arr[]), will give the exact same result as max(arr[]) does. This divisor will generate the minimum possible result i.e. n(1 for each element), where n = size of the array.
With these observations, we can surely say that our answer will lie in the range 
[1, max(arr[])].
*/

/*
Algorithm:
1. If n > threshold: If the minimum summation i.e. n > threshold value, the answer does not exist. In this case, we will return -1.
2. Next, we will find the maximum element i.e. max(arr[]) in the given array.
3. Place the 2 pointers i.e. low and high: Initially, we will place the pointers. The pointer low will point to 1 and the high will point to max(arr[]).
4. Calculate the ‘mid’: Now, inside the loop, we will calculate the value of ‘mid’ using the following formula:
mid = (low+high) // 2 ( ‘//’ refers to integer division)
5. Eliminate the halves based on the summation of division results:
We will pass the potential divisor, represented by the variable 'mid', to the 'sumByD()' function. This function will return the summation result of the division values.
5.1. If result <= threshold: On satisfying this condition, we can conclude that the number ‘mid’ is one of our possible answers. But we want the minimum number. So, we will eliminate the right half and consider the left half(i.e. high = mid-1).
5.2. Otherwise, the value mid is smaller than the number we want. This means the numbers greater than ‘mid’ should be considered and the right half of ‘mid’ consists of such numbers. So, we will eliminate the left half and consider the right half(i.e. low = mid+1).
6. Finally, outside the loop, we will return the value of low as the pointer will be pointing to the answer.
The steps from 3-4 will be inside a loop and the loop will continue until low crosses high.

The algorithm for sumByD() is given below:
sumByD(arr[], div):
arr[] -> the given array, div -> the divisor.
1. We will run a loop to iterate over the array.
2. We will divide each element by ‘div’, and consider the ceiling value.
3. With that, we will sum up the ceiling values as well.
4. Finally, we will return the summation. 
*/
