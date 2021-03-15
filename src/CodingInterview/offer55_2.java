package CodingInterview;

public class offer55_2 {
    class Solution {
        public boolean isBalanced(TreeNode root) {
            return dfs(root) != -1;
        }

        public int dfs(TreeNode root) {
            if (root == null)
                return 0;
            // 剪支
            int left = dfs(root.left);
            if (left == -1) return -1;
            int right = dfs(root.right);
            if (right == -1) return -1;
            int abs = Math.abs(left - right);
            return abs >= 2 ? -1 : Math.max(left, right) + 1;
        }
    }
}
