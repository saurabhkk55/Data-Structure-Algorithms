import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int i, j, k, l, n = nums.length;
        long sum;

        Arrays.sort(nums);

        List<List<Integer>> ansList = new ArrayList<>();

        for (i=0; i<n; i++) {
            // Skip duplicates
            if (i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for (j=i+1; j<n; j++) {
                // Skip duplicates
                if (j-1 != i && nums[j] == nums[j-1]) {
                    continue;
                }
                k = j + 1;
                l = n - 1;

                while (k < l) {
                    sum = (long) nums[i] + nums[j] + nums[k] + nums[l];

                    if (sum == target) {
                        // Found a valid quadruplet
                        List<Integer> temp = new ArrayList<>();
                        temp.addAll(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        ansList.add(temp);

                        // Skip duplicates
                        k++;
                        while (k < l && nums[k] == nums[k-1]) {
                            k++;
                        }

                        l--;
                        while (k < l && nums[l] == nums [l+1]) {
                            l--;
                        }
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }
        return ansList;
    }
}

public class FourSu {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // int[] nums = {1, 0, -1, 0, -2, 2}; // Example input array
        // int target = 0; // Example target value

        // int[] nums = {4, 3, 3, 4, 4, 2, 1, 2, 1, 1};
        // int target = 9;

        // int[] nums = {-1, 0, 1, 2, -1, 4};
        // int target = 0;

        int[] nums = {13, -18, -1, -44, -48, -9, -16, -36, -13, 29, 17, -12, 9, -49};
        int target = 0;

        List<List<Integer>> result = solution.fourSum(nums, target);

        // Printing the result
        System.out.println("Quadruplets that sum up to target:");
        for (List<Integer> quadruplet : result) {
            System.out.println(quadruplet);
        }
    }
}
