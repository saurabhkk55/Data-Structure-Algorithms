class Solution {
    static int divide(int num, int div) {
        // Edge-cases
        if (num == Integer.MIN_VALUE && div == -1) return Integer.MAX_VALUE;
        if (num == Integer.MIN_VALUE && div ==  1) return Integer.MIN_VALUE;

        int cnt = 0;
        long temp_num = Math.abs((long) num);
        long temp_div = Math.abs((long) div);

        while (temp_num >= temp_div) {
            int what_power_of_2 = 0;
            while ((temp_num - (temp_div << what_power_of_2)) >= 0) {
                what_power_of_2++;
            }
            temp_num = temp_num - (temp_div << (what_power_of_2 - 1));
            cnt = cnt + (1 << (what_power_of_2 - 1));
        }

        if (num < 0 && div <0) return cnt; // both are -ve
        else if (num < 0 || div < 0) return (-1 * cnt); // either of them is -ve
        else return cnt; // both are +ve
    }
}

public class Optimal {
    public static void main(String[] args) {
        int num = -2147483648, divide = 1;
        // int num = -2147483648, divide = -1;
        // int num = -2147483648, divide = -1;
        // int num = -2147483648, divide = 2;
        // int num = 100, divide = 3;
        // int num = 100, divide = 4;
        // int num = 22, divide = 3;
        int ans = Solution.divide(num, divide);
        System.out.println("Times: "+ ans);
    }
}

// TC: O(logbase2 n) * O(logbase2 n)
// SC: O(1)
