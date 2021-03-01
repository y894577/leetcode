package CodingInterview;

import java.util.HashMap;
import java.util.Map;

public class offer20 {

    // 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
    // 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，
    // 但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。


    //整数、小数、指数三部分处理
    static class Solution1 {
        //全局索引
        public static int index = 0;

        //模式
        public boolean isNumber(String s) {
            if (s.isEmpty())
                return false;
            //添加结束标识
            s += "|";
            char[] chars = s.toCharArray();
            //去除首部空格
            while (chars[index] == ' ')
                ++index;
            boolean isMatch = scanInteger(chars);
            if (chars[index] == '.') {
                ++index;

                // 使用||的原因：
                // 1、小数可以没有整数部分 .123 = 0.123
                // 2、小数点后面可以没有数字 123. = 123.0
                // 3、小数点前后都可以有数字 123.123
                isMatch = isMatch || scanUnsignedInteger(chars);
            }

            if (chars[index] == 'e' || chars[index] == 'E') {
                ++index;

                // 使用&&的原因：
                // 1、当e前面没有数字时，不能表示数字 如.E1、e1
                // 2、当e后面没有整数时，不能表示数字 如12e、12e+5.4
                isMatch = isMatch && scanInteger(chars);
            }

            //去除尾部空格
            while (chars[index] == ' ')
                ++index;
            return isMatch && chars[index] == '|';
        }

        //是否包含无符号数
        public boolean scanUnsignedInteger(char[] chars) {
            int before = index;
            while (chars[index] >= '0' && chars[index] <= '9')
                ++index;
            return index > before;
        }

        //是否包含有符号数
        public boolean scanInteger(char[] chars) {
            if (chars[index] == '+' || chars[index] == '-')
                ++index;
            return scanUnsignedInteger(chars);
        }

        public static void main(String[] args) {
            Solution1 solution = new Solution1();
            System.out.println(solution.isNumber("3"));
        }
    }


    //有限状态自动机
    class Solution2 {
        public boolean isNumber(String s) {
            //   表示   |   缩写   |   含义   |    字符
            //  black   |         |   空格   |    ' '
            //  sign    |    s    |  正负号  |    + -
            //  digit   |    d    |   数字   |    0-9
            //  dot     |    .    |  小数点  |     .
            //  e       |    e    |  幂符号  |    e E

            Map[] states = {
                    // 0.开始的空格
                    new HashMap<>() {{
                        put(' ', 0);
                        put('s', 1);
                        put('d', 2);
                        put('.', 4);
                    }},
                    // 1.幂符号前的正负号
                    new HashMap<>() {{
                        put('d', 2);
                        put('.', 4);
                    }},
                    // 2.小数点前的数字
                    new HashMap<>() {{
                        put('d', 2);
                        put('.', 3);
                        put('e', 5);
                        put(' ', 8);
                    }},
                    // 3.小数点后的数字
                    new HashMap<>() {{
                        put('d', 3);
                        put('e', 5);
                        put(' ', 8);
                    }},
                    // 4.当小数点前为空格时，小数点、小数点后的数字
                    new HashMap<>() {{
                        put('d', 3);
                    }},
                    // 5.幂符号
                    new HashMap<>() {{
                        put('s', 6);
                        put('d', 7);
                    }},
                    // 6.幂符号后的正负号
                    new HashMap<>() {{
                        put('d', 7);
                    }},
                    // 7.幂符号后的数字
                    new HashMap<>() {{
                        put('d', 7);
                        put(' ', 8);
                    }},
                    // 8.结尾的空格
                    new HashMap<>() {{
                        put(' ', 8);
                    }}
            };
            //当前状态p
            int p = 0;
            //当前字符类型
            char t;
            for (char c : s.toCharArray()) {
                if (c >= '0' && c <= '9') t = 'd';
                else if (c == '+' || c == '-') t = 's';
                else if (c == 'e' || c == 'E') t = 'e';
                else if (c == '.' || c == ' ') t = c;
                else t = '?';
                if (!states[p].containsKey(t)) return false;
                p = (int) states[p].get(t);
            }
            //当状态为2、3、7、8时才算合法结束
            return p == 2 || p == 3 || p == 7 || p == 8;
        }
    }
}
