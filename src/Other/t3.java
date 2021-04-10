package Other;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class t3 {
    static class Solution {
        static List<String> res = new ArrayList<>();
        static int init = 17;

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                int m = scanner.nextInt();
                int n = scanner.nextInt();
                getNum(m, n);
                System.out.println(res);
                res = new ArrayList<>();
            }

        }

        public static void getNum(int m, int n) {
            int left = 0;
            int right = n - 1;
            int top = 0;
            int bottom = m - 1;
            int x = 0, y = 0;

            int count = 1;
            while (true) {
                while (x <= right - 1) {
                    if (count == init)
                        printNum(x, y);
                    x++;
                    count++;
                }
                if (++top == bottom) break;
                while (y <= bottom - 1) {
                    if (count == init)
                        printNum(x, y);
                    y++;
                    count++;
                }
                if (left == --right) break;
                while (x > left) {
                    if (count == init)
                        printNum(x, y);
                    x--;
                    count++;
                }
                if (--bottom == top) break;
                while (y > top) {
                    y--;
                    count++;
                    if (count == init)
                        printNum(x, y);
                }
                if (++left == right) break;
            }

        }

        public static void printNum(int x, int y) {
            String s = "[" + y + "," + x + "]";
            res.add(s);
            init += 20;
        }
    }


}
