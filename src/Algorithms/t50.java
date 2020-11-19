package Algorithms;

public class t50 {
    public static double myPow(double x, long n) {
        x = n >= 0 ? x : 1 / x;
        if (n == 0)
            return 1.0;
        double y = n >= 0 ? myPow(x, n / 2) : 1 / myPow(x, n / 2);
        if (Math.abs(n % 2) == 1)
            return x * y * y;
        else
            return y * y;

    }

    public static void main(String[] args) {

        System.out.println(myPow(34.00515, -3));
    }
}
