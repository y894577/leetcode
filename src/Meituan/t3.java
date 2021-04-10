package Meituan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class t3 {
    static class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int unhappy = 0;
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                StringBuffer stringBuffer = new StringBuffer(1);
                int num = scanner.nextInt();
                for (int j = 1; j <= num; j++) {
                    if (num % j == 0) {
                        if (j == k) {
                            unhappy += 1;
                            break;
                        }
                        stringBuffer.append(j);
                    }
                }
                String s = stringBuffer.toString();
                String kk = String.valueOf(k);
                int p = 0;
                for (int j = 0; j < s.length(); j++) {
                    if (kk.charAt(p) == s.charAt(j))
                        ++p;
                    else if (kk.charAt(0) == s.charAt(j))
                        p = 1;
                    else
                        p = 0;
                    if (p == kk.length()) {
                        unhappy += 1;
                        break;
                    }
                }
            }
            System.out.println(unhappy);
        }
    }
}
