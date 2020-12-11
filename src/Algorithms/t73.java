package Algorithms;

import java.rmi.MarshalException;
import java.util.Arrays;

public class t73 {
    public static void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[] rowArray = new boolean[row];
        boolean[] colArray = new boolean[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    rowArray[i] = true;
                    colArray[j] = true;
                }
            }
        }
        for (int i = 0; i < row; i++)
            if (rowArray[i])
                rowToZero(matrix, i, col);

        for (int j = 0; j < col; j++)
            if (colArray[j])
                colToZero(matrix, row, j);

    }

    public static void rowToZero(int[][] matrix, int row, int col) {
        for (int i = 0; i < col; i++) {
            matrix[row][i] = 0;
        }
    }

    public static void colToZero(int[][] matrix, int row, int col) {
        for (int i = 0; i < row; i++) {
            matrix[i][col] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 2},
                {5, 0, 7, 8},
                {0, 1, 4, 2},
                {5, 6, 9, 0}};
        setZeroes(matrix);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
