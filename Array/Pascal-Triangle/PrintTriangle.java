import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> find_entire_row(int row) {
        ArrayList<ArrayList<Integer>> pascal_triangle = new ArrayList<>();
        
        // r - current row
        for(int r=1; r<=row; r++) {
            ArrayList<Integer> list = new ArrayList<>();
            int num = 1;
            list.add(num);
            // c - current column
            for(int c=1; c<r; c++) {
                num = num * (r - c);
                num = num / c;
                list.add(num);
            }
            pascal_triangle.add(list);
        }
        return pascal_triangle;
    }
}

public class PrintTriangle {
    public static void main(String[] args) {
        int row = 6;
        
        Solution obj = new Solution();
        ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
        temp = obj.find_entire_row(row);
        
        System.out.println("Row "+ row + ": " + temp);
    }
}

// TC: O(row^2)
// SC: O(1) no space used

// Useful point:
// Each row has rowTH elements. For ex: rwo 1 has 1 elemenet, row 2 has 2 elements, llly row 6 has 6 elements.

// For example
// To find element at 6th row and 4th column then just find the value of 5C3
// 5C3 equivalent to (5 * 4 * 3)/(1 * 2 * 3)
