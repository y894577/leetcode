package Algorithms2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class t77 {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        back(1, n, k, new ArrayList<>(), result);
        return result;
    }

    public static void back(int index, int n, int k, List<Integer> list, List<List<Integer>> result) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        //剪枝
        for (int i = index; i <= n - (k - list.size()) + 1; i++) {
            list.add(i);
            back(i + 1, n, k, list, result);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> combine = combine(10, 2);
        for (List<Integer> list : combine) {
            System.out.println(list.toString());
        }
    }
}
