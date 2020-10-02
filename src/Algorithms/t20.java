package Algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class t20 {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char x = chars[i];

            if (map.get(x) != null && !stack.empty() && map.get(x).equals(stack.peek())) {
                stack.pop();
            } else
                stack.push(x);
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println(isValid(""));
    }
}
