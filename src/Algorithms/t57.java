package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class t57 {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int length = intervals.length;
        List<int[]> result = new ArrayList<>();
        int n1 = newInterval[0];
        int n2 = newInterval[1];
        boolean flag = true;
        for (int i = 0; i < length; i++) {
            if (intervals[i][1] < n1) {
                int[] a = {intervals[i][0], intervals[i][1]};
                result.add(a);
            } else if (intervals[i][0] > n2) {
                if (flag) {
                    int[] a = {n1, n2};
                    result.add(a);
                    flag = false;
                }
                int[] a = {intervals[i][0], intervals[i][1]};
                result.add(a);
            } else {
                n1 = Math.min(intervals[i][0], n1);
                n2 = Math.max(intervals[i][1], n2);
            }
        }
        if (flag) {
            int[] a = {n1, n2};
            result.add(a);
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
//        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
//        int[] newInterval = {4, 8};

//        int[][] intervals = {{1, 3}, {6, 9}};
//        int[] newInterval = {2, 5};

        int[][] intervals = {{1, 5}};
        int[] newInterval = {6, 8};

        int[][] insert = insert(intervals, newInterval);
        for (int[] ints : insert) {
            System.out.println(ints[0] + " " + ints[1]);
        }
    }
}
