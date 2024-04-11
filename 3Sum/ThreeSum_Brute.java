import java.util.*;

public class ThreeSum_Brute {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, 4}; //  {4, 3, 3, 4, 4, 2, 1, 2, 1, 1};  {-1, 0, 1, 2, -1, 4};
        System.out.println("arr: "+Arrays.toString(arr));
        int target = 0, len = arr.length;

        HashSet<String> listOf3SumArrays = new HashSet<>();

        for (int x = 0; x < len; x++) {
            for (int y = x + 1; y < len; y++) {
                for (int z = y + 1; z < len; z++) {
                    if (arr[x] + arr[y] + arr[z] == target) {
                        int[] tempArr = new int[3];
                        tempArr[0] = arr[x];
                        tempArr[1] = arr[y];
                        tempArr[2] = arr[z];
                        Arrays.sort(tempArr);
                        System.out.println("tempArr: " + Arrays.toString(tempArr));
                        listOf3SumArrays.add(Arrays.toString(tempArr));
                    }
                }
            }
        }
        System.out.println("HashSet: " + listOf3SumArrays);
    }
}
