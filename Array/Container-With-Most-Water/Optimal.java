class Solution {
    public static int container_with_most_water(int[] arr) {
        int i = 0, j = arr.length - 1;
        int minHeight, store, maxStore = Integer.MIN_VALUE;

        while(i < j) {
            minHeight = Math.min(arr[i], arr[j]);
            store = minHeight * (j - i);
            maxStore = Math.max(store, maxStore);
            if(arr[i] < arr[j]) i++;
            else j--;
        }

        return maxStore;
    }
}

public class Optimal {
    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        int ans = Solution.container_with_most_water(arr);
        System.out.println("container_with_most_water: "+ans);
    }
}

// TC: O(n)
// SC: O(1)
