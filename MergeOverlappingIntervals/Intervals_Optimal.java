import java.util.*;

class Solution {
    public int[][] minimizeIntervals(int[][] nums) {
        int rows = nums.length;
        
        // Sort the 2D array using a custom comparator in a single line
        Arrays.sort(nums, (a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        
        List<Integer> temp = new ArrayList<>();
        temp.add(nums[0][0]);
        temp.add(nums[0][1]);
        
        List<List<Integer>> ls = new ArrayList<>();
        ls.add(temp);
        // System.out.println("LIST: "+ls);
        
        for (int i=1; i<rows; i++) {
            int end = ls.size()-1;
            if ( (nums[i][0] >= ls.get(end).get(0)) && (nums[i][0] <= ls.get(end).get(1))) {
                if (nums[i][1] > (ls.get(end).get(1))) {
                    ls.get(end).set(1, nums[i][1]);
                }
            } else {
                ls.add(Arrays.asList(nums[i][0], nums[i][1]));
            }
        }
        System.out.println("RESULT LIST: "+ls);
        
        int[][] ans = convertToArray(ls);
        return ans;
    }
    
    public static int[][] convertToArray(List<List<Integer>> nestedList) {
        int rows = nestedList.size();
        int cols = nestedList.get(0).size();
        
        int[][] array = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                array[i][j] = nestedList.get(i).get(j);
            }
        }
        
        return array;
    }
}

public class Intervals_Optimal {
    public static void main(String[] args) {
        int[][] intervals = {
                                {1, 3}, 
                                {2, 6}, 
                                {6, 7}, 
                                {8, 10}, 
                                {15, 18}
                            };
        
        // int[][] intervals = {{1,4}, {4,5}};
        // int[][] intervals = {{4, 2}, {1, 5}, {7, 8}};
        // int[][] intervals = {{4, 2}, {1, 5}, {4, 3}, {7, 8}, {4, 1}, {1, 2}};
        
        Solution solve = new Solution();
        int[][] result = solve.minimizeIntervals(intervals);
        System.out.println("RESULT ARRAY: "+Arrays.deepToString(result));
    }
}

// In this code:
// We use Arrays.sort() to sort the 2D array.
// We pass a lambda expression as the comparator, which compares the first elements of the inner arrays. If they are equal, it compares the second elements.
// The Integer.compare() method is used for comparing the elements.
