package TopInterviewQuestionsEasy.array;

import java.util.Arrays;

public class moveZeroes {
    public static void moveZeroes(int[] nums) {
        int p1 = 0;
        int p2 = p1 + 1;
        while (p2 < nums.length && p1 < nums.length) {
            if (nums[p1] == 0) {
                if (nums[p2] != 0) {
                    int temp = nums[p1];
                    nums[p1] = nums[p2];
                    nums[p2] = temp;
                    p1++;
                    p2 = p1 + 1;
                } else
                    p2++;
            } else {
                p1++;
                p2 = p1 + 1;
            }

        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 4, 0, 0, 3, 0, 5, 1, 0};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
