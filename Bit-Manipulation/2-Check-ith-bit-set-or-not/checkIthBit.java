// WAP to checks whether the specified bit position is set or not in the binary representation of the number N.

public class checkIthBit {
    public static void main(String[] args) {
        int N = 5; // The number for which we want to check the bit
        int checkBit = 2; // The bit position to check (0-based index)

        System.out.printf("USING LEFT SHIFT OPERATOR: Check if bit %d is set in the binary representation of number %d\n", checkBit, N);
        if ((N & (1 << checkBit)) != 0) {
            System.out.printf("Bit %d is set\n", checkBit);
        } else {
            System.out.printf("Bit %d is not set\n", checkBit);
        }
        
        // OR we can solve this same problem via RIGHT SHIFT OPERATOR as well
        System.out.printf("\nUSING RIGHT SHIFT OPERATOR: Check if bit %d is set in the binary representation of number %d\n", checkBit, N);
        if (((N >> checkBit) & 1) != 0) {
            System.out.printf("Bit %d is set\n", checkBit);
        }else {
            System.out.printf("Bit %d is not set\n", checkBit);
        }
    }
}
