class Solution {
    public static int container_with_most_water(int[] arr) {
        int i = 0, j = arr.length - 1;
        int height, store, maxStore = Integer.MIN_VALUE;

        while(i < j) {
            height = Math.min(arr[i], arr[j]);
            store = height * (j - i);
            // System.out.println("store: "+store);
            if(store > maxStore) {
                maxStore = store;
            }
            if(arr[i] < arr[j]) i++;
            else j--;
        }

        return maxStore;
    }
}

public class Better {
    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        // Solution obj = new Solution();
        int ans = Solution.container_with_most_water(arr);
        System.out.println("container_with_most_water: "+ans);
    }
}

// TC: O(n)
// SC: O(1)
