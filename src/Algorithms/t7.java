package Algorithms;

public class t7 {
    public static int reverse(int x) {
        int max = 0x7fffffff;
        int min = 0x80000000;

        long num = 0;

        while (x != 0) {
            num *= 10;
            num += x % 10;
            x = x / 10;
            if (num > max || num < min)
                return 0;
        }
        return (int) num;
    }

    public static void main(String[] args) {
        System.out.println(reverse(120));
    }
}
