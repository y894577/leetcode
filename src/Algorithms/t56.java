package Algorithms;

import java.util.ArrayList;
import java.util.List;

public class t56 {
    public static int[][] merge(int[][] intervals) {
        int length = intervals.length;
        List<int[]> result = new ArrayList<>();
        int start = 0;
        int end = 0;
        for (int i = 1; i <= length; i++) {
            if (i != length && intervals[i - 1][1] >= intervals[i][0])
                ++end;
            else {
                int[] a = {intervals[start][0], intervals[end][1]};
                result.add(a);
                start = ++end;
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge = merge(nums);
        for (int i = 0; i < merge.length; i++) {
            System.out.println(merge[i][0] + " " + merge[i][1]);
        }

    }
}
