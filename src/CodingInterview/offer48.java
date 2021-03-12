package CodingInterview;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class offer48 {
    static class Solution {
        // 用队列实现滑动窗口 时间O(N^2) 空间O(N)
        public int lengthOfLongestSubstring(String s) {
            Deque<Character> queue = new LinkedList<>();
            char[] chars = s.toCharArray();
            int length = 0;
            for (int i = 0; i < chars.length; i++) {
                // 使用contains来判断字符是否出现过 需要线性遍历
                if (!queue.isEmpty() && queue.contains(chars[i])) {
                    while (!queue.isEmpty() && queue.getFirst() != chars[i]) {
                        queue.pollFirst();
                    }
                    queue.pollFirst();
                }
                queue.offerLast(chars[i]);
                length = Math.max(length, queue.size());
            }
            return length;
        }

        // 动态规划 + 哈希表  时间O(N) 空间O(1)
        // 字符的 ASCII 码范围为 0~127127，哈希表dic最多使用O(128)=O(1)大小的额外空间。
        public int lengthOfLongestSubstring2(String s) {
            //使用哈希表（记为dic）统计各字符最后一次出现的索引位置
            Map<Character, Integer> map = new HashMap<>();
            char[] chars = s.toCharArray();
            int j = -1;
            int length = 0;
            for (int i = 0; i < chars.length; i++) {
                if (map.containsKey(chars[i]))
                    // 保证左边指针不会回退 取max
                    j = Math.max(j, map.get(chars[i]));
                map.put(chars[i], i);
                length = Math.max(length, i - j);
            }
            return length;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring2("abba"));
    }
}
