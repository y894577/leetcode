package CodingInterview;

public class offer49 {
    static class Solution {
        public int nthUglyNumber(int n) {
            int[] dp = new int[n + 1];
            int p2 = 0, p3 = 0, p5 = 0;
            int index = 0;
            dp[0] = 1;
            while (index < n) {
                int min = Math.min(Math.min(dp[p2] * 2, dp[p3] * 3), dp[p5] * 5);
                dp[++index] = min;
                if (min == dp[p2] * 2) p2++;
                if (min == dp[p3] * 3) p3++;
                if (min == dp[p5] * 5) p5++;
            }
            return dp[n - 1];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nthUglyNumber(10));
    }
}
