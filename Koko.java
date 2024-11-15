// Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
// Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. 
// If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
// Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

// Return the minimum integer k such that she can eat all the bananas within h hours.
// Input: piles = [3,6,7,11], h = 8
// Output: 4 

class Koko_time {
    static double check_time_taken_by_koko_to_eat_all_bananas(int capacity, int n, int[] arr) {
        double total_time = 0;
        for(int i=0; i<n; i++) {
            if(arr[i] % capacity == 0){
                total_time += arr[i] / capacity;
            } else {
                total_time += (arr[i] / capacity) + 1;
            }
        }
        return total_time;
    }
}
public class Koko {
    // 3, 4, 5, 6, 7, 8, 9, 10, 11 => possible answers
    // 3bananas/hour => (3/3) + (6/3) + (7/3) + (11/3) => 1 + 2 + 3 + 4 => 10 hours
    

    // 11bananas/hour => (3/11) + (6/11) + (7/11) + (11/11) => 1 + 1 + 1 + 1 => 4 hours
    public static void main(String[] args) {
        int[] arr = {3,6,7,11};
        int n = arr.length;
        int max_time = arr[n-1];
        
        int low = arr[0], high = arr[n-1], mid;
        
        while(low <= high) {
            mid = (low + high)/2;
            
            int time_taken = (int) Koko_time.check_time_taken_by_koko_to_eat_all_bananas(mid, n, arr);
            
            if(time_taken < max_time) {
                max_time = time_taken;
            } else if(time_taken > max_time) high--;
            else low++;
        }
        System.out.println("ans: " + max_time);
    }
}
