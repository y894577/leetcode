package Algorithms;

import java.util.*;

public class t51 {
    public static List<List<String>> solveNQueens(int n) {
        boolean[][] flag = new boolean[n][n];
        List<List<String>> result = new ArrayList<>();
        back(n, 0, flag, new ArrayList<>(), result);
        return result;
    }

    public static void back(int n, int index, boolean[][] flag, List<String> solve, List<List<String>> result) {
        if (n == index) {
            result.add(new ArrayList<>(solve));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!flag[index][i]) {

                boolean[][] tempFlag = copy(flag, n);

                for (int j = 0; j < n; j++) {
                    //横排
                    tempFlag[index][j] = true;
                    //竖排
                    tempFlag[j][i] = true;
                    //右下角
                    if (index + j < n && i + j < n)
                        tempFlag[index + j][i + j] = true;
                    //左下角
                    if (i - j >= 0 && index + j < n)
                        tempFlag[index + j][i - j] = true;
                }
                char[] chars = new char[n];
                Arrays.fill(chars, '.');
                chars[i] = 'Q';
                solve.add(String.valueOf(chars));
                back(n, index + 1, tempFlag, new ArrayList<>(solve), result);

                //回溯
                solve.remove(solve.size() - 1);
            }
        }

    }

    public static boolean[][] copy(boolean[][] flag, int n) {
        boolean[][] tempFlag = new boolean[n][n];
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                tempFlag[j][k] = flag[j][k] ? true : false;
            }
        }
        return tempFlag;
    }

    public static void main(String[] args) {
        List<List<String>> lists = solveNQueens(4);
        for (List<String> list : lists) {
            System.out.println(list.toString());
            System.out.println("---------");
        }
    }
}
