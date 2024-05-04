class Solution {
    static int xor_from_1_to_N (int N) {
        if (N % 4 == 1) return 1;
        else if (N % 4 == 2) return (N + 1);
        else if (N % 4 == 3) return 0;
        else return N;
    }

    static int xor_from_start_to_end (int L, int R) {
        int xor_1 = xor_from_1_to_N(L-1);
        int xor_2 = xor_from_1_to_N(R);
        System.out.println("xor_1: "+xor_1+" xor_2: "+xor_2);
        int ans_xor = xor_1 ^ xor_2;
        
        return ans_xor;
    }
}

public class xor_from_L_to_R_Optimal {
    public static void main(String[] args) {
        int start = 5;
        int end = 8;
        int ans = Solution.xor_from_start_to_end(start, end);
        System.out.printf("XOR from %d (inclusive) to %d (inclusive): %d", start, end, ans);
    }
}

// TC: O(1)
// SC: O(1)

// |----|---------------------------------------------------|---------------------------|
// | N  | XOR from 1 to N                                   | result of XOR from 1 to N |
// |----|---------------------------------------------------|---------------------------|
// | 1  | 1 ^ 1                                             | 1                         |
// | 2  | 1 ^ 2                                             | 3                         |
// | 3  | 1 ^ 2 ^ 3                                         | 0                         |
// | 4  | 1 ^ 2 ^ 3 ^ 4                                     | 4                         |
// |----|---------------------------------------------------|---------------------------|
// | 5  | 1 ^ 2 ^ 3 ^ 4 ^ 5                                 | 1                         |
// | 6  | 1 ^ 2 ^ 3 ^ 4 ^ 5 ^ 6                             | 7                         |
// | 7  | 1 ^ 2 ^ 3 ^ 4 ^ 5 ^ 6 ^ 7                         | 0                         |
// | 8  | 1 ^ 2 ^ 3 ^ 4 ^ 5 ^ 6 ^ 7 ^ 8                     | 8                         |
// |----|---------------------------------------------------|---------------------------|
// | 9  | 1 ^ 2 ^ 3 ^ 4 ^ 5 ^ 6 ^ 7 ^ 8 ^ 9                 | 1                         |
// | 10 | 1 ^ 2 ^ 3 ^ 4 ^ 5 ^ 6 ^ 7 ^ 8 ^ 9 ^ 10            | 11                        |
// | 11 | 1 ^ 2 ^ 3 ^ 4 ^ 5 ^ 6 ^ 7 ^ 8 ^ 9 ^ 10 ^ 11       | 0                         |
// | 12 | 1 ^ 2 ^ 3 ^ 4 ^ 5 ^ 6 ^ 7 ^ 8 ^ 9 ^ 10 ^ 11 ^ 12  | 12                        |
// |----|---------------------------------------------------|---------------------------|
