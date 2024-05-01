// WAP to toggle a specific bit at a given position in the binary representation of a number N.

public class toggleIthBit {
    public static void main(String[] args) {
        int N = 8;        // The number for which we want to clear a bit
        int checkBit = 2; // The bit position to be toggled (0-based index)

        // Toggle the 'checkBit'-th bit using XOR bitwise operator with a mask
        int ans = (N ^ (1 << checkBit));

        // Print the original number and the number after toggling the bit
        System.out.printf("Original number: %d\n", N);
        System.out.printf("Number after toggling the bit %d: %d\n", checkBit, ans);
    }
}
