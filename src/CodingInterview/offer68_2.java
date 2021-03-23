package CodingInterview;

public class offer68_2 {
    static class Solution {
        TreeNode res;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            dfs(root, p, q);
            return res;
        }

        // 更简便的递归解法
        public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root == p || root == q) return root;
            // 遍历左子树
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            // 遍历右子树
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            // 如果左子树为空，证明左子树没有搜索到任一节点
            // 返回右子树（一定搜索到）
            if (left == null) return right;
            // 如果右子树为空，证明右子树没有搜索到任一节点
            // 返回左子树（一定搜索到）
            if (right == null) return left;
            // 左右子树均不为空，证明该节点为父节点
            return root;
        }

        public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null)
                return false;
            boolean node = false;
            // 如果当前节点等于p或者q，则当前节点为所求节点
            if (root == p || root == q)
                node = true;
            // 左树递归
            boolean left = dfs(root.left, p, q);
            // 右树递归
            boolean right = dfs(root.right, p, q);

            //如果当前节点或左子树或右子树搜索到，则该节点为所求父节点
            if ((left && right) || (node && left) || (node && right))
                this.res = root;
            // 返回该节点及其子树是否搜索成果
            return left || right || node;
        }


    }

    public static void main(String[] args) {
        offer37.Codec codec = new offer37.Codec();
        TreeNode node = codec.deserialize("[3,5,1,6,2,0,8,7,4,null,null,null,null,null,null,null,null,null,null]");
        Solution solution = new Solution();
        solution.lowestCommonAncestor(node, node.left.right, node.left);
    }
}
