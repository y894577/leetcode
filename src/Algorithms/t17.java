package Algorithms;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class t17 {
    public static List<String> letterCombinations(String digits) {
        HashMap<Character, String> dictionary = new HashMap<>();
        dictionary.put('2', "abc");
        dictionary.put('3', "def");
        dictionary.put('4', "ghi");
        dictionary.put('5', "jkl");
        dictionary.put('6', "mno");
        dictionary.put('7', "pqrs");
        dictionary.put('8', "tuv");
        dictionary.put('9', "wxyz");

        List<String> output = new ArrayList<>();

        if (digits.equals(""))
            return output;

        sort(output, digits, 0, "", dictionary);
        return output;
    }

    public static void sort(List<String> list, String digist, int index, String s, HashMap<Character, String> dictionary) {

        if (digist.length() == index) {
            list.add(s);
        } else {
            char x = digist.charAt(index);
            //  获取字典里的字符串
            String str = dictionary.get(x);

            //  遍历字符串
            for (int i = 0; i < str.length(); i++) {
                s += String.valueOf(str.charAt(i));
                sort(list, digist, index + 1, s, dictionary);
                s = s.substring(0, s.length() - 1);
            }
        }
    }


    public static void main(String[] args) {
        List<String> list = letterCombinations("23");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
