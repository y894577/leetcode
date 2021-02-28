package CodingInterview;

public class offer15 {
    public class Solution {
        // you need to treat n as an unsigned value

        //逐位判断 时间O(log2N) 空间O(1) 其中N为最高位1所在位数
        //若 n & 1 = 0 ，则n二进制最右一位为 0 ；
        //若 n & 1 = 1 ，则n二进制最右一位为 1 。
        public int hammingWeight(int n) {
            int res = 0;
            while (n != 0) {
                res += n & 1;
                n = n >>> 1;
            }
            return res;
        }

        //n&(n-1) 时间O(M) M为二进制中1的个数
        //n&(n-1)可以消去最右边的1
        public int hammingWeight2(int n) {
            int res = 0;
            while (n != 0) {
                n = n & (n - 1);
                ++res;
            }
            return res;
        }
    }
}
