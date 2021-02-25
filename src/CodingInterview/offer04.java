package CodingInterview;

public class offer04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;
        //行数
        int row = matrix.length;
        //列数
        int col = matrix[0].length;
        //x 行 y 列
        int x = row - 1, y = 0;
        while (x >= 0 && y < col) {
            if (matrix[x][y] == target)
                return true;
            else if (matrix[x][y] < target)
                y++;
            else
                x--;
        }
        return false;
    }
}
