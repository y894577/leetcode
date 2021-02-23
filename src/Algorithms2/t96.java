package Algorithms2;

public class t96 {
    public static int numTrees(int n) {
        if (n <= 1)
            return 1;
        //代表i个数字能构成多少子树
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        //遍历前n个数
        for (int i = 2; i <= n; i++) {
            //从头开始到i开始遍历
            for (int j = 1; j <= i; j++) {
                //左边有多少子树 * 右边有多少子树
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }


    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }
}
