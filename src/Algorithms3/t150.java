package Algorithms3;

import java.util.Stack;

public class t150 {
    static class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<>();
            for (String token : tokens) {
                int a, b, c;
                switch (token) {
                    case "+":
                        a = stack.pop();
                        b = stack.pop();
                        c = a + b;
                        stack.push(c);
                        break;
                    case "-":
                        a = stack.pop();
                        b = stack.pop();
                        c = b - a;
                        stack.push(c);
                        break;
                    case "*":
                        a = stack.pop();
                        b = stack.pop();
                        c = a * b;
                        stack.push(c);
                        break;
                    case "/":
                        a = stack.pop();
                        b = stack.pop();
                        c = b / a;
                        stack.push(c);
                        break;
                    default:
                        stack.push(Integer.valueOf(token));
                }
            }
            return stack.pop();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] tokens = {"4", "13", "5", "/", "+"};
        solution.evalRPN(tokens);
    }
}
