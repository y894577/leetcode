package Algorithms;

import java.util.Arrays;

public class t48 {
    public static void rotate(int[][] matrix) {
        int n = matrix.length - 1;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n - i; j++) {
                int temp1 = matrix[i][j];
                int temp2 = matrix[j][n - i];
                int temp3 = matrix[n - i][n - j];
                int temp4 = matrix[n - j][i];

                matrix[j][n - i] = temp1;
                matrix[n - i][n - j] = temp2;
                matrix[n - j][i] = temp3;
                matrix[i][j] = temp4;

            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        rotate(matrix);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
