package Algorithms;

public class t69 {
    public static int mySqrt(int x) {
        int left = 0;
        int right = x;

        while (left <= right) {
            int n = left + (right - left) / 2;
            if ((long) n * n > x) {
                right = n - 1;
            } else if (n * n < x) {
                left = n + 1;
            } else
                return n;

        }
        return left + (right - left);
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }
}
