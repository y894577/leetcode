package CodingInterview;

import javax.crypto.Cipher;

public class offer43 {
    static class Solution {
        public int countDigitOne(int n) {
            // 低位的数字
            int low = 0;
            // 当前位的数字
            int cur = n % 10;
            // 高位的数字
            int high = n / 10;
            // 位因子 10^i（当前cur为第i位）
            int digit = 1;
            // 当cur = 0时，出现次数为 high * digit (相当于高位-1后变为cur=2..9情况）
            // 当cur = 1时，出现次数为 high * digit + low + 1
            // 当cur = 2,3...9时，出现次数为 (high + 1) * digit （高位不减）
            int count = 0;
            // 需要考虑个位数 因此 cur!=0
            while (high != 0 || cur != 0) {
                if (cur == 0)
                    count += high * digit;
                else if (cur == 1)
                    count += high * digit + low + 1;
                else
                    count += (high + 1) * digit;
                low = cur * digit + low;
                digit *= 10;
                cur = high % 10;
                high = high / 10;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countDigitOne(101));
    }
}
