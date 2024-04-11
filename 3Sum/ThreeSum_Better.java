import java.util.*;

public class ThreeSum_Better {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, 4};
        int target = 5, len = arr.length, item;
        HashSet<ArrayList<Integer>> listOf3SumArrays = new HashSet<>();

        for (int x=0; x<len; x++) {
            HashSet<Integer> hs = new HashSet<>();
            ArrayList<Integer> tempArr = new ArrayList<>();
            for (int y=x+1; y<len; y++) {
                item = target - (arr[x]+arr[y]);
                if (hs.contains(item)) {
                    tempArr.add(arr[x]);
                    tempArr.add(arr[y]);
                    tempArr.add(item);
                    Collections.sort(tempArr);
                    listOf3SumArrays.add(tempArr);
                }
                hs.add(arr[y]);
            }
        }
        System.out.println("HashSet: " + listOf3SumArrays);
    }
}