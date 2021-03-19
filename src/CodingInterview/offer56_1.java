package CodingInterview;

public class offer56_1 {
    class Solution {
        public int[] singleNumbers(int[] nums) {
            // x表示对每个数进行异或
            // 根据异或的运算性质，x的最终结果为两个只出现一次的数的异或结果
            int x = 0;
            for (int i = 0; i < nums.length; i++)
                x ^= nums[i];

            // 获取res最低位的1
            int flag = x & (-x);

            // 假设两个数为A B
            // x = A^B
            // 只需要获取到x为1的地方就可以开始划分数组
            int res = 0;

            for (int i = 0; i < nums.length; i++) {
                if ((nums[i] & flag) != 0)
                    // 相同的数会异或消除
                    // A B中只会有一个和res进行异或
                    res ^= nums[i];
            }

            int[] arr = new int[]{res, x ^ res};
            return arr;

        }
    }
}
