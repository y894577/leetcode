package CodingInterview;

import java.util.Arrays;

public class offer61 {
    class Solution {
        // 0可以作为任意替补
        // 排序 时间O(NlogN) 其中N=5 空间O(1)
        public boolean isStraight(int[] nums) {
            Arrays.sort(nums);
            int i = 0;
            while (i != nums.length - 1 && nums[i] == 0) {
                i++;
            }
            int j = i + 1;
            while (j < nums.length) {
                if (nums[j] == nums[j - 1])
                    return false;
                ++j;
            }
            int max = nums[nums.length - 1];
            int min = nums[i];
            // max - min + 1 所需的空位
            // j - i 已经填补的空位
            // i 可以填补的0
            if (max - min + 1 <= j - i + i)
                return true;
            return false;
        }
    }
}
