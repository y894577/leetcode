package Algorithms3;

import java.util.ArrayList;
import java.util.List;

public class t129 {
    public static int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        List<String> list = new ArrayList<>();
        dfs(root, list, new StringBuffer());
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += Integer.parseInt(list.get(i));
        }
        return sum;
    }

    public static void dfs(TreeNode root, List<String> list, StringBuffer num) {
        num.append(root.val);
        if (root.left == null && root.right == null) {
            list.add(num.toString());
        } else {
            if (root.left != null)
                dfs(root.left, list, new StringBuffer(num));
            if (root.right != null)
                dfs(root.right, list, new StringBuffer(num));
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3, new TreeNode(4), new TreeNode(5));
        int sum = sumNumbers(root);
        System.out.printf("sum = %d", sum);
    }
}
