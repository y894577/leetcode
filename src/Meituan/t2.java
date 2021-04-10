package Meituan;

import java.util.Scanner;

public class t2 {
    static class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = scanner.nextInt();
            int res = 1;
            int h = 1;
            int w = 1;
            for (int i = 0; i < n; i++) {
                int t = scanner.nextInt();
                int x = scanner.nextInt();
                // 横着
                if (t == 0) {
                    h = h * 2;
                } else {
                    w = w * 2;
                }
            }
            System.out.println(h * w);
        }
    }
}
