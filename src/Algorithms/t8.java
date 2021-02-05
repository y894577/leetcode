package Algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;

public class t8 {

    final static int max = 0x7fffffff;
    final static int min = 0x80000000;

    //常规解法
    public static int myAtoi(String str) {
        char[] chars = str.toCharArray();
        int flag = 1;
        int cut = 0;
        for (char s : chars) {
            if (s == ' ')
                ++cut;
            else
                break;
        }

        String num = "0";
        for (int i = cut; i < str.length(); i++) {
            if (i == cut) {
                if (chars[i] == '+') {
                    flag = 1;
                } else if (chars[i] == '-') {
                    flag = -1;
                } else if (chars[i] < 48 || chars[i] > 57) {
                    //是别的字符
                    break;
                } else {
                    num += chars[0];
                }
            } else {
                if (chars[i] >= 48 && chars[i] <= 57) {
                    num += String.valueOf(chars[i]);
                    if (Long.parseLong(num) * flag >= max)
                        return max;
                    if (Long.parseLong(num) * flag <= min)
                        return min;
                } else {
                    break;
                }
            }
        }
        return Integer.parseInt(num) * flag;
    }

    //信号机解法
    static class Automaton {
        public int sign = 1;
        public long ans = 0;
        private String state = "start";
        private Map<String, String[]> table = new HashMap<String, String[]>() {{
            put("start", new String[]{"start", "signed", "in_number", "end"});
            put("signed", new String[]{"end", "end", "in_number", "end"});
            put("in_number", new String[]{"end", "end", "in_number", "end"});
            put("end", new String[]{"end", "end", "end", "end"});
        }};

        public void get(char c) {
            state = table.get(state)[get_col(c)];
            if ("in_number".equals(state)) {
                ans = ans * 10 + c - '0';
                ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
            } else if ("signed".equals(state)) {
                sign = c == '+' ? 1 : -1;
            }
        }

        private int get_col(char c) {
            if (c == ' ') {
                return 0;
            }
            if (c == '+' || c == '-') {
                return 1;
            }
            if (Character.isDigit(c)) {
                return 2;
            }
            return 3;
        }
    }

    public static void main(String[] args) {
        String str = "    +5sd4f86a";
        System.out.println(myAtoi(str));

        Automaton automaton = new Automaton();
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            automaton.get(str.charAt(i));
        }
        System.out.println((int) (automaton.sign * automaton.ans));
    }

}
