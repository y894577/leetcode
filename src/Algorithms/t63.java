package Algorithms;

public class t63 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++){
            if (obstacleGrid[i][0] == 1)
                break;
            dp[i][0] = 1;
        }

        for (int i = 0; i < n; i++){
            if (obstacleGrid[0][i] == 1)
                break;
            dp[0][i] = 1;
        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0)
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                else
                    dp[i][j] = 0;
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 1, 0, 0}, {0, 0, 0, 0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}
