public class removeLastSetBit {
    public static void main(String[] args) {
        int N = 12;   // The number for which we want to remove (unset) the last (rightmost) bit

        // Remove the last (rightmost) set bit using bitwise AND with (N - 1)
        int ans = N & (N - 1);

        // Print the original number and the number after clearing the bit
        System.out.printf("Original number: %d\n", N);
        System.out.printf("Number after removing (unsetting) the last (rightmost) set bit: %d\n", ans);
    }
}

// If we have Binary of any Number let say N then Trick of finding Binary of N-1 Number is:
// - identify the rightmost set bit, toggle it and also toogle the rest all of the bits that are right of it.

// Example-1
// N = 13,     Binary of 13: 1 1 0 1
// N - 1 = 12, Binary of 12: 1 1 0 0
// N & (N-1):
//           1 1 0 1
//       &   1 1 0 0
//       -------------
//           1 1 0 0  => This is how we can remove (unset) the last (rightmost) bit, formula: N & (N-1)
//       -------------

// Example-2
// N = 83,     Binary of 83: 1 0 1 0 0 1 1
// N - 1 = 82, Binary of 82: 1 0 1 0 0 1 0
// N & (N-1):
//          1 0 1 0 0 1 1
//      &   1 0 1 0 0 1 0
//      ------------------
//          1 0 1 0 0 1 0  => This is how we can remove (unset) the last (rightmost) bit, formula: N & (N-1)
//      ------------------

// Example-3
// N = 13,     Binary of 12: 1 1 0 0
// N - 1 = 12, Binary of 11: 1 0 1 1
// N & (N-1):
//         1 1 0 0
//     &   1 0 1 1
//     -------------
//         1 0 0 0  => This is how we can remove (unset) the last (rightmost) bit, formula: N & (N-1)
//     -------------
