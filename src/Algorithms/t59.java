package Algorithms;

import java.util.Arrays;

public class t59 {
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int left = 0;
        int top = 0;
        int right = n - 1;
        int bottom = n - 1;
        int count = 1;
        while (left <= right && top <= bottom) {

            for (int i = left; i <= right; i++)
                matrix[top][i] = count++;
            ++top;

            for (int i = top; i <= bottom; i++)
                matrix[i][right] = count++;
            --right;

            for (int i = right; i >= left; i--)
                matrix[bottom][i] = count++;
            --bottom;

            for (int i = bottom; i >= top; i--)
                matrix[i][left] = count++;
            ++left;
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] ints = generateMatrix(1);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }
}
