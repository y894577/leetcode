package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class t40 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> total = new ArrayList<>();
        back(0, candidates, target, list, total);
        return total;
    }

    public static void back(int n, int[] candidates, int target, List<Integer> list, List<List<Integer>> total) {
        int length = candidates.length;
        if (n > length)
            return;
        if (target == 0) {
            total.add(new ArrayList<>(list));
            return;
        }

        for (int i = n; i < length; i++) {
            //剪枝去除重复元素
            if (target < 0)
                break;

            //不可以重复选择candidates[n]中的数
            if (i > n && candidates[i] == candidates[i - 1])
                continue;

            list.add(candidates[i]);
            //选择当前candidates[n]，target改变
            //不可重复选择当前的i，因此i+1
            back(i + 1, candidates, target - candidates[i], list, total);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {1, 2, 1, 2, 5};
        int target = 5;
        List<List<Integer>> lists = combinationSum2(candidates, target);
        for (List<Integer> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
