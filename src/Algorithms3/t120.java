package Algorithms3;

import java.util.ArrayList;
import java.util.List;

public class t120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        //第i层 第j个元素
        //从顶部到[i][j]个元素最小路径
        int[][] dp = new int[n + 1][n + 1];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            //第一个元素的上一层只有一个元素对应
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                //从上一层相邻的两个元素中选择
                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
            }
            //最后一个元素的上一层只有一个元素对应
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }

        int min = dp[n - 1][0];
        for (int i = 1; i < n; i++) {
            min = Math.min(dp[n - 1][i], min);
        }
        return min;
    }

    public static void main(String[] args) {
        List<List<Integer>> arrayList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
    }
}
