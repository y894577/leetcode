package CodingInterview;

public class offer56_1 {
    class Solution {
        public int[] singleNumbers(int[] nums) {
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                res ^= nums[i];
            }
        }
    }
}
