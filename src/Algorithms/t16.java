package Algorithms;

import java.util.Arrays;

public class t16 {

    //这题不能用折半查找，因为只存在最优解不存在定值
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int distance = -1;
        int total = 0;

        //  双指针
        for (int i = 0; i < nums.length; i++) {
            int mid = i + 1;
            int j = nums.length - 1;
            while (j > mid) {
                int sum = nums[i] + nums[j] + nums[mid];
                if (sum == target)
                    return target;
                if (distance == -1 || Math.abs(sum - target) < distance) {
                    total = sum;
                    distance = Math.abs(sum - target);
                }
                if (sum < target) {
                    ++mid;
                } else {
                    --j;
                }
            }
        }
        return total;
    }


    public static void main(String[] args) {
        int[] num = {0, 1, 1, 1};
        System.out.println(threeSumClosest(num, -100));
    }
}
