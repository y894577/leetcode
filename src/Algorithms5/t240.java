package Algorithms5;

public class t240 {
    public static boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;
        int row = matrix.length - 1;//行数
        int col = 0;//列数
        boolean change = false;
        while (row >= 0 && col <= matrix[0].length - 1) {
            if (matrix[row][col] < target)
                col++;
            else if (matrix[row][col] > target)
                row--;
            else
                return true;
        }
        return false;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;
        //行数
        int row = matrix.length;
        //列数
        int col = matrix[0].length;
        int length = Math.min(col, row);

        //对角线搜索
        for (int i = 0; i < length; i++) {
            //行二分查找
            boolean a = binarySearch(i, row, matrix, target, true);
            boolean b = binarySearch(i, col, matrix, target, false);
            if (a || b)
                return true;
        }
        return false;
    }

    public static boolean binarySearch(int current, int length, int[][] matrix, int target, boolean direction) {
        int left = current;
        int right = length - 1;

        while (left <= right) {
            int mid = (right + left) / 2;
            //行搜索
            if (direction) {
                if (matrix[mid][current] < target)
                    left = mid + 1;
                else if (matrix[mid][current] > target)
                    right = mid - 1;
                else
                    return true;
            }
            //列搜索
            else {
                if (matrix[current][mid] < target)
                    left = mid + 1;
                else if (matrix[current][mid] > target)
                    right = mid - 1;
                else
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
//        int[][] matrix = {{1, 1}};
        int target = 2;
        System.out.println(searchMatrix2(matrix, target));
    }
}
