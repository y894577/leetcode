package TopInterviewQuestionsEasy.tree;

public class isValidBST {
    public static boolean isValidBST(TreeNode root) {
        return recursion(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean recursion(TreeNode root, long low, long high) {
        if (root == null)
            return true;
        if (root.val <= low || root.val >= high)
            return false;
        else
            return recursion(root.left, low, root.val) && recursion(root.right, root.val, high);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));

//        TreeNode root = new TreeNode(5, new TreeNode(4), new TreeNode(6));
//        root.right = new TreeNode(6, new TreeNode(3), new TreeNode(7));
        boolean validBST = isValidBST(root);
        System.out.println(validBST);
    }
}
