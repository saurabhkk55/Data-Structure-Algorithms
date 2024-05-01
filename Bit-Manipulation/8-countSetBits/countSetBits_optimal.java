// Optimized approach to count the number of set bits (1s) in the binary representation of an integer N 

public class countSetBits_optimal {
    public static void main(String[] args) {
        int N = 82;

        int cnt = 0;
        while (N >= 1) {
        // Compact way using bitwise AND to efficiently count set bits:
        // - The rightmost set bit in N is flipped to 0 by ANDing with (N - 1).
        //   This effectively removes the rightmost set bit, and the loop continues
        //   until all set bits are cleared.
        N = N & (N - 1);
        cnt++;
        }

        // Print the total number of set bits (1s) in the binary representation of N
        System.out.println("Total number of set bits are: " + cnt);
    }
}


// O(no. of Set Bits) time complexity => O(31) if max value is given (Worst case)
// Worst Case time complexity if number is maximum (2's power 31) then TC will be: O(logbase2 N) => O(31)
