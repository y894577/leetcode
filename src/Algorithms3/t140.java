package Algorithms3;

import java.util.*;

public class t140 {
    static class Solution {
        public List<String> wordBreak(String s, List<String> wordDict) {
            // s 的每个下标和从该下标开始的部分可以组成的句子列表，即不完全的 wordBreaks
            Map<Integer, List<List<String>>> map = new HashMap<>();
            // 回溯查找
            List<List<String>> wordBreaks = backtrack(s, s.length(), new HashSet<>(wordDict), 0, map);
            List<String> breakList = new LinkedList<>();
            for (List<String> wordBreak : wordBreaks) {
                breakList.add(String.join(" ", wordBreak));
            }
            return breakList;
        }

        /**
         * @param s       字符串
         * @param length  字符串长度
         * @param wordSet 字典
         * @param index   当前下标
         * @param map     记忆化序列
         * @return 可以组成的句子列表
         */
        public List<List<String>> backtrack(String s, int length, Set<String> wordSet, int index, Map<Integer, List<List<String>>> map) {
            if (!map.containsKey(index)) {
                List<List<String>> wordBreaks = new LinkedList<>();
                // index 访问到字符串结尾
                if (index == length) {
                    wordBreaks.add(new LinkedList<>());
                }
                // 寻找 index 下标以后的单词
                for (int i = index + 1; i <= length; i++) {
                    String word = s.substring(index, i);
                    if (wordSet.contains(word)) {
                        // word 包含在字典内，继续递归
                        List<List<String>> nextWordBreaks = backtrack(s, length, wordSet, i, map);
                        // 逆序可以组成的句子列表
                        for (List<String> nextWordBreak : nextWordBreaks) {
                            LinkedList<String> wordBreak = new LinkedList<>(nextWordBreak);
                            wordBreak.offerFirst(word);
                            wordBreaks.add(wordBreak);
                        }
                    }
                }
                // 存入map中
                map.put(index, wordBreaks);
            }
            // 返回当前 index 中可以组成句子的单词列表
            return map.get(index);
        }
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        Solution solution = new Solution();
        solution.wordBreak(s, wordDict);
    }
}
