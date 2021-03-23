package CodingInterview;

import java.util.Arrays;

public class offer60 {
    static class Solution {
        // 动态规划
        public double[] dicesProbability(int n) {
            double[][] dp = new double[n + 1][6 * n + 1];
            // 初始化 只有一个骰子的时候每个总和的概率
            for (int i = 1; i <= 6; i++) {
                dp[1][i] = 1.0 / 6;
            }
            // dp数组记录着第i个骰子总和为j的概率

            // 当有i个骰子时
            for (int i = 2; i <= n; i++) {
                // 可能会有的总和j
                for (int j = i; j <= 6 * i; j++) {
                    // i-1个骰子的总和j-k + 当前骰子点数k = 总和j
                    for (int k = 1; k <= 6; k++) {
                        if (j - k >= 1)
                            dp[i][j] += dp[i - 1][j - k] * (1.0 / 6);
                    }
                }
            }
            return Arrays.copyOfRange(dp[n], n, dp[n].length);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.dicesProbability(3)));
    }
}
