package Algorithms3;

import java.util.HashMap;
import java.util.Map;

public class t106 {
    int[] inorder;
    int[] postorder;
    int index;
    Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        this.inorder = inorder;
        this.postorder = postorder;
        this.index = n - 1;
        for (int i = 0; i < n; i++) {
            inorderMap.put(inorder[i], i);
        }
        return recursive(0, n - 1);
    }

    public TreeNode recursive(int in_left, int in_right) {
        if (in_left > in_right)
            return null;

        int root_val = postorder[index];
        TreeNode rootNode = new TreeNode(root_val);
        int in_root = inorderMap.get(root_val);
        index--;
        //注意这里有需要先创建右子树
        rootNode.right = recursive(in_root + 1, in_right);
        rootNode.left = recursive(in_left, in_root - 1);

        return rootNode;
    }

    public static void main(String[] args) {
        int[] pre = {9, 3, 15, 20, 7};
        int[] in = {9, 15, 7, 20, 3};
        t106 solution = new t106();
        solution.buildTree(pre, in);
    }
}
