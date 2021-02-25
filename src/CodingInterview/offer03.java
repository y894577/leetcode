package CodingInterview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class offer03 {
    //原地交换，时间O(n)，空间O(1)
    public int findRepeatNumber2(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) {
                i++;
                continue;
            }
            if (nums[nums[i]] == nums[i])
                return nums[i];
            int temp = nums[i];
            nums[i] = nums[temp];
            nums[temp] = temp;
        }
        return -1;
    }


    //时间O(n)，空间O(n)，利用set
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]))
                return nums[i];
            else
                set.add(nums[i]);
        }
        return -1;
    }

    public static void main(String[] args) {
        offer03 solution = new offer03();
        int[] nums = {0, 1};
        System.out.println(solution.findRepeatNumber2(nums));
    }
}
