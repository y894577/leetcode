package Algorithms;

import java.util.*;

public class t49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        int[] count = new int[26];
        for (String str : strs) {
            Arrays.fill(count, 0);

            for (int i = 0; i < str.length(); i++)
                count[str.charAt(i) - 'a'] += 1;

            StringBuilder buffer = new StringBuilder();

            for (int i = 0; i < 26; i++)
                if (count[i] != 0){
                    buffer.append(count[i]);
                    buffer.append(i);
                }

            if (!map.containsKey(buffer.toString()))
                map.put(buffer.toString(), new ArrayList<>());

            List<String> list = map.get(buffer.toString());
            list.add(str);
        }

        List<List<String>> result = new ArrayList<>();
        Set<String> set = map.keySet();
        for (String s : set)
            result.add(map.get(s));

        return result;
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strs);
        for (List<String> list : lists) {
            System.out.println(list.toString());
        }
    }
}
