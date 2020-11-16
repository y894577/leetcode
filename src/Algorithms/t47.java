package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class t47 {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean[] choose = new boolean[nums.length];
        back(res, list, choose, nums, 0);
        return res;
    }

    public static void back(List<List<Integer>> res, List<Integer> list, boolean[] choose, int[] nums, int count) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (!choose[i]) {
                if (i != n - 1 && nums[i] == nums[i + 1] && !choose[i + 1])
                    continue;
                list.add(nums[i]);
                choose[i] = true;
                back(res, new ArrayList<>(list), choose, nums, count + 1);
                choose[i] = false;
                list.remove(list.size() - 1);
            }
        }
        if (count == n)
            res.add(list);
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        List<List<Integer>> permute = permuteUnique(nums);
        for (List<Integer> list : permute) {
            System.out.println(list.toString());
        }
    }
}
