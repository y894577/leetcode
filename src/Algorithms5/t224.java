package Algorithms5;

import java.util.Stack;

public class t224 {
    static class Solution {
        public int calculate(String s) {
            Stack<Integer> stack = new Stack<>();
            int sign = 1;
            int res = 0;
            for (int i = 0; i < s.length(); i++) {
                if (Character.isDigit(s.charAt(i))) {
                    int n = s.charAt(i) - '0';
                    while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                        n = n * 10 + (s.charAt(++i) - '0');
                    }
                    res = res + sign * n;
                } else
                    switch (s.charAt(i)) {
                        case '+':
                            sign = 1;
                            break;
                        case '-':
                            sign = -1;
                            break;
                        case '(':
                            stack.push(res);
                            res = 0;
                            stack.push(sign);
                            sign = 1;
                            break;
                        case ')':
                            res = stack.pop() * res + stack.pop();
                            break;
                    }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.calculate("9+(1+(4+5+2)-3)+(6+8)"));
    }
}
