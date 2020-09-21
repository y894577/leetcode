package Algorithms;

public class t5 {
    
    //动态规划解法
    public static String longestPalindrome(String s) {
        //记录子串是否是回文
        // p[i,j]=true 表示从第i到第j是回文串
        int length = s.length();
        boolean[][] p = new boolean[length][length];
        int max = 0;
        int cursor = 0;
        char[] str = s.toCharArray();

        if (length <= 1)
            return s;
        else
            max = 1;

        //初始化p数组
        for (int i = 0; i < str.length - 1; i++) {
            //字符本身是一个回文
            p[i][i] = true;
            if (str[i] == str[i + 1]) {
                p[i][i + 1] = true;
                max = 2;
                cursor = i;
            }
        }
        //考虑边界情况
        p[length - 1][length - 1] = true;

        //子串长度
        for (int l = 2; l <= length; l++) {
            //子串开始位置
            for (int i = 0; i <= length - l; i++) {
                int start = i;
                int end = i + l - 1;
                if (str[start] == str[end] && p[start + 1][end - 1]) {
                    p[start][end] = true;
                    max = l;
                    cursor = start;
                }
            }
        }
        System.out.println(cursor + " " + max);

        String string = s.substring(cursor, cursor + max);
        return string;
    }

    public static void main(String[] args) {
        String str = longestPalindrome("zeusnilemacaronimaisanitratetartinasiaminoracamelinsuez");
        System.out.println(str);
    }
}
