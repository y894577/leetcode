package CodingInterview;

public class offer57_1 {
    class Solution {
        // 双指针 时间O(N) 空间O(1)
        public int[] twoSum(int[] nums, int target) {
            int p = 0;
            int q = nums.length - 1;
            while (p < q) {
                if (nums[q] + nums[p] > target) {
                    q--;
                } else if (nums[q] + nums[p] < target) {
                    p++;
                } else
                    return new int[]{nums[p], nums[q]};
            }
            return null;
        }
    }
}
