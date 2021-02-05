package Algorithms;

import java.util.HashSet;
import java.util.Set;

//无重复字符的最长子串
public class t3 {
    public int lengthOfLongestSubstring(String s) {
        int cursor1 = 0;
        int cursor2 = 0;
        int length = 0;
        Set<Character> set = new HashSet<Character>();
        int n = s.length();
        char[] str = s.toCharArray();
        while (cursor2 <= n - 1) {
            if (set.contains(str[cursor2])) {
                set.remove(str[cursor1]);
                ++cursor1;
            } else {
                set.add(str[cursor2]);
                ++cursor2;
                int thislength = set.size();
                if (thislength >= length)
                    length = thislength;
            }
        }
        return length;
    }
}
