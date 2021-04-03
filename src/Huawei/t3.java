package Huawei;

import java.util.Scanner;

public class t3 {
    static class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            int cur = scanner.nextInt();
            int index = 0;
            int res = 0;
            while (index < s2.length()) {
                char c = s2.charAt(index);
                int p1 = find(s1, c, cur, true);
                int p2 = find(s1, c, cur, false);
                if (p1 < p2) {
                    res += p1;
                    cur = (cur + p1) % s1.length();
                } else {
                    res += p2;
                    p2 = p2 % s1.length();
                    cur = cur - p2;
                    if (cur < 0)
                        cur = s1.length() + cur;
                }
                ++index;
            }
            System.out.println(res);
        }

        public static int find(String s, char f, int cur, boolean flag) {
            int step = 0;
            if (flag) {
                while (s.charAt(cur) != f) {
                    step++;
                    cur++;
                    if (cur == s.length())
                        cur = 0;
                }
                return step;
            } else {
                while (s.charAt(cur) != f) {
                    step++;
                    cur--;
                    if (cur < 0)
                        cur = s.length() - 1;
                }
                return step;
            }
        }
    }
}
