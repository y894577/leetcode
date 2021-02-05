package Algorithms2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class t94 {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        recursive(result, root);
        return result;
    }

    //递归调用
    public static void recursive(List<Integer> result, TreeNode node) {
        if (node == null)
            return;
        recursive(result, node.left);
        result.add(node.val);
        recursive(result, node.right);
    }

    //迭代调用
    public static void iteration(List<Integer> result, TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
    }

    public static void main(String[] args) {

    }
}
