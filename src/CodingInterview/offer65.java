package CodingInterview;

public class offer65 {
    static class Solution {
        public int add(int a, int b) {
            while (b != 0) {
                // 当两位都为1的时候进位
                // 因此用 & 运算得出进位
                int ans = a & b;
                // a b异或，当两个数都为0或1的时候才为0
                // a^b 可求无进位和
                a = a ^ b;
                // b 表示进位，如果该位都为1则需进位，即前一位需要+1，因此需要<<1
                b = ans << 1;
                // a和b进一步进行运算
                // 即两个数的无进位和和进位数进一步进行计算
                // 直到所有的进位都归0，表示没有进位，即a为所求
            }
            return a;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.add(2, 3));
    }
}

