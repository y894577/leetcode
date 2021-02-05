package Algorithms3;

import java.util.ArrayList;
import java.util.List;

public class t114 {
    public void flatten(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        for (int i = 1; i < list.size(); i++) {
            root.left = null;
            root.right = new TreeNode(list.get(i));
            root = root.right;
        }
    }

    public void preorder(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        list.add(root.val);
        if (root.left != null)
            preorder(root.left, list);

        if (root.right != null)
            preorder(root.right, list);

    }
}
