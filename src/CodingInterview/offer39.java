package CodingInterview;

public class offer39 {
    class Solution {
        // 摩尔投票法 时间复杂度O(N) 空间复杂度O(1)

        public int majorityElement(int[] nums) {
            int candidate = 0;
            int count = 0;
            for (int x : nums) {
                //当票votes等于0，则假设当前数字num是众数
                if (count == 0)
                    candidate = x;
                //当 num = x 时，票数votes自增1
                if (x == candidate)
                    count++;
                //当 num != x 时，票数votes自减1
                else count--;
            }
            return candidate;
        }
    }
}
