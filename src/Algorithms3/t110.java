package Algorithms3;

public class t110 {
    public boolean isBalanced(TreeNode root) {
        return getLevel(root) >= 0;
    }

    public int getLevel(TreeNode root) {
        if (root == null)
            return 0;
        int left = getLevel(root.left);
        int right = getLevel(root.right);
        if (Math.abs(left - right) > 1 || left == -1 || right == -1)
            return -1;
        return Math.max(left, right) + 1;
    }
}
