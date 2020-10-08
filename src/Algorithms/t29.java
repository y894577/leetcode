package Algorithms;

public class t29 {
    public static int divide(int dividend, int divisor) {
        if (divisor == 0)
            return 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        boolean negative;
        negative = (dividend ^ divisor) < 0;
        int count = 0;
        long t = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        for (int i = 31; i >= 0; --i) {
            if ((t >> i) >= d) {
                //count用来记录2^0+2^1+···+2^n 也就是商
                count += 1 << i;
                t -= d << i;
            }
        }
        return negative ? -count : count;
    }

    public static void main(String[] args) {
        System.out.println(divide(-2147483648, 1));
    }
}
