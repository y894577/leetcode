package CodingInterview;

public class offer64 {
    static class Solution {
        public int sumNums(int n) {
            // 对于 A && B 这个表达式，如果 A 表达式返回False
            // 那么 A && B 已经确定为 False ，此时不会去执行表达式 B

            // 对于 A || B 这个表达式，如果 A 表达式返回 True
            // 那么 A || B 已经确定为 True ，此时不会去执行表达式 B

            //boolean flag = n > 0 && (n += sumNums(n - 1)) > 0;
            boolean flag = n <= 0 || (n += sumNums(n - 1)) <= 0;
            return n;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sumNums(9));
    }
}
