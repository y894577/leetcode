package CodingInterview;

public class offer10_1 {
    //递归 时间复杂度O(2^n) 不可取
    public int fib(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return fib(n - 1) + fib(n - 2);
    }

    //动态规划 时间复杂度O(n)
    public int fib2(int n) {
        //由于 dp 列表第 i 项只与第 i−1 和第 i−2 项有关
        // 因此只需要初始化三个整形变量 sum, a, b
        // 利用辅助变量 sum 使 a,b 两数字交替前进即可
        int a = 0, b = 1;
        int sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
