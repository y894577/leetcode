package Algorithms;

import java.util.ArrayList;
import java.util.List;

public class t22 {
    public static List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        fun(list, "", n, 0, 0);
        return list;
    }

    public static void fun(List<String> list, String str, int n, int l, int r) {

        if (l == n && r == n) {
            list.add(str);
        }
        if (l > n || r > n)
            return;

        if (l >= r) {
            String s1 = str + ")";
            fun(list, s1, n, l, r + 1);

            String s2 = str + "(";
            fun(list, s2, n, l + 1, r);
        }


    }

    public static void main(String[] args) {
        List<String> list = generateParenthesis(3);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
