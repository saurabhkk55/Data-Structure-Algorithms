 // Count the number of set bits (1s) in the binary representation of an integer N 

public class countSetBits_better {
    public static void main(String[] args) {
        int N = 83;
        
        int cnt = 0;
        while (N >= 1) {
            // Traditional approach:
            // Check if the least significant bit (rightmost bit) of N is 1 (similar as checking for odd number)
            // if (N % 2 == 1) {
            //     cnt++;
            // }
            
            // Bitwise approach (equivalent to N % 2 == 1):
            // Use bitwise AND with 1 to check the last bit (N & 1)
            // if ((N & 1) == 1) {
            //     cnt++;
            // }
            
            // Compact way using bitwise addition (count number of set bits directly):
            cnt += N & 1;
            
            N = N >> 1; // same as, N = N / 2;
        }
        // Print the total number of set bits (1s) in the binary representation of N
        System.out.println("Total number of set bits are: " + cnt);
    }
}

// Note:
// The binary representaion of odd number always have the last (extreme rightmost) bit as 1
// For examples:
// Binary representaion of 19: 1 0 0 0 1
// Binary representaion of 13: 1 1 0 1
// Binary representaion of  3: 1 1

// (<odd_number> & 1) will always give 1, that is why it is same as checking for odd number via (<odd_number>%2 == 1)
// llly, (<even_number> & 1) will always give 0, that is why it is same as checking for even number via (<even_number>%2 == 1)

// O(log n) time complexity
// The while loop iterates as long as n is greater than or equal to 1. In the worst case, the loop will run log2(n) times, where log2(n) represents the number of bits required to represent n in binary.
// Bitwise operations: Inside the loop, the bitwise AND (&) operation and the right shift (>>) operation take constant time.
// Therefore, the overall time complexity is dominated by the loop, which iterates log2(n) times, resulting in O(log n) time complexity.
