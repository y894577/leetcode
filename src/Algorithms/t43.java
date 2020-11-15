package Algorithms;

import java.util.Arrays;

public class t43 {
    public static String multiply(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();
        int[] number = new int[l1 + l2];

        if (num1.charAt(0) == '0' || num2.charAt(0) == '0')
            return "0";

        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                int a = num1.charAt(i) - '0';
                int b = num2.charAt(j) - '0';
                int mul = a * b;
                number[i + j + 1] += mul % 10;
                number[i + j] += mul / 10;
            }
        }

        for (int i = l1 + l2 - 1; i > 0; i--) {
            if (number[i] >= 10) {
                number[i - 1] += number[i] / 10;
                number[i] = number[i] % 10;
            }
        }
        String result = "";
        for (int i = number[0] == 0 ? 1 : 0; i < l1 + l2; i++)
            result += number[i];

        return result;
    }

    public static void main(String[] args) {
        String num1 = "0";
        String num2 = "456";
        String multiply = multiply(num1, num2);
        System.out.println(multiply);
    }
}
