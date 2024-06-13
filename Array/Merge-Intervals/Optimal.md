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
