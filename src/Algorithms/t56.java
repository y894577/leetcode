package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class t56 {
    public static int[][] merge(int[][] intervals) {
        int length = intervals.length;
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] == o2[0])
                return o2[1] - o1[1];
            return o1[0] - o2[0];
        });
        int start = 0;
        int max = intervals[start][1];
        for (int i = 1; i <= length; i++) {
            max = Math.max(Math.max(intervals[start][1], intervals[i - 1][1]), max);
            if (i == length || max < intervals[i][0]) {
                int[] a = {intervals[start][0], max};
                result.add(a);
                start = i;
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
//        int[][] nums = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] nums = {{1, 4}, {4, 5}};
//        int[][] nums = {{1, 4}, {1, 5}};
//        int[][] nums = {{1, 4}, {0, 0}};
//        int[][] nums = {{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};
//        int[][] nums = {{0, 3}, {0, 1}, {0, 2}};
//        int[][] nums = {{1, 4}, {0, 2}, {3, 5}};
        int[][] merge = merge(nums);
        for (int i = 0; i < merge.length; i++) {
            System.out.println(merge[i][0] + " " + merge[i][1]);
        }

    }
}
