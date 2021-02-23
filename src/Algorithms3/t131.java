package Algorithms3;

import java.util.ArrayList;
import java.util.List;

public class t131 {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        int n = s.length();
        if (n == 0)
            return result;

        back(s, 0, new ArrayList<>(), result);
        return result;
    }

    public void back(String s, int begin, List<String> list, List<List<String>> result) {
        if (begin == s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = begin; i < s.length(); i++) {
            String sub = s.substring(begin, i + 1);
            if (check(sub)) {
                list.add(sub);
                back(s, i + 1, list, result);
                list.remove(list.size() - 1);
            }
        }
    }

    public boolean check(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        t131 solution = new t131();
        String str = "aab";
        List<List<String>> result = solution.partition(str);
        for (List<String> list : result) {
            System.out.println(list.toString());
        }
    }
}
