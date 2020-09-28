package Algorithms;

import sun.security.util.Length;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class t15 {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        //  双指针
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (j < nums.length - 1 && nums[j] == nums[j + 1])
                    continue;
                int sum = -1 * (nums[i] + nums[j]);
                int mid = findMid(i, j, nums, sum);
                if (mid != -1) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[mid]);
                    list.add(nums[j]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    public static int findMid(int start, int end, int[] nums, int num) {
        if (start - end == 1 || start - end == -1 || start == end)
            return -1;
        int mid = (end - start) / 2 + start;
        if (nums[mid] == num)
            return mid;
        else if (nums[mid] > num) {
            return findMid(start, mid, nums, num);
        } else {
            return findMid(mid, end, nums, num);
        }
    }

    public static void main(String[] args) {
        int[] num = {-1, -1, 2};
        System.out.println(threeSum(num));
    }
}
