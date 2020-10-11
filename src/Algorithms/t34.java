package Algorithms;

import java.util.Arrays;

public class t34 {
    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0)
            return new int[]{-1, -1};

        int n = nums.length;
        int min = nums.length;
        int max = -1;

        max = Math.max(binarySearch(nums, target, true), max);
        min = Math.min(binarySearch(nums, target, false), min);

        return new int[]{max, min};
    }

    public static int binarySearch(int[] nums, int target, boolean flag) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                if (flag)
                    r = mid - 1;
                else
                    l = mid + 1;

            } else if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            }
        }
        if ((l > n - 1 || (nums[l] != target)) && flag || (r < 0 || (nums[r] != target)) && !flag)
            return -1;
        return flag ? l : r;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int target = 1;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }
}
