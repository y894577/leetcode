package Algorithms;

import java.util.HashMap;
import java.util.Map;

public class t12 {
    public static String intToRoman(int num) {
        int[] number = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] chars = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        String str = "";

        for (int i = 0; i < number.length; i++) {
            while (num >= number[i]) {
                num = num - number[i];
                str += chars[i];
            }
        }

        return str;
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }
}
