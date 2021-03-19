package CodingInterview;

public class offer56_2 {
    static class Solution {
        public int singleNumber(int[] nums) {
            // 如果一个数字出现3次，它的二进制每一位也出现的3次。
            // 如果把所有的出现三次的数字的二进制表示的每一位都分别加起来，那么每一位都能被3整除。
            // 我们把数组中所有的数字的二进制表示的每一位都加起来。
            // 如果某一位能被3整除，那么这一位对只出现一次的那个数的这一肯定为0。
            // 如果某一位不能被3整除，那么只出现一次的那个数字的该位置一定为1。
            int[] bitSum = new int[32];
            int max = 0;
            for (int num : nums) {
                int index = 0;
                while (num != 0) {
                    bitSum[index++] += (num & 1) == 1 ? 1 : 0;
                    num >>= 1;
                }
                max = Math.max(max, index);
            }
            int res = 0;
            for (int i = max; i >= 0; i--) {
                res += bitSum[i] % 3;
                if (i != 0)
                    res = res << 1;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.singleNumber(new int[]{3, 4, 3, 3}));
    }
}
