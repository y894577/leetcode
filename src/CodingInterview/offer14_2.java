package CodingInterview;

public class offer14_2 {
    static class Solution {
        // 答案需要取模 1e9+7（1000000007）
        // 如计算初始结果为：1000000008，请返回 1。

        //循环求余
        //时间复杂度 O(N) ： 其中 N=a ，即循环的线性复杂度。
        public int cuttingRope(int n) {
            if (n == 2 || n == 3)
                return n - 1;
            int a = n / 3;
            int b = n % 3;
            long result = 1;
            for (int i = 0; i < a - 1; i++) {
                result = (result * 3) % 1000000007;
            }
            if (b == 0) return (int) (result * 3 % 1000000007);
            if (b == 1) return (int) (result * 4 % 1000000007);
            else return (int) (result * 6 % 1000000007);
        }


        // 二分求余法 时间O(log2N)
        // x^a % p = (x^2)^(a/2) % p = (x^2%p)^(a/2) % p
        public int cuttingRope2(int n) {
            if (n == 2 || n == 3)
                return n - 1;
            int a = n / 3 - 1;
            int b = n % 3;
            long x = 3;
            long result = 1;
            while (a > 0) {
                if (a % 2 == 1)
                    result = (result * x) % 1000000007;
                x = (x * x) % 1000000007;
                a /= 2;
            }
            if (b == 0) return (int) (result * 3 % 1000000007);
            if (b == 1) return (int) (result * 4 % 1000000007);
            else return (int) (result * 6 % 1000000007);
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(solution.cuttingRope(127));
        }
    }


}
