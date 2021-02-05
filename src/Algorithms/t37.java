package Algorithms;

public class t37 {
    private static boolean[][] row = new boolean[9][10];
    private static boolean[][] col = new boolean[9][10];
    private static boolean[][] map = new boolean[9][10];

    public static char[][] solveSudoku(char[][] board) {
        //默认是正确数独
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = (int) board[i][j] - '0';
                    int index = (i / 3) * 3 + j / 3;
                    row[i][num] = true;
                    col[j][num] = true;
                    map[index][num] = true;
                }
            }
        }

        back(0, board);
        return board;
    }

    //回溯算法
    public static boolean back(int rowNum, char[][] board) {
        if (rowNum == 9) {
            return true;
        }
        int colNum = -1;
        for (int i = 0; i < 9; i++) {
            if (board[rowNum][i] == '.') {
                colNum = i;
                break;
            }
        }
        if (colNum == -1) {
            return back(rowNum + 1, board);
        }

        int index = (rowNum / 3) * 3 + colNum / 3;
        for (int k = 1; k <= 9; k++) {
            if (!row[rowNum][k] && !col[colNum][k] && !map[index][k]) {
                row[rowNum][k] = true;
                col[colNum][k] = true;
                map[index][k] = true;
                board[rowNum][colNum] = (char) ((char) k + '0');
                if (back(rowNum, board)) {
                    return true;
                } else {
                    row[rowNum][k] = false;
                    col[colNum][k] = false;
                    map[index][k] = false;
                    board[rowNum][colNum] = '.';
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
//        char[][] board = {{'.', '.', '9', '7', '4', '8', '.', '.', '.'},
//                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
//                {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
//                {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
//                {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
//                {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
//                {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
//                {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
//                {'.', '.', '.', '2', '7', '5', '9', '.', '.'}};
        char[][] sudoku = solveSudoku(board);
        for (char[] chars : sudoku) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }
}
