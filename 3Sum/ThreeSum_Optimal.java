import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ThreeSum_Optimal {
    public static void main(String[] args) {
        // int[] arr = {4, 3, 3, 4, 4, 2, 1, 2, 1, 1}; // {1, 1, 1, 2, 2, 3, 3, 4, 4, 4}
        // int target = 9;
        // int[] arr = {-1, 0, 1, 2, -1, 4}; // {-1, -1, 0, 1, 2, 4}
        int[] arr = {13, -18, -1, -44, -48, -9, -16, -36, -13, 29, 17, -12, 9, -49};
        int target = 0;
        Arrays.sort(arr);

        int start, mid, end, sum;
        Set<ArrayList<Integer>> st = new HashSet<>();

        for (int x=0; x<arr.length; x++) {
            if (x != 0 && arr[x] == arr[x-1]) {
                continue;
            }
            start = x; 
            mid = start+1;
            end = arr.length-1;

            while (mid < end) {
                sum = arr[start] + arr[mid] + arr[end];
                if (sum == target) {
                    ArrayList<Integer> tempList = new ArrayList<>();
                    tempList.add(arr[start]);
                    tempList.add(arr[mid]);
                    tempList.add(arr[end]);
                    st.add(tempList);
                    
                    mid++;
                    while (mid < end && arr[mid] == arr[mid-1]) {
                        mid++;
                    }
                    
                    end--;
                    while (mid < end && arr[end] == arr[end+1]) {
                        end--;
                    }
                } else if (sum < target) {
                    mid++;
                } else {
                    end--;
                }
            }
        }
        System.out.println(st);
    }
}

// Using while loop

// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         Arrays.sort(nums);
        
//         int left = 0, middle = left+1, right = nums.length-1;
//         List<List<Integer>> ans_list = new ArrayList<>();

//         while(left < nums.length){
//             while((left != 0) && (left < nums.length) && (nums[left] == nums[left-1])) {
//                 left++;
//             }
//             middle = left + 1;
//             right = nums.length-1;
//             while(middle < right) {
//                 int three_elem_sum = nums[left] + nums[middle] + nums[right];
//                 if(three_elem_sum == 0) {
//                     List<Integer> temp_list = new ArrayList<>();
//                     temp_list.add(nums[left]);
//                     temp_list.add(nums[middle]);
//                     temp_list.add(nums[right]);
//                     ans_list.add(temp_list);

//                     middle++;
//                     right--;

//                     while((middle < nums.length) && (nums[middle] == nums[middle-1])) {
//                         middle++;
//                     }
//                     while((right > 0) && (nums[right] == nums[right+1])) {
//                         right--;
//                     }
//                 } else if (three_elem_sum < 0) middle++;
//                 else right--;
//             }
//             left++;
//         }
//         return ans_list;
//     }
// }
