package Algorithms2;

import java.util.ArrayList;
import java.util.List;

public class t78 {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        back(0, nums, result, new ArrayList<>());
        return result;
    }

    public static void back(int index, int[] nums, List<List<Integer>> result, List<Integer> list) {
        result.add(new ArrayList<>(list));
        if (nums.length == index)
            return;
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            back(index + 1, nums, result, list);
            list.remove(list.size() - 1);
            ++index;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = subsets(nums);
        for (List<Integer> subset : subsets) {
            System.out.println(subset.toString());
        }
    }
}
