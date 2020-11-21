package Algorithms;

import java.util.ArrayList;
import java.util.List;

public class t54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix[0].length;
        int n = matrix.length;
        List<Integer> list = new ArrayList<>();
        int left = 0, top = 0;
        int right = m - 1;
        int bottom = n - 1;
        while (left <= right && top <= bottom) {
            //上行处理
            for (int i = left; i <= right && top <= bottom; i++)
                list.add(matrix[top][i]);
            ++top;

            //右列处理
            for (int i = top; i <= bottom && right >= left; i++)
                list.add(matrix[i][right]);
            --right;

            //下行处理
            for (int i = right; i >= left && top <= bottom; i--)
                list.add(matrix[bottom][i]);
            --bottom;

            //左列处理
            for (int i = bottom; i >= top && right >= left; i--)
                list.add(matrix[i][left]);
            ++left;

        }
        return list;
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1, 2}, {3, 4}};
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrix = {{1}, {4}, {7}};
//        int[][] matrix = {{1, 2, 3}};

        List<Integer> list = spiralOrder(matrix);
        System.out.println(list.toString());
    }
}
