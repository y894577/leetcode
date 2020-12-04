package TopInterviewQuestionsEasy.tree;

public class maxDepth {
    public static int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(findDepth(root.left, 0), findDepth(root.right, 0));
    }

    public static int findDepth(TreeNode root, int h) {
        if (root == null)
            return h + 1;
        return Math.max(findDepth(root.left, h + 1), findDepth(root.right, h + 1));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        System.out.println(maxDepth(null));
    }
}
