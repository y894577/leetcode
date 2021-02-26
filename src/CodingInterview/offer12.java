package CodingInterview;

public class offer12 {
    static class Solution {
        char[][] board;
        char[] str;
        //可以不使用visit
        boolean[][] visit;
        int row, col;

        public boolean exist(char[][] board, String word) {
            if (board == null || board[0] == null || board[0].length == 0 || word == null || word.equals("")) {
                return false;
            }
            this.board = board;
            //行列
            row = board.length;
            col = board[0].length;

            str = word.toCharArray();
//            visit = new boolean[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (board[i][j] == str[0])
                        if (back(i, j, 0))
                            return true;
                }
            }
            return false;
        }

        public boolean back(int x, int y, int index) {
            if (index == str.length)
                return true;
            if (x >= row || y >= col || x < 0 || y < 0 || board[x][y] == '\0' || board[x][y] != str[index]) {
                return false;
            }
            board[x][y] = '\0';
            boolean result = back(x + 1, y, index + 1)
                    || back(x - 1, y, index + 1)
                    || back(x, y - 1, index + 1)
                    || back(x, y + 1, index + 1);
            //回溯
            board[x][y] = str[index];
            return result;
        }
    }

    public static void main(String[] args) {
        char[][] chars = {{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        String str = "ABCCED";

        Solution solution = new Solution();
        solution.exist(chars, str);
    }
}
