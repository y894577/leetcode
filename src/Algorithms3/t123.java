package Algorithms3;

public class t123 {
    static class Solution {

        public int maxProfit(int[] prices) {
            int buy1 = -prices[0];
            int sell1 = 0;
            int buy2 = -prices[0];
            int sell2 = 0;
            // 每一次遍历都计算两次
            // 第一次是计算遍历到此能获得的最大交易额
            // 第二次计算可以在最大交易额的基础上计算当前是否可以第二次买入
            for (int i = 0; i < prices.length; i++) {
                // 相当于 Math.min(buy1, prices[i)
                buy1 = Math.max(buy1, -prices[i]);
                sell1 = Math.max(sell1, prices[i] + buy1);
                // 考虑到第一次买卖股票的收入
                buy2 = Math.max(buy2, sell1 - prices[i]);
                sell2 = Math.max(sell2, buy2 + prices[i]);
            }
            return sell2;
        }
    }

    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 0, 1, 5};
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(prices));
    }
}
