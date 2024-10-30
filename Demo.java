// 

import java.util.HashSet;

public class Demo {
    public static void main(String[] args) {
        int[] arr = {2,1,3,2,1,0};
        int n = arr.length;

        HashSet<Integer> hs = new HashSet<>();

        for(int i=0; i<n; i++) {
            hs.add(arr[i]);
        }

        System.out.println(hs);

        

        // // int[] unique = new int[n];
        // int left = 0;

        // for(int i=left+1; i<arr.length; i++) {
        //     if(arr[left] != arr[i]) {
        //         // swapping
        //         arr[i] = arr[i-1] ^ arr[i];
        //         arr[i-1] = arr[i-1] ^ arr[i];
        //         arr[i] = arr[i-1] ^ arr[i];
        //         left++;
        //     } 
        // }
        
        // for(int j=0; j<=left+1; j++) {
        //     System.out.println(arr[j]);
        // }
    }
}
