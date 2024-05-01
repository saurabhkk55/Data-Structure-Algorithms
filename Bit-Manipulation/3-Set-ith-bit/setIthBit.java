// WAP to set a specific bit at a given position in the binary representation of a number N.

public class setIthBit {
    public static void main(String[] args) {
        int N = 8; // The number for which we want to set a bit
        int checkBit = 2; // The bit position to be set (0-based index)

        // Using OR bitwise operator to set the 'checkBit'-th bit
        int ans = (N | (1 << checkBit));

        System.out.printf("Original number: %d\n", N);
        System.out.printf("Number after setting the bit %d: %d\n", checkBit, ans);
    }
}
