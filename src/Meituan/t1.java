package Meituan;

import java.util.HashSet;
import java.util.Scanner;

public class t1 {
    static class Main {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String s = scanner.next();
            int res = 0;
            for (int i = 0; i <= s.length(); i++) {
                res += dfs(s, 0, i, new HashSet<>(), 1);
                res %= 20210101;

            }
            System.out.println(res + s.length());
        }

        public static int dfs(String s, int index, int length, HashSet<Character> set, int count) {
            if (length == set.size() || index == s.length()) {
                return 1;
            }

            int res = 0;
            for (int i = index; i < s.length(); i++) {
                if (!set.contains(s.charAt(i))) {
                    set.add(s.charAt(i));
                    res += dfs(s, i + 1, length, set, count);
                    set.remove(s.charAt(i));
                }
            }
            return res;
        }
    }
}
