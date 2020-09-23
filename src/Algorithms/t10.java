package Algorithms;

import javax.swing.event.TreeSelectionListener;
import javax.xml.stream.FactoryConfigurationError;

public class t10 {
    public static boolean isMatch(String s, String p) {
        char[] sChar = s.toCharArray();
        char[] pChar = p.toCharArray();
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;


        //初始化dp
        for (int i = 1; i <= m; i++) {
            dp[i][0] = false;
        }

        for (int j = 1; j <= n; j++) {
            if (pChar[j - 1] == '*') {
                dp[0][j] = dp[0][j - 2];
            } else {
                dp[0][j] = false;
            }
        }


        //从右往左搜索
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (sChar[i - 1] == pChar[j - 1] || pChar[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pChar[j - 1] == '*') {
                    //前置两格，出现次数为0
                    if (dp[i][j - 2]) {
                        dp[i][j] = dp[i][j - 2];
                        //前置一格，出现次数为1
                    } else if (sChar[i - 1] == pChar[j - 2] || pChar[j - 2] == '.') {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    dp[i][j] = false;
                }

            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String s = "a";
        String p = "a*aa*";
        boolean match = isMatch(s, p);
        System.out.println(match);
    }
}
