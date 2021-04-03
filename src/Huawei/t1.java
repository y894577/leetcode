package Huawei;

import java.util.*;

public class t1 {
    static class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            long[] map = new long[26];
            char[] chars = new char[26];
            Map<Character, Boolean> dict = new HashMap<>();
            for (int i = 0; i < 26; i++) {
                chars[i] = (char) ('a' + i);
            }
            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                if (str.length() == 0)
                    break;
                char a = str.charAt(0);
                char b = str.charAt(2);
                int n1 = str.charAt(4) - '0';
                int n2 = str.charAt(6) - '0';
                dict.put(a, true);
                dict.put(b, true);
                if (n1 > n2) {
                    map[a - 'a'] += 3;
                } else if (n1 < n2) {
                    map[b - 'a'] += 3;
                } else {
                    map[a - 'a'] += 1;
                    map[b - 'a'] += 1;
                }
            }
            String res = "";
            Arrays.sort(map);
            System.out.println(Arrays.toString(map));
            for (int i = map.length - 1; i >= 0; i--) {
                if (map[i] != 0 || (dict.containsKey((char) (i + 'a'))))
                    res += (char) (i + 'a') + " " + map[i] + ",";
            }
            res = res.substring(0, res.length() - 1);
            System.out.println(res);
        }
    }
}
