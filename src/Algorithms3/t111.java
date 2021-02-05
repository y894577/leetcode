package Algorithms3;

public class t111 {
    public int minDepth(TreeNode root) {
        //自底向上
        if (root == null)
            return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (root.left == null || root.right == null)
            //左右子树有一个为空
            return Math.max(left, right) + 1;
        else
            //左右子树均不为空
            return Math.min(left, right) + 1;
    }

}
