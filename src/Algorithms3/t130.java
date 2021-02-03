package Algorithms3;

import java.lang.reflect.Array;
import java.util.Arrays;

public class t130 {
    public static void solve(char[][] board) {
        int n = board.length;
        if (n == 0)
            return;
        int m = board[0].length;
        for (int i = 0; i < m; i++) {
            //上边界
            if (board[0][i] == 'O')
                dfs(board, 0, i);
            //下边界
            if (board[n - 1][i] == 'O')
                dfs(board, n - 1, i);
        }
        for (int i = 0; i < n; i++) {
            //左边界
            if (board[i][0] == 'O')
                dfs(board, i, 0);
            //右边界
            if (board[i][m - 1] == 'O')
                dfs(board, i, m - 1);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == '-')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }

    }

    public static void dfs(char board[][], int x, int y) {
        int m = board[0].length;
        int n = board.length;
        if (x < 0 || x >= n || y < 0 || y >= m || board[x][y] != 'O') {
            return;
        } else {
            board[x][y] = '-';
            dfs(board, x, y - 1);
            dfs(board, x - 1, y);
            dfs(board, x, y + 1);
            dfs(board, x + 1, y);
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'X'}};
        solve(board);
        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }


    }

}
