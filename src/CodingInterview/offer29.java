package CodingInterview;

import java.util.Arrays;

public class offer29 {
    static class Solution {
        public int[] spiralOrder(int[][] matrix) {
            if (matrix.length == 0)
                return new int[0];
            int row = matrix.length;
            int col = matrix[0].length;
            int[] list = new int[row * col];
            int index = 0;
            int left = 0, right = col - 1, top = 0, bottom = row - 1;
            while (true) {
                //从左往右
                for (int i = left; i <= right; i++)
                    list[index++] = matrix[top][i];
                if (++top > bottom)
                    break;
                //从上往下
                for (int i = top; i <= bottom; i++)
                    list[index++] = matrix[i][right];
                if (--right < left)
                    break;
                //从右往左
                for (int i = right; i >= left; i--)
                    list[index++] = matrix[bottom][i];
                if (--bottom < top)
                    break;
                //从下往上
                for (int i = bottom; i >= top; i--)
                    list[index++] = matrix[i][left];
                if (++left > right)
                    break;
            }
            return list;
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            int[][] matrix = {
                    {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12}};
            System.out.println(Arrays.toString(solution.spiralOrder(matrix)));
        }
    }
}
