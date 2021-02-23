package Algorithms2;

import java.lang.annotation.ElementType;

public class t91 {
    public static int numDecodings(String s) {
        int n = s.length();
        int[] array = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = s.charAt(i) - '0';
        if (array[0] == 0)
            return 0;
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i == 0 || i == 1)
                dp[i] = 1;
            else {
                if (array[i - 2] == 0) {
                    if (array[i - 1] == 0)
                        return 0;
                    else
                        dp[i] = dp[i - 1];
                } else if (array[i - 2] == 1) {
                    if (array[i - 1] == 0)
                        dp[i] = dp[i - 2];
                    else
                        dp[i] = dp[i - 2] + dp[i - 1];
                } else if (array[i - 2] == 2) {
                    if (array[i - 1] > 0 && array[i - 1] <= 6) {
                        dp[i] = dp[i - 2] + dp[i - 1];
                    } else if (array[i - 1] == 0)
                        dp[i] = dp[i - 2];
                    else
                        dp[i] = dp[i - 1];
                } else {
                    if (array[i - 1] == 0)
                        return 0;
                    else
                        dp[i] = dp[i - 1];
                }

            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        String s = "230";
        System.out.println(numDecodings(s));
    }
}
