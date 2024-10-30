// {9,10,1,2,3,4,2,1,1,2}

public class Test {
    public static void main(String[] args) {
        int[] arr = {9,10,1,2,3,4,2,1,1,2};
        // int[] arr = {1,2,3,4};
        int cnt = 0, max_count = 0;

        for(int i=1; i<arr.length; i++) {
            if(arr[i-1] < arr[i]) {
                cnt++;
                max_count += cnt;
            } else {
                cnt = 0;
            }
        }

        System.out.println(max_count);
    }
}