package Algorithms2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class t90 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    int[] nums;
    boolean[] visit;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        this.nums = nums;
        this.visit = new boolean[n];
        Arrays.sort(this.nums);
        back(n, 0);
        return result;
    }

    public void back(int n, int index) {
        result.add(new ArrayList<>(list));
        for (int i = index; i < n; i++) {
            if (i > 0 && !visit[i - 1] && nums[i] == nums[i - 1]) {
                continue;
            }
            visit[i] = true;
            list.add(nums[i]);
            back(n, i + 1);
            visit[i] = false;
            list.remove(list.size() - 1);
        }

    }

    public static void main(String[] args) {
        t90 solution = new t90();
        int[] nums = {1, 2, 2, 2};
        List<List<Integer>> lists = solution.subsetsWithDup(nums);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }
    }
}
