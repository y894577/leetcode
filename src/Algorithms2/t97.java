package Algorithms2;

public class t97 {
    static class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            // 动态规划
            boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
            dp[0][0] = true;

            if (s1.length() + s2.length() != s3.length())
                return false;

            // dp[i][j] 表示s1的前 i 个元素和s2的前 j 个元素是否匹配s3的前 i + j 个元素
            for (int i = 0; i <= s1.length(); i++) {
                for (int j = 0; j <= s2.length(); j++) {
                    int index = i + j - 1;
                    //dp[i][j] || ... 只要满足当前取i或者取j的情况即可
                    if (i > 0)
                        // 取决于s1的前 i - 1 个元素和s2的前j个元素
                        dp[i][j] = dp[i][j] || dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(index);
                    if (j > 0)
                        // 取决于s1的前 i 个元素和s2的前 j - 1 个元素
                        dp[i][j] = dp[i][j] || dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(index);
                }
            }
            return dp[s1.length()][s2.length()];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println(solution.isInterleave(s1, s2, s3));
    }
}
