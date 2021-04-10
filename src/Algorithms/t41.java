package Algorithms;

public class t41 {
    class Solution {
        public int firstMissingPositive(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                while (nums[i] > 0 && nums[i] <= nums.length) {
                    // 防止死循环，比如 2 1 2 3 4，会无限交换下去
                    if (nums[nums[i] - 1] != nums[i]) {
                        int temp = nums[nums[i] - 1];
                        nums[nums[i] - 1] = nums[i];
                        nums[i] = temp;
                    } else
                        break;
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != i + 1)
                    return i + 1;
            }
            return nums.length + 1;
        }
    }
}
