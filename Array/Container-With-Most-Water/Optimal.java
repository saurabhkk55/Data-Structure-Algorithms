class Solution {
    public static int container_with_most_water(int[] arr) {
        int i, j;
        int height, store, maxStore = Integer.MIN_VALUE;

        for(i=0; i<arr.length; i++) {
            for(j=0; j<arr.length; j++) {
                height = Math.min(arr[i], arr[j]);
                store = height * (j - i);
                if(store > maxStore) {
                    maxStore = store;
                }
            }
            // System.out.println(maxStore);
        }
        return maxStore;
    }
}

public class Optimal {
    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        // Solution obj = new Solution();
        int ans = Solution.container_with_most_water(arr);
        System.out.println("container_with_most_water: "+ans);
    }
}

// TC: O(n^2)
// SC: O(1)
