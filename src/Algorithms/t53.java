package Algorithms;

import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.Calendar;

public class t53 {
    //普通动态规划
    public static int maxSubArray(int[] nums) {
        int dp[] = new int[nums.length];
        dp = nums.clone();
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1] + nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }

    //线段树
    public static void merge(int[] nums, int start, int end, int[][] tree) {
        if (start == end) {
            Arrays.fill(tree[start], nums[start]);
            return;
        }

        int middle = (start + end) / 2;
        merge(nums, start, middle, tree);
        merge(nums, middle + 1, end, tree);

        int iSum = tree[start][3] + tree[end][3];
        int lSum = Math.max(tree[start][0], tree[start][3] + tree[end][0]);
        int rSum = Math.max(tree[end][1], tree[end][3] + tree[start][1]);
        int mSum = Math.max(Math.max(tree[start][2], tree[end][2]), tree[start][1] + tree[end][0]);

        tree[start][0] = tree[end][0] = lSum;
        tree[start][1] = tree[end][1] = rSum;
        tree[start][2] = tree[end][2] = mSum;
        tree[start][3] = tree[end][3] = iSum;

    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int[][] tree = new int[nums.length][4];

        merge(nums, 0, nums.length - 1, tree);
        for (int[] ints : tree) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
