package Algorithms5;

public class t236 {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null)
                return null;
            // 寻找到节点，返回
            if (root == p || root == q)
                return root;
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            // 当left和right同时为空，左右子树都不包含p和q
            if (left == null && right == null) return null;
            // 在异侧情况
            if (left == null)
                return right;
            if (right == null)
                return left;
            // 当left和right同时不为空，此节点为祖先节点
            return root;
        }
    }
}
