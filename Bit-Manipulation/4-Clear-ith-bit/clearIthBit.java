// WAP to clear (unset) a specific bit at a given position in the binary representation of a number N.

public class clearIthBit {
    public static void main(String[] args) {
        int N = 5;        // The number for which we want to clear a bit
        int checkBit = 2; // The bit position to be cleared (0-based index)

        // Create a mask with only the 'checkBit'-th bit set to 0 (invert the bit and then AND with N)
        int mask = ~(1 << checkBit); // This will create a mask with all bits set except for the 'checkBit'-th bit

        // Clear the 'checkBit'-th bit using AND bitwise operator
        int ans = (N & mask);

        // Print the original number and the number after clearing the bit
        System.out.printf("Original number: %d\n", N);
        System.out.printf("Number after clearing the bit %d: %d\n", checkBit, ans);
    }
}
