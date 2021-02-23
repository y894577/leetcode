package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class t39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> total = new ArrayList<>();
        back(0, candidates, target, list, total);
        return total;
    }

    public static void back(int n, int[] candidates, int target, List<Integer> list, List<List<Integer>> total) {
        int length = candidates.length;

        if (n >= length)
            return;

        if (target == 0) {
            total.add(new ArrayList<>(list));
            return;
        }

        for (int i = n; i < length; i++) {
            if (target < 0)
                break;
            list.add(candidates[i]);
            //选择当前candidates[n]，target改变，n不变
            //可以重复选择candidates[n]中的数
            back(i, candidates, target- candidates[i], list, total);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> lists = combinationSum(candidates, target);
        for (List<Integer> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }
}
