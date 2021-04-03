package Algorithms5;

public class t226 {
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            preorder(root);
            return root;
        }

        public void preorder(TreeNode root) {
            if (root == null)
                return;
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            preorder(root.left);
            preorder(root.right);
        }
    }
}
