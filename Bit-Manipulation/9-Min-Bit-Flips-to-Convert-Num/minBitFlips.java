public class minBitFlips {
    public static void main(String[] args) {
        // Initial and goal values
        int start = 10;  // Binary: 1010
        int goal = 7;    // Binary: 0111
        
        // Calculate the XOR of start and goal to identify differing bits
        int N = start ^ goal;  // Binary: 1101
        
        int cnt = 0;  // Counter to track the number of bit flips
        
        // Count the number of 1s in the binary representation of N
        while (N >= 1) {
            N = N & (N - 1);  // Clear the least significant bit set to 1
            cnt++;            // Increment the count for each cleared bit
        }
        
        // Output the result
        System.out.printf("Minimum number of bit flips required to convert %d into %d is: %d", start, goal, cnt);
    }
}
