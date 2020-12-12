package Algorithms;

public class t74 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) return false;
        int col = matrix[0].length;
        if (col == 0) return false;
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] <= target && matrix[i][col - 1] >= target) {
                int index = i;
                int left = 0;
                int right = col - 1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (matrix[index][mid] == target)
                        return true;
                    if (matrix[index][mid] > target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[][] matrix = {
//                {1, 3, 5, 7},
//                {10, 11, 16, 20},
//                {23, 30, 34, 50}};
        int[][] matrix = {{}};
        System.out.println(searchMatrix(matrix, 9));
    }
}
