package Algorithms;

import com.sun.javafx.scene.control.skin.IntegerFieldSkin;

import java.util.Arrays;
import java.util.Stack;

public class t71 {
    public static String simplifyPath(String path) {
        StringBuilder res = new StringBuilder();
        Stack<String> stack = new Stack<>();
        String[] split = path.split("/");

        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else if (!split[i].equals(".") && !split[i].isEmpty()) {
                stack.push(split[i]);
            }
        }
        if (stack.isEmpty())
            return res.append('/').toString();


        while (!stack.isEmpty()) {
            res.insert(0, stack.pop());
            res.insert(0, "/");
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String path = "/../";
        System.out.println(simplifyPath(path));
    }
}
