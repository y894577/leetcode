package Algorithms3;

public class t112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        targetSum = targetSum - root.val;
        if (root.left == null && root.right == null)
            return targetSum == 0;
        else
            return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
}
