import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum_Brute {
    public static void main(String[] args) {
        int[] arr = {4, 3, 3, 4, 4, 2, 1, 2, 1, 1}; // {-1, 0, 1, 2, -1, 4};
        int target = 9;

        // int[] arr = {-1, 0, 1, 2, -1, 4};
        // int target = 0;

        int i, j, k, l, len=arr.length, sum;

        Set<List<Integer>> st = new HashSet<>();
        for (i=0; i<len; i++) {
            for (j=i+1; j<len; j++) {
                for (k=j+1; k<len; k++) {
                    for (l=k+1; l<len; l++) {
                        sum = arr[i]+arr[j]+arr[k]+arr[l];
                        if (sum == target) {
                            List<Integer> tempList = new ArrayList<>();
                            tempList.add(arr[i]);
                            tempList.add(arr[j]);
                            tempList.add(arr[k]);
                            tempList.add(arr[l]);
                            tempList.sort(null);
                            st.add(tempList);
                        }
                    }
                }
            }
        }
        System.out.println("Unique 4 Sum: "+st);
    }
}
