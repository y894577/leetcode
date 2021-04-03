package Algorithms3;

public class t115 {
    class Solution {
        public int numDistinct(String s, String t) {
            int row = t.length();
            int col = s.length();
            int[][] dp = new int[row + 1][col + 1];
            for (int i = 0; i <= col; i++) {
                dp[0][i] = 1;
            }
            for (int i = 1; i <= row; i++) {
                for (int j = 1; j <= col; j++) {
                    if (s.charAt(j - 1) == t.charAt(i - 1))
                        dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                    else
                        dp[i][j] = dp[i][j - 1];
                }
            }
            return dp[row][col];
        }
    }
}
