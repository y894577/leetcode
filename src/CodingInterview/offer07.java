package CodingInterview;

public class offer07 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < preorder.length; i++) {
            TreeNode root = new TreeNode(inorder[i]);
            root.left =
        }
    }

    //递归
    public TreeNode recursion(){

    }

    public static void main(String[] args) {
        int[] pre = {3, 9, 20, 15, 7};
        int[] in = {9, 3, 15, 20, 7};
    }
}
