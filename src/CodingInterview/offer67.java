package CodingInterview;

public class offer67 {
    static class Solution {
        public int strToInt(String str) {
            str = str.trim();
            char[] chars = str.toCharArray();
            int i = 0;
            int sign = 1;
            if (chars[i] == '-') {
                sign = -1;
                i++;
            } else if (chars[i] == '+')
                i++;

            long res = 0;
            while (i < chars.length) {
                if (chars[i] < '0' || chars[i] > '9')
                    return (int) res * sign;
                res = res * 10 + chars[i] - '0';
                if (sign == 1 && res > Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
                else if (sign == -1 && -res < Integer.MIN_VALUE)
                    return Integer.MIN_VALUE;
                i++;
            }
            return (int) res * sign;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strToInt("  -0012a42"));
    }
}
