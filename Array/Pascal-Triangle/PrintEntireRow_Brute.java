import java.util.*;

class Solution {
    public int find_element(ArrayList<ArrayList<Integer>> pascal_triangle, int row, int col) {
        int num = 1;
        
        for(int i=1; i<col; i++) {
            num = num * (row-i);
            num = num / i;
        }
        return num;
    }
    
    public ArrayList<Integer> find_entire_row(ArrayList<ArrayList<Integer>> pascal_triangle, int row) {
        ArrayList<Integer> ans_list = new ArrayList<>();
        for(int i=1; i<=row; i++) {
            int num = find_element(pascal_triangle, row, i);
            ans_list.add(num);
        }
        return ans_list;
    }
}

public class PrintEntireRow_Brute {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> pascal_triangle = new ArrayList<>();
        
        // Row 1
        ArrayList<Integer> temp1 = new ArrayList<>();
        temp1.add(1);
        pascal_triangle.add(temp1);
        
        // Row 2
        ArrayList<Integer> temp2 = new ArrayList<>();
        temp2.addAll(Arrays.asList(1, 1));
        pascal_triangle.add(temp2);
        
        // Row 3
        ArrayList<Integer> temp3 = new ArrayList<>();
        temp3.addAll(Arrays.asList(1, 2, 1));
        pascal_triangle.add(temp3);
        
        // Row 4
        ArrayList<Integer> temp4 = new ArrayList<>();
        temp4.addAll(Arrays.asList(1, 3, 3, 1));
        pascal_triangle.add(temp4);
        
        // Row 5
        ArrayList<Integer> temp5 = new ArrayList<>();
        temp5.addAll(Arrays.asList(1, 4, 6, 4, 1));
        pascal_triangle.add(temp5);
        
        // Row 6
        ArrayList<Integer> temp6 = new ArrayList<>();
        temp6.addAll(Arrays.asList(1, 5, 10, 10, 5, 1));
        pascal_triangle.add(temp6);
        
        System.out.println(pascal_triangle);
        
        int row = 3;
        
        Solution obj = new Solution();
        ArrayList<Integer> temp = new ArrayList<>();
        temp = obj.find_entire_row(pascal_triangle, row);
        
        System.out.println("Row "+ row + ": " + temp);
    }
}

// TC: O(row)
// SC: O(1) no space used

// Useful point:
// Each row has rowTH elements. For ex: rwo 1 has 1 elemenet, row 2 has 2 elements, llly row 6 has 6 elements.

// For example
// To find element at 6th row and 4th column then just find the value of 5C3
// 5C3 equivalent to (5 * 4 * 3)/(1 * 2 * 3)
