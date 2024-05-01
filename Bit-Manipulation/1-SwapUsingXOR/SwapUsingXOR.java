public class SwapUsingXOR {
    public static void main(String[] args) {
        int a = 5;
        int b = 8;

        System.out.println("Before swapping:");
        System.out.println("a = " + a + ", b = " + b);

        // Swapping using XOR
        a = a ^ b; // Step 1: a = a ^ b (a now holds the XOR of original a and b)
        b = a ^ b; // Step 2: b = (a ^ b) ^ b (this simplifies to a because b ^ b = 0)
        a = a ^ b; // Step 3: a = (a ^ b) ^ a (this simplifies to b because a ^ a = 0)

        System.out.println("After swapping:");
        System.out.println("a = " + a + ", b = " + b);
    }
}
