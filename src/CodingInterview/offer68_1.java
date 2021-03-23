package CodingInterview;

public class offer68_1 {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null)
                return root;
            if (p.val == root.val)
                return p;
            // p q的值都小于根节点，则向左搜索
            // p q的值都大于根节点，则向右搜索
            if (p.val < root.val && q.val < root.val)
                return lowestCommonAncestor(root.left, p, q);
            if (p.val > root.val && q.val > root.val)
                return lowestCommonAncestor(root.right, p, q);
            else
                return root;
        }
    }
}
