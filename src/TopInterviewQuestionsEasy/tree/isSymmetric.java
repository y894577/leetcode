package TopInterviewQuestionsEasy.tree;

import java.util.ArrayList;
import java.util.List;

public class isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return dfs(root, root);
    }

    public boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        if (left.val != right.val)
            return false;
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, null);
    }
}
