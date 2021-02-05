package Algorithms3;

public class t122 {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0)
            return 0;
        int sum = 0;
        for (int i = 1; i < n; i++) {
            sum += Math.max(0, prices[i] - prices[i - 1]);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.printf("max = %d", maxProfit(prices));
    }
}
