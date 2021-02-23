package Algorithms;

import java.util.Arrays;

public class t75 {
    public static void sortColors(int[] nums) {
        int red = 0, white = 0, blue = 0;
        for (int i = 0; i < nums.length; i++) {
            switch (nums[i]) {
                case 0:
                    red++;
                    break;
                case 1:
                    white++;
                    break;
                case 2:
                    blue++;
                    break;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < red)
                nums[i] = 0;
            else if (i >= red && i < white + red)
                nums[i] = 1;
            else
                nums[i] = 2;
        }
    }

    public static void sortColors2(int[] nums) {
        int p0 = 0, p1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                swap(nums, i, p0);
                p0++;
                if (p0 < p1)
                    swap(nums, i, p1);
                p1++;
            }
            if (nums[i] == 1) {
                swap(nums, i, p1);
                p1++;
            }
        }
    }

    public static void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0, 2, 0, 1, 2, 1, 1, 0};
        sortColors2(nums);
        System.out.println(Arrays.toString(nums));
    }
}
