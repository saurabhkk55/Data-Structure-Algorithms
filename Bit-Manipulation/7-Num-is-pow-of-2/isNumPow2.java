// WAP to determine whether a given number N is a power of 2

public class isNumPow2 {
    public static void main(String[] args) {
        int N = 8;   // Is the Number power of 2

        // Check if N is a power of 2 using bitwise AND with (N - 1)
        int ans = N & (N - 1);

        // Determine if N is a power of 2 based on the result
        if (ans == 0) {
            System.out.printf("Number %d is a power of 2", N);
        } else {
            System.out.printf("Number %d is not a power of 2", N);
        }
    }
}

// Note: If a given number is a power of 2 then it will always have only one set at the lest most position of its Binary representaion.

// Example:
// N = 32,   its Binary: 1 0 0 0 0 0
// N-1 = 31, its Binary: 0 1 1 1 1 1
// formula: N & (N-1) == 0 for a number to be power of 2
// N & (N-1):
//         1 0 0 0 0 0
//     &   0 1 1 1 1 1
//     ----------------
//         0 0 0 0 0 0  => This is how we can check a number is power of 2 or not
//     ----------------

// TRICK:
// If we have Binary of any Number let say N then Trick of finding Binary of N-1 Number is:
// - identify the rightmost set bit, toggle it and also toogle the rest all of the bits that are right of it.