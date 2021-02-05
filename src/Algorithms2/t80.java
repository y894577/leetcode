package Algorithms2;

public class t80 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return 1;
        int count = 1;
        int p = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[p] == nums[i]) {
                if (count < 2) {
                    nums[++p] = nums[i];
                    ++count;
                }
            } else {
                nums[++p] = nums[i];
                count = 1;
            }
        }
        return p + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};

        t80 solution = new t80();
        int i = solution.removeDuplicates(nums);
        System.out.println(i);
    }
}
