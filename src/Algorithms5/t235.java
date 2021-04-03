package Algorithms5;

public class t235 {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (p.val > q.val) {
                TreeNode temp = p;
                p = q;
                q = temp;
            }
            while (root != null) {
                if (root.val > p.val && root.val < q.val)
                    break;
                if (root.val == p.val || root.val == q.val)
                    break;
                if (root.val > q.val)
                    root = root.left;
                else
                    root = root.right;
            }
            return root;
        }
    }
}
