package CodingInterview;

public class offer19 {
    class Solution {
        public boolean isMatch(String s, String p) {
            boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
            dp[0][0] = true;
            // 空串与非空正则匹配，必须偶数全是*才能与空字符串匹配
            for (int k = 2; k <= p.length(); k += 2) {
                dp[0][k] = p.charAt(k - 1) == '*' && dp[0][k - 2];
            }
            for (int i = 1; i <= s.length(); i++) {
                for (int j = 1; j <= p.length(); j++) {
                    if (p.charAt(j - 1) != '*') {
                        if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')
                            dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        // 当前字符与*号前面的字符匹配
                        if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')
                            // dp[i - 1][j] 表示*和前面的字符匹配多次
                            // dp[i][j - 2] 表示*号不去匹配，跳过*它之前的字符
                            dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
                        else
                            dp[i][j] = dp[i][j - 2]; // 不与*之前匹配，直接跳过
                    }
                }
            }
            return dp[s.length()][p.length()];
        }
    }
}
