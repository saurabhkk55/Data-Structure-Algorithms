# `Find A Peak Element`

You are given a 0-indexed 2-D grid ‘g’ of size ‘n’ X ‘m’, where each cell contains a positive integer, and adjacent cells are distinct.

You need to find the location of a peak element in it. If there are multiple answers, find any of them.

A peak element is a cell with a value strictly greater than all its adjacent cells.

Assume the grid to be surrounded by a perimeter of ‘-1s’.

You must write an algorithm that works in O(n * log(m)) or O(m * log(n)) complexity.

Note:
In the output, you will see '0' or '1', where '0' means your answer is wrong, and '1' means your answer is correct.

```
Example:
Input: 'n' = 2, 'm' = 2
'g' = [[8, 6], [10, 1]]

Output: 1
Sample Explanation: Only one peak element is present at [1, 0].
```
```
Sample Input 1:
2 2
8 6
10 1

Sample Output 1:
1       

Explanation of sample output 1:
For g = [[8,6],[10,1]],
Answer = [1,0].
There is only one peak element that is present at [1,0].
```

```
Sample Input 2:
3 3
1 2 3
4 5 6
7 8 9   

Sample Output 2:
1

Explanation of sample output 2:
For g = [[1, 2, 3], [4, 5, 6], [7, 8, 9]],
Answer = [2,2].
There is only one peak element that is present at [2,2].
Constraints:
1 <= n, m <= 500    
1 <= g[i][j] <= 10^9    
Adjacent cells are distinct.
Time Limit: 1 sec
```