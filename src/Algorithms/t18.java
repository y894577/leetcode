package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class t18 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int n = nums.length;

        if (n < 4)
            return ans;

        //第一个双指针
        for (int i = 0; i <= n - 4; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j <= n - 3; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int sum = target - (nums[i] + nums[j]);
                List<List<Integer>> temp = mid(nums, sum, i, j);
                if (temp.size() != 0) {
                    for (List<Integer> integers : temp) {
                        integers.add(nums[i]);
                        integers.add(nums[j]);
                        ans.add(integers);
                    }
                }
            }
        }
        return ans;

    }

    public static List<List<Integer>> mid(int[] nums, int target, int start, int end) {
        //如果双指针在上一个双指针内部
        //那么就会发生：如果双指针内部全为一个数，由于检测重复机制，指针不断移动，但是没办法计算，则无法判断这种情况
        //因此这个双指针在上一个双指针末尾到数组末端进行检索
        int i = end + 1;
        int j = nums.length - 1;

        List<List<Integer>> r = new ArrayList<>();

        while (j > i) {
            int sum = nums[i] + nums[j];


            if (sum == target) {

                while (i < j && nums[i] == nums[i + 1])
                    i++;

                while (i < j && nums[j] == nums[j - 1])
                    j--;

                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                temp.add(nums[j]);
                r.add(temp);


                ++i;
                --j;
            }
            if (sum < target)
                ++i;
            else if (sum > target)
                --j;
        }
        return r;
    }

    public static void main(String[] args) {
        int[] nums = {4,-9,-2,-2,-7,9,9,5,10,-10,4,5,2,-4,-2,4,-9,5};
        System.out.println(fourSum(nums, -13));
    }
}
