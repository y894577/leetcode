package Algorithms3;

import java.util.HashMap;
import java.util.Map;

public class t105 {
    int preorder[];
    int inorder[];
    Map<Integer, Integer> inorderMap = inorderMap = new HashMap<>();;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            this.inorderMap.put(inorder[i], i);
        }
        return recursive(0, n - 1, 0, n - 1);
    }

    public TreeNode recursive(int pre_left, int pre_right, int in_left, int in_right) {
        if (pre_left > pre_right)
            return null;

        int pre_root = pre_left;
        int in_root = inorderMap.get(preorder[pre_root]);
        TreeNode rootNode = new TreeNode(preorder[pre_root]);
        int left_size = in_root - in_left;
        rootNode.left = recursive(pre_left + 1, pre_left + left_size, in_left, in_root - 1);
        rootNode.right = recursive(pre_left + left_size + 1, pre_right, in_root + 1, in_right);
        return rootNode;
    }

    public static void main(String[] args) {
        int[] pre = {3, 9, 20, 15, 7};
        int[] in = {9, 3, 15, 20, 7};
        t105 solution = new t105();
        solution.buildTree(pre, in);
    }
}
