package Algorithms3;

public class t105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode();

        return root;
    }

    public void find(int[] preorder, int[] inorder, int mid, TreeNode root) {
        //前序遍历找出跟节点
        for (int i = 0; i < preorder.length; i++) {
            int preNode = preorder[i];
            root.val = preNode;
            int point = -1;
            for (int j = 0; j < inorder.length; j++) {
                if (preNode == inorder[j]) {
                    find(preorder, inorder, j, root);
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
