package Algorithms;

public class t14 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        String start = strs[0];

        int num = strs.length;
        for (int i = 1; i < num; i++) {
            start = findCommon(start, strs[i]);
            if (start.equals(""))
                return "";
        }
        return start;
    }

    public static String findCommon(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        String string = "";
        for (int i = 0; i < length; i++) {
            if (str1.charAt(i) == str2.charAt(i))
                string += str1.charAt(i);
            else
                break;
        }
        return string;
    }

    //other way
    //二分查找：将strs[0]分解成两个字符串，前一个字符串和后面的strs数组逐一匹配，如果匹配则后一字符串匹配，如果不匹配将字符串继续二分
    //分治法：分解子问题，将数组分成两份分别求公共前缀最后将结果合并

    //区别：二分查找分解字符串，分治法分解字符串数组

    public static void main(String[] args) {
        String[] strs = {};

        System.out.println(longestCommonPrefix(strs));
    }
}
