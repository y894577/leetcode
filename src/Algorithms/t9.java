package Algorithms;

public class t9 {
    public static boolean isPalindrome(int x) {
        boolean isPalindrome = false;
        if (x >= 0) {
            if (x % 10 == 0 && x != 0)
                return isPalindrome;
            int y = 0;
            while (x > y) {
                y *= 10;
                y += x % 10;
                x /= 10;
            }
            if (x == y || x == y / 10)
                isPalindrome = true;
        }

        return isPalindrome;
    }

    public static void main(String[] args) {
        boolean palindrome = isPalindrome(2);
        System.out.println(palindrome);
    }

}
