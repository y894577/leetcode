package Algorithms;


public class t31 {
    public static void nextPermutation(int[] nums) {
        if (nums.length > 1) {
            int index = nums.length - 1;
            while (index >= 1 && nums[index - 1] >= nums[index]) {
                --index;
            }
            if (index == 0) {
                int i = 0;
                int j = nums.length - 1;
                while (i < j) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    ++i;
                    --j;
                }
            } else {
                int closeIndex = nums.length - 1;
                while (closeIndex >= index && nums[closeIndex] <= nums[index - 1]) {
                    --closeIndex;
                }

                int temp = nums[index - 1];
                nums[index - 1] = nums[closeIndex];
                nums[closeIndex] = temp;

                int i = index;
                int j = nums.length - 1;
                while (i < j) {
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    ++i;
                    --j;
                }
            }
        }


        for (int num : nums) {
            System.out.println(num + " ");
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 1};
        nextPermutation(nums);
    }
}
