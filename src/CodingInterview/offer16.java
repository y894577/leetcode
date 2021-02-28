package CodingInterview;

public class offer16 {
    static class Solution {

        //快速幂（二分法） 时间O(log2n)
        public double myPow(double x, int n) {
            //n是偶数 返回1
            if (n == 0) return 1;
            //n是奇数 返回x
            if (n == 1) return x;
            //n是负数 负次方幂 返回1/x
            if (n == -1)
                return 1 / x;
            double num = myPow(x, n / 2);
            return myPow(x, n % 2) * num * num;
        }

        //快速幂（二进制法）
        public double myPow2(double x, int n) {
            long b = n;
            double res = 1.0;
            if (b < 0) {
                b = -b;
                x = 1 / x;
            }
            while (b > 0) {
                //判断n二进制最右一位是否为1
                if ((b & 1) == 1)
                    res = res * x;
                x = x * x;
                b = b >>> 1;
            }
            return res;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myPow2(3.0000, -3));
    }
}
