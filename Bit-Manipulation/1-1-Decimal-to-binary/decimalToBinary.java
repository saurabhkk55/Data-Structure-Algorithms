public class decimalToBinary {
    public static void main(String[] args) {
        int N = 83;
        
        StringBuilder binary = new StringBuilder();
        while (N >= 1) {
            int remainder = N % 2;
            binary.append(remainder); // Append the remainder directly to StringBuilder
            N = N / 2;
        }
        
        binary.reverse();  // Reverse the StringBuilder to get the correct binary representation
        System.out.println("binary: " + binary);
    }
}

// Output:
// binary: 1010011
