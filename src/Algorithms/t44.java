package Algorithms;

public class t44 {
    public static boolean isMatch(String s, String p) {
        char[] sChar = s.toCharArray();
        char[] pChar = p.toCharArray();
        int m = s.length();
        int n = p.length();
        boolean dp[][] = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int i = 1; i <= m; i++) {
            dp[i][0] = false;
        }

        for (int i = 1; i <= n; i++) {
            if (pChar[i - 1] == '*')
                dp[0][i] = dp[0][i - 1];
            else
                dp[0][i] = false;

        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pChar[j] == '*') {
                    dp[i + 1][j + 1] = dp[i][j + 1] || dp[i + 1][j];
                } else if (pChar[j] == '?' || pChar[j] == sChar[i]) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    dp[i + 1][j + 1] = false;
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String s = "a";
        String p = "*";
        System.out.println(isMatch(s, p));
    }
}
