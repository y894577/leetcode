package Algorithms;

import java.util.HashMap;
import java.util.Map;

public class t36 {
    public static boolean isValidSudoku(char[][] board) {

        HashMap<Integer, Integer>[] row = new HashMap[9];
        HashMap<Integer, Integer>[] col = new HashMap[9];
        HashMap<Integer, Integer>[] map = new HashMap[9];

        for (int i = 0; i < 9; i++) {
            row[i] = new HashMap<Integer, Integer>();
            col[i] = new HashMap<Integer, Integer>();
            map[i] = new HashMap<Integer, Integer>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = (int) board[i][j];
                    int index = (i / 3) * 3 + j / 3;
                    row[i].put(num, row[i].getOrDefault(num, 0) + 1);
                    col[j].put(num, col[j].getOrDefault(num, 0) + 1);
                    map[index].put(num, map[index].getOrDefault(num, 0) + 1);
                    if (row[i].get(num) > 1 || col[j].get(num) > 1 || map[index].get(num) > 1)
                        return false;
                }
            }
        }
        return true;
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
        boolean validSudoku = isValidSudoku(board);
        System.out.println(validSudoku);
    }
}
