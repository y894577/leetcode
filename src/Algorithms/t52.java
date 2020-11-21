package Algorithms;

public class t52 {
    public static int totalNQueens(int n) {
        boolean[][] flag = new boolean[n][n];
        int count = back(n, 0, flag);
        return count;
    }

    public static int back(int n, int index, boolean[][] flag) {
        if (n == index)
            return 1;

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!flag[index][i]) {
                boolean[][] tempFlag = copy(flag, n);
                for (int j = 0; j < n; j++) {
                    //横排
                    tempFlag[index][j] = true;
                    //竖排
                    tempFlag[j][i] = true;
                    //右下角
                    if (index + j < n && i + j < n)
                        tempFlag[index + j][i + j] = true;
                    //左下角
                    if (i - j >= 0 && index + j < n)
                        tempFlag[index + j][i - j] = true;
                }
                count += back(n, index + 1, tempFlag);
            }
        }
        return count;
    }

    public static boolean[][] copy(boolean[][] flag, int n) {
        boolean[][] tempFlag = new boolean[n][n];
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                tempFlag[j][k] = flag[j][k] ? true : false;
            }
        }
        return tempFlag;
    }

    public static void main(String[] args) {
        int number = totalNQueens(4);
        System.out.println(number);
    }
}
