# [56](https://leetcode.com/problems/merge-intervals/description/). `Merge Intervals`

```java
class Solution {
    public List<List<Integer>> generate_merge_list_as_list(int[][] arr) {
        // Sort a nested array by the first element of each sub-array
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<List<Integer>> ans = new ArrayList<>();
        
        List<Integer> temp = new ArrayList<>();
        temp.add(arr[0][0]);
        temp.add(arr[0][1]);
        
        ans.add(temp);
        
        int rows = arr.length;
        
        for(int i=1; i<rows; i++) {
            List<Integer> temp_ans = new ArrayList<>();
            
            int curr_first = arr[i][0];
            int curr_second = arr[i][1];
            
            int size = ans.size() - 1;
            int prev_first = ans.get(size).get(0);
            int prev_second = ans.get(size).get(1);
            
            if(curr_first <= prev_second) {
                if(curr_second > prev_second) {
                    ans.get(size).set(1, curr_second);
                }
            } else {
                temp_ans.add(curr_first);
                temp_ans.add(curr_second);
                ans.add(temp_ans);
            }
        }
        return ans;
    }
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> ans_list;
        ans_list = generate_merge_list_as_list(intervals);
        
        // Convert Nested-ArrayList into 2D-Array
        int[][] ans_arr = new int[ans_list.size()][2];
        for(int i=0; i<ans_list.size(); i++) {
            ans_arr[i][0] = ans_list.get(i).get(0);
            ans_arr[i][1] = ans_list.get(i).get(1);
        }
        
        return ans_arr;
        
    }
}
```

## `Algorithm`

## 1. `Method: merge`

1. **Generate Merged List**:
   - Call `generate_merge_list_as_list` with the input `intervals` to get the merged intervals list `ans_list`.

2. **Convert List to 2D Array**:
   - Initialize a new 2D array `ans_arr` with the size of `ans_list`.
   - Loop through `ans_list` and copy each interval to `ans_arr`.

3. **Return the 2D Array**:
   - Return `ans_arr`.

## 2. `Method: generate_merge_list_as_list`

1. **Sort the Intervals**:
   - Sort the 2D array `arr` by the first element of each sub-array using `Arrays.sort` with a custom comparator.

2. **Initialize the Result List**:
   - Create a list `ans` to store the merged intervals.
   - Initialize a temporary list `temp` with the first interval from the sorted array.
   - Add `temp` to `ans`.

3. **Merge Intervals**:
   - Loop through the rest of the intervals starting from the second interval (index 1).
   - For each interval:
     - Extract the current interval's first and second elements (`curr_first` and `curr_second`).
     - Retrieve the last interval in the `ans` list (`prev_first` and `prev_second`).
     - Check if the current interval overlaps with the last interval in `ans`:
       - If `curr_first` is less than or equal to `prev_second`, they overlap:
         - Update the end of the last interval in `ans` to the maximum of `prev_second` and `curr_second`.
       - If they do not overlap, create a new interval and add it to `ans`.

4. **Return the Merged List**:
   - Return the merged intervals list `ans`.

