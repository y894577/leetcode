package CodingInterview;

public class offer13 {
    static class Solution {
        public int movingCount(int m, int n, int k) {
            boolean[][] visit = new boolean[m][n];
            return back(0, 0, m, n, k, visit);
        }

        public int getSum(int n) {
            int sum = 0;
            while (n != 0) {
                sum += n % 10;
                n /= 10;
            }
            return sum;
        }

        public int back(int x, int y, int m, int n, int k, boolean[][] visit) {
            if (x < 0 || y < 0 || x == m || y == n || getSum(x) + getSum(y) > k || visit[x][y]) {
                return 0;
            }
            visit[x][y] = true;
            return back(x + 1, y, m, n, k, visit)
                    + back(x - 1, y, m, n, k, visit)
                    + back(x, y + 1, m, n, k, visit)
                    + back(x, y - 1, m, n, k, visit) + 1;
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(solution.movingCount(5, 6, 4));
        }
    }
}
