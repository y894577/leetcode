package Algorithms;

public class t67 {
    public static String addBinary(String a, String b) {
        StringBuffer string = new StringBuffer();
        if (a.length() < b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }
        int j = b.length() - 1;
        int carry = 0;
        for (int i = a.length() - 1; i >= 0; i--) {
            int num = a.charAt(i) - '0' + (j >= 0 ? b.charAt(j) - '0' : 0) + carry;
            carry = num / 2;
            string.append(num % 2);
            j--;
        }
        if (carry != 0)
            string.append(carry);
        string.reverse();
        return string.toString();
    }

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        System.out.println(addBinary(a, b));
    }
}
