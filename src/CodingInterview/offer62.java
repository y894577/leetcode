package CodingInterview;

public class offer62 {
    class Solution {
        public int lastRemaining(int n, int m) {
            int f = 0;
            // 约瑟夫问题为f(m,n)
            // 删除的第 m % n 个数字
            // 序列长度变为 n - 1
            // 长度为n的序列，应当从
            return f(m, n);
        }

        public int f(int n, int m) {
            // 长度为 1 删除第 0 个元素
            if (n == 1)
                return 0;
            // 长度为 n - 1 删除第 x 个元素
            // 然后环从第 x + 1 个元素开始
            int x = f(n - 1, m);
            // 长度为 n 的序列最后一个删除的元素
            // 从 m % n 开始数的第 x 个元素
            // f(n, m) = (m % n + x) % n = (m + x) % n
            // 从第 x 个元素开始，
            return (m + x) % n;
        }

    }
}
