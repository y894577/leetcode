package Algorithms2;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

public class t79 {
    char[][] board;
    String word;
    boolean[][] visit;
    int row;
    int col;

    public boolean exist(char[][] board, String word) {
        if (board.length == 0)
            return false;

        this.board = board;
        this.word = word;
        row = board.length;
        col = board[0].length;
        this.visit = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(i, j, 0))
                    return true;
            }
        }
        return false;
    }

    public boolean dfs(int i, int j, int start) {
        if (i >= row || j >= col || i < 0 || j < 0 || visit[i][j])
            return false;
        if (start + 1 == word.length() && !visit[i][j] && board[i][j] == word.charAt(start))
            return true;
        visit[i][j] = true;
        if (board[i][j] == word.charAt(start) &&
                (dfs(i + 1, j, start + 1) || dfs(i, j + 1, start + 1) ||
                        dfs(i - 1, j, start + 1) || dfs(i, j - 1, start + 1))) {
            //向下搜索
            //向右搜索
            //向上搜索
            //向左搜索
            visit[i][j] = false;
            return true;

        } else {
            visit[i][j] = false;
            return false;
        }
    }

    public static void main(String[] args) {
//        char[][] board =
//                {
//                        {'A', 'B', 'C', 'E'},
//                        {'S', 'F', 'C', 'S'},
//                        {'A', 'D', 'E', 'E'}
//                };
//
//        String word = "ABCCED";


//        char[][] board = {
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'}};
//        String word = "ABCD";

        char[][] board = {
                {'C', 'A', 'A'},
                {'A', 'A', 'A'},
                {'B', 'C', 'D'}};
        String word = "AAB";

        t79 solution = new t79();
        boolean exist = solution.exist(board, word);
        System.out.println(exist);
    }
}
