package Algorithms;

import java.util.*;

public class t30 {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> index = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> wordmap = new HashMap<>(map);
        //单个单词长度
        int wordLength = words[0].length();
        //总共单词长度
        int length = wordLength * words.length;

        for (String word : words) {
            if (map.containsKey(word)) {
                int num = map.get(word);
                map.replace(word, num + 1);
            } else
                map.put(word, 1);
        }

        int start = 0;
        int end = start + wordLength;

        //记录初始指针，方便回退
        int pin = start;
        while (end <= s.length()) {
            String pat = s.substring(start, end);
            if (wordmap.containsKey(pat)) {
                int num = wordmap.get(pat);
                if (num - 1 == 0)
                    wordmap.remove(pat);
                else
                    wordmap.replace(pat, num - 1);
                start += wordLength;
            } else {
                //start指针回退
                pin += 1;
                start = pin;
                wordmap.clear();
                wordmap.putAll(map);
            }
            if (wordmap.size() == 0) {
                index.add(start - length);
                //hashmap深拷贝
                wordmap.putAll(map);
                start -= length;
                start += 1;
                pin = start;
            }
            end = start + wordLength;
        }
        return index;
    }

    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] word = {"word", "good", "best", "good"};

//        String s = "barfoofoobarthefoobarman";
//        String[] word = {"bar", "foo", "the"};

//        String s = "aaaaaaaaaaaaaa";
//        String[] word = {"aa", "aa"};
        List<Integer> substring = findSubstring(s, word);
        for (Integer integer : substring) {
            System.out.print(integer + " ");
        }
    }
}
