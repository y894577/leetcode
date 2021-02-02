package Algorithms3;

public class t130 {
    public void solve(char[][] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            //上边界
            if (board[0][i] == 'O')
                dfs(board, 0, i);
            //左边界
            if (board[i][0] == 'O')
                dfs(board, i, 0);
            //下边界
            if (board[n - 1][i] == 'O')
                dfs(board, n - 1, i);
            //右边界
            if (board[i][n - 1] == 'O')
                dfs(board, i, n - 1);
        }
        
    }

    public void dfs(char board[][], int x, int y) {
        int n = board.length;
        if (x < 0 || x >= n || y < 0 || y >= n || board[x][y] != 'O') {
            return;
        } else {
            board[x][y] = '-';
            dfs(board, x, y - 1);
            dfs(board, x - 1, y);
            dfs(board, x, y + 1);
            dfs(board, x + 1, y);
        }
    }

}
