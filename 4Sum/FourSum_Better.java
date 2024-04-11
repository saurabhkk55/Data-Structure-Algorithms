import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSum_Better {
    public static void main(String[] args) {
        // int[] arr = {-1, 0, 1, 2, -1, 4};
        // int target = 0;

        int[] arr = {4, 3, 3, 4, 4, 2, 1, 2, 1, 1}; // {-1, 0, 1, 2, -1, 4};
        int target = 9;

        int i, j, k, len=arr.length, fourth;

        Set<List<Integer>> st = new HashSet<>();

        for (i=0; i<len; i++) {
            for (j=i+1; j<len; j++) {
                Set<Integer> tempSet = new HashSet<>();
                for (k=j+1; k<len; k++) {
                    fourth = target - (arr[i]+arr[j]+arr[k]);
                    if (tempSet.contains(fourth)) {
                        List<Integer> tempList = new ArrayList<>();
                        
                        tempList.add(arr[i]);
                        tempList.add(arr[j]);
                        tempList.add(arr[k]);
                        tempList.add(fourth);
                        tempList.sort(null);
                        st.add(tempList);
                    }
                    tempSet.add(arr[k]);
                }
            }
        }
        System.out.println("Unique 4 Sum: "+st);
    }
}
