package Algorithms;

public class t55 {
    public static boolean canJump(int[] nums) {
        int length = nums.length;
        int max = 0;
        for (int i = 0; i < length; i++) {
            if (i > max) return false;
            max = Math.max(i + nums[i], max);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 3};
        System.out.println(canJump(nums));
    }
}
