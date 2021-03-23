package CodingInterview;

public class offer63 {
    static class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length == 0)
                return 0;
            // 最大利润
            int result = 0;
            // 跌到最低的价格
            int min = prices[0];
            for (int i = 1; i < prices.length; i++) {
                if (min > prices[i]) {
                    // 更新最低价格
                    min = prices[i];
                } else
                    // 前i日最大利润 = max(前(i−1)日最大利润 , 第i日价格 − 前i日最低价格)
                    result = Math.max(result, prices[i] - min);
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
