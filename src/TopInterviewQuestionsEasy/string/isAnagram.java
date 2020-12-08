package TopInterviewQuestionsEasy.string;

import java.util.HashMap;
import java.util.Map;

public class isAnagram {
    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            if (!map.containsKey(t.charAt(i)))
                return false;
            if (map.get(t.charAt(i)) == 1) {
                map.remove(t.charAt(i));
            } else {
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
            }
        }
        return map.isEmpty();
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }
}
