package Meituan;

import java.util.Scanner;

public class t4 {
    static class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = scanner.nextInt();
                }
            }
            int cur = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == cur) {

                    }
                }
            }
            System.out.println(-1);
        }

        public static void dfs(int[][] arr, int n, int cur, int k, int x, int y) {
            if (x >= n || x < 0 || y < 0 || y >= n)
                return;
            if (arr[x][y + 1] == cur)
                dfs(arr, n, cur + 1, k, x, y + 1);
            if (arr[x][y - 1] == cur)
                dfs(arr, n, cur + 1, k, x, y - 1);
            if (arr[x + 1][y] == cur)
                dfs(arr, n, cur + 1, k, x + 1, y);
            if (arr[x - 1][y] == cur)
                dfs(arr, n, cur + 1, k, x - 1, y);
        }
    }
}
