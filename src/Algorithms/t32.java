package Algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class t32 {
    //栈实现
    public static int longestValidParentheses_StackVersion(String s) {
        if (s.length() <= 1)
            return 0;
        Stack<Integer> stack = new Stack<>();
        int length = 0;
        int max = 0;
        boolean flag = false;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {

//            if (flag) {
//                //情况一：后面跟的都是()
//                if (i + 1 <= s.length() - 1 && s.charAt(i) == '(' && s.charAt(i + 1) == ')') {
//                    ++i;
//                    ++length;
//                } else if (!stack.isEmpty() && stack.peek() == '(' && s.charAt(i) == ')') {
//                    //情况二：是(())嵌套形式
//                    ++length;
//                    stack.pop();
//                } else {
//                    flag = false;
//                    max = Math.max(length, max);
//                    length = 0;
//                }
//            } else {
//                stack.push(s.charAt(i));
//                if (i < s.length() - 1 && stack.peek() == '(' && s.charAt(i + 1) == ')') {
//                    stack.pop();
//                    ++i;
//                    ++length;
//                    max = length;
//                    flag = true;
//                }
//            }

            if (s.charAt(i) == '(')
                stack.push(i);
            else if (s.charAt(i) == ')') {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }


        }
        return Math.max(length, max);
    }

    //动态规划
    public static int longestValidParentheses_DpVersion(String s) {
        int max = 0;
        int n = s.length();
        int[] dp = new int[n];
        //初始化dp数组
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    if (i >= 2)
                        dp[i] = dp[i - 2] + 2;
                    else
                        dp[i] = 2;
                } else {
                    if (i >= 2 && i - dp[i - 1] - 2 >= 0 && s.charAt(dp[i - dp[i - 1] - 1]) == '(')
                        dp[i] = dp[i - dp[i - 1] - 2] + dp[i - 1] + 2;
                    else
                        dp[i] = 0;
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }


    public static void main(String[] args) {
//        System.out.println(longestValidParentheses_StackVersion("()(())"));
        System.out.println(longestValidParentheses_DpVersion("((())"));
    }
}
