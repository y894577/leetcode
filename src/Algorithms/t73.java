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

    public static void setZeroes2(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean flag = false;

        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0)
                flag = true;
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < row; i++) {
            if (matrix[i][0] == 0)
                rowToZero(matrix, i, col);
        }
        for (int i = 1; i < col; i++) {
            if (matrix[0][i] == 0)
                colToZero(matrix, row, i);
        }
        if (matrix[0][0] == 0)
            rowToZero(matrix, 0, col);
        if (flag)
            colToZero(matrix, row, 0);
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 2},
                {5, 0, 7, 8},
                {0, 1, 4, 2},
                {5, 6, 9, 1}};
        setZeroes2(matrix);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
