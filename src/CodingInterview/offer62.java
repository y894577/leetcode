package CodingInterview;

public class offer62 {
    class Solution {
        // 有 n 个数的时候，要划掉一个数，然后就剩 n - 1 个数
        // 那划掉的这个数，下标是(m - 1) % n
        // 假设有 n - 1 个数，剩下的数的下标为 x
        // 那么长度 n 划完了这个数，往后数 x + 1，即为 n - 1 时剩下的数
        // 则最后剩下的数的下标为 [(m - 1) % n + x + 1] % n
        // 即：f(n,m) = [f(n-1,m) + 1 + (m - 1) % n] % n =(m + f(n-1,m)) % n
        // 当 n = 1 时，x = 0
        // 然后开始递归求解

        public int lastRemaining(int n, int m) {
            // 约瑟夫问题为f(m,n)
            // 删除的第 m % n 个数字
            // 序列长度变为 n - 1
            return f(n, m);
        }

        public int f(int n, int m) {
            // 长度为 1 删除第 0 个元素
            if (n == 1)
                return 0;
            // 设长度为 n - 1 的序列最后一个删除的元素的下标为 x
            // 然后环从第 x + 1 个元素开始
            int x = f(n - 1, m);
            return (m + x) % n;
        }

    }
}
