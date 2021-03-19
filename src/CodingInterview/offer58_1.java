package CodingInterview;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class offer58_1 {
    static class Solution {
        // 双指针 时间O(N) 空间O(1)
        public String reverseWords(String s) {
            Deque<String> list = new LinkedList<>();
            StringBuffer buffer = new StringBuffer();
            char[] chars = s.toCharArray();
            int i = chars.length - 1;
            while (i >= 0) {
                if (chars[i] != ' ') {
                    int end = i;
                    while (i >= 0 && chars[i] != ' ')
                        i--;
                    buffer.append(s.substring(i + 1, end + 1));
                    buffer.append(" ");
                }
                i--;
            }
            return buffer.toString().trim();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords("  hello world!  "));
    }
}
