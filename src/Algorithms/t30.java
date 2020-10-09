package Algorithms;

import java.util.*;

public class t30 {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> index = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
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

        HashMap<String, Integer> wordmap = new HashMap<>(map);

        int start = 0;
        int end = start + wordLength;

        //记录初始指针，方便回退
        int pin = start;
        //是否匹配但是超过个数
        boolean isOver = false;
        String overString = null;
        while (end <= s.length()) {
            String pat = s.substring(start, end);
            if (wordmap.containsKey(pat) && !isOver) {
                int num = wordmap.get(pat);
                //对匹配却溢出的情况做处理
                //如果数目溢出，则从第一个匹配的地方移除
                if (num == 0) {
                    isOver = true;
                    overString = pat;
                } else if (num == 1)
                    wordmap.remove(pat);
                else
                    wordmap.replace(pat, num - 1);
                start += wordLength;
            } else {
                //start指针回退
                if (isOver) {
                    while (!s.substring(pin, end).equals(overString)) {
                        pin += wordLength;
                        end = pin + wordLength;
                    }
                    pin += wordLength;
                } else
                    pin += 1;
                start = pin;
                wordmap.clear();
                wordmap.putAll(map);
                isOver = false;
                overString = null;
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
//        String s = "wordgoodgoodgoodbestword";
//        String[] word = {"word", "good", "best", "good"};

//        String s = "barfoofoobarthefoobarman";
//        String[] word = {"bar", "foo", "the"};

        String s = "barfoothefoobarman";
        String[] word = {"foo", "bar"};

//        String s = "aaaaaaaaaaaaaa";
//        String[] word = {"aa", "aa"};
        List<Integer> substring = findSubstring(s, word);
        for (Integer integer : substring) {
            System.out.print(integer + " ");
        }
    }
}
