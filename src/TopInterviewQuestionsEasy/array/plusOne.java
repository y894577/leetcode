package TopInterviewQuestionsEasy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class plusOne {
    public static int[] plusOne(int[] digits) {
        int point = digits.length - 1;
        ++digits[point];
        while (digits[point] > 9) {
            if (point == 0) {
                int[] result = new int[digits.length + 1];
                result[0] = 1;
                return result;
            }
            digits[point] = 0;
            digits[--point]++;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] digits = {0};
        int[] ints = plusOne(digits);
        System.out.println(Arrays.toString(ints));
    }
}
