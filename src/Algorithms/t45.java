package Algorithms;

public class t45 {
    public static int jump(int[] nums) {
        int length = nums.length;
        int max = 0;
        int count = 0;
        int position = 0;
        for (int i = 0; i < length - 1; i++) {
            max = Math.max(nums[i] + i, max);
            if (position == i) {
                position = max;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1};
        System.out.println(jump(nums));
    }
}
