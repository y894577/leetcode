package Algorithms;

public class t28 {
    public static int strStr(String haystack, String needle) {
        if (needle.length()==0)
            return 0;
        int[] next = kmp(needle);
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            //如果是不匹配保证能回到j=0
            while (haystack.charAt(i) != needle.charAt(j) && j >= 1)
                j = next[j - 1];
            if (haystack.charAt(i) == needle.charAt(j))
                ++j;
            if (j == needle.length())
                return i - needle.length() + 1;
        }
        return -1;
    }

    public static int[] kmp(String pat) {
        int m = pat.length();
        int[] next = new int[m];
        next[0] = 0;
        int j = 0;
        for (int i = 1; i < m; i++) {
            //保证一直回溯寻找到相对的最长前缀
            while (pat.charAt(i) != pat.charAt(j) && j >= 1) {
                j = next[j - 1];
            }
            if (pat.charAt(i) == pat.charAt(j))
                ++j;
            next[i] = j;
        }
        return next;
    }

    public static void main(String[] args) {

        String haystack = "ababaabbbbababbaabaaabaabbaaaabbabaabbbbbbabbaabbabbbabbbbbaaabaababbbaabbbabbbaabbbbaaabbababbabbbabaaabbaabbabababbbaaaaaaababbabaababaabbbbaaabbbabb"
                , needle = "abbabbbabaa";
        int i = strStr(haystack, needle);
        System.out.println(i);

//        int[] kmp = kmp(haystack);
//        for (int i : kmp) {
//            System.out.print(i + "   ");
//        }


    }
}
