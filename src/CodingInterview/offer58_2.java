package CodingInterview;

public class offer58_2 {
    class Solution {
        // 三次翻转
        // 例如：输入:s ="abcdefg",k =2
        // "abcdefg" 反转前2个字符 "bacdefg"
        // "bacdefg" 反转后5个字符 "bagfedc"
        // "bagfedc" 反转整个字符串 "cdefgab"

        // 时间O(N) 空间O(1)
        public String reverseLeftWords(String s, int n) {
            char[] chars = s.toCharArray();
            reverse(0, n - 1, chars);
            reverse(n, s.length() - 1, chars);
            reverse(0, s.length() - 1, chars);
            return String.valueOf(chars);
        }

        public void reverse(int start, int end, char[] chars) {
            while (start < end) {
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start++;
                end--;
            }
        }
    }
}
