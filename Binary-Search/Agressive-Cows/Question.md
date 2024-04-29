You are given an array 'arr' of size 'n' which denotes the position of stalls.
You are also given an integer 'k' which denotes the number of aggressive cows.
You are given the task of assigning stalls to 'k' cows such that the minimum distance between any two of them is the maximum possible.
Find the maximum possible minimum distance.

**Example 1**:
Input Format:
N = 6, k = 4, arr[] = {0,3,4,7,10,9}
Result:
3
Explanation:
The maximum possible minimum distance between any two cows will be 3 when 4 cows are placed at positions {0, 3, 7, 10}. Here the distances between cows are 3, 4, and 3 respectively. We cannot make the minimum distance greater than 3 in any ways.

**Example 2**:
Input Format:
N = 5, k = 2, arr[] = {4,2,1,3,6}
Result:
5
Explanation:
The maximum possible minimum distance between any two cows will be 5 when 2 cows are placed at positions {1, 6}.
