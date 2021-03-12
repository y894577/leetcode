package CodingInterview;

public class offer42 {
    static class Solution {
        public int maxSubArray(int[] nums) {
            int[] dp = new int[nums.length + 1];
            dp[0] = nums[0];
            int max = nums[0];
            for (int i = 1; i <= nums.length; i++) {
                dp[i] = Math.max(nums[i] + dp[i - 1], nums[i - 1]);
                max = Math.max(dp[i], max);
            }
            return max;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    }
}
