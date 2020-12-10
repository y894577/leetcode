package Algorithms;

import com.sun.javafx.scene.control.skin.IntegerFieldSkin;

import java.util.Arrays;
import java.util.Stack;

public class t71 {
    public static String simplifyPath(String path) {
        StringBuilder res = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        stack.push(path.charAt(0));
        for (int i = 1; i < path.length(); i++) {
            if (path.charAt(i) == '/') {
                if (stack.peek() != '/')
                    stack.push(path.charAt(i));
            }

            if (path.charAt(i) == '.') {
                while (stack.peek() != '/')
                    stack.pop();
            }

            if (path.charAt(i) != '/' && path.charAt(i) != '.') {
//                if (stack.peek() == '/')
                stack.push(path.charAt(i));
            }
        }
        if (stack.isEmpty())
            return res.append('/').toString();

        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        res.reverse();
        return res.toString();
    }

    public static void main(String[] args) {
        String path = "/home//foo/";
        System.out.println(simplifyPath(path));
    }
}
