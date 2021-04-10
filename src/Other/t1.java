package Other;


import java.util.Scanner;

public class t1 {
    static class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                int n = scanner.nextInt();
                int m = scanner.nextInt();

                int[] w = new int[n + 5];
                for (int i = 0; i < n; i++) {
                    w[i] = scanner.nextInt();
                }

                int[] dp = new int[m + 5];
                dp[0] = 1;
                for (int i = 0; i < n; i++) {
                    for (int j = m; j >= w[i]; j--) {
                         dp[j] = Math.max(dp[j], dp[j - w[i]]);
                    }
                }
                if (dp[m] == 1)
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
            scanner.close();
        }


    }


}
