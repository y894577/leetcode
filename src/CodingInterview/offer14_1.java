package CodingInterview;

public class offer14_1 {
    class Solution {
        // 数学推导 时间O(1)，空间O(1)
        // ① 当所有绳段长度相等时，乘积最大。
        // ② 最优的绳段长度为 3 。
        // 任何大于1的数都可由2和3相加组成（根据奇偶证明）
        // 因为2*2=1*4，2*3>1*5, 所以将数字拆成2和3，能得到的积最大
        // 当n=4，或b=1时，4=2+2=1+3，2-2比1-3更优
        public int cuttingRope(int n) {
            if (n == 2 || n == 3)
                return n - 1;
            int a = n / 3;
            int b = n % 3;
            if (b == 0) return (int) Math.pow(3, a);
            if (b == 1) return (int) Math.pow(3, a - 1) * 4;
            else return (int) (Math.pow(3, a) * 2);
        }


        // 动态规划 时间O(n^2)，空间O(n)
        // dp[i]代表长度为i的绳子所构成乘积的最大值
        public int cuttingRope2(int n) {
            int[] dp = new int[n + 1];
            dp[1] = 1;
            //当 i≥2 时，假设对正整数 i 拆分出的第一个正整数是 j（1≤j<i），则有以下两种方案：
            //将 i 拆分成 j 和 i−j 的和，且 i−j 不再拆分成多个正整数，此时的乘积是 j×(i−j)；
            //将 i 拆分成 j 和 i−j 的和，且 i−j 继续拆分成多个正整数，此时的乘积是 j×dp[i−j]。
            for (int i = 2; i <= n; i++)
                for (int j = 1; j < i; j++)
                    dp[i] = Math.max(dp[i], Math.max(dp[i - j], i - j) * j);
            return dp[n];
        }
    }
}
