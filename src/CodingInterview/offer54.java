package CodingInterview;

public class offer54 {
    class Solution {

        public int count, res;

        public int kthLargest(TreeNode root, int k) {
            this.count = 0;
            dfs(root, k);
            return res;
        }

        // 中序遍历
        public void dfs(TreeNode root, int k) {
            if (root == null)
                return;
            // 右子树遍历
            dfs(root.right, k);
            if (++count == k){
                res = root.val;
                return;
            }
            // 左子树遍历
            dfs(root.left, k);
        }
    }
}
