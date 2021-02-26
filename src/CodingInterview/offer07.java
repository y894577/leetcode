package CodingInterview;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class offer07 {
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        // 当前节点的所有还没有考虑过右儿子的祖先节点
        // 栈顶就是当前节点
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        // index 对应的节点是「当前节点不断往左走达到的最终节点」
        int inorderIndex = 0;
        // preorder = [3, 9, 8, 5, 4, 10, 20, 15, 7]
        // inorder = [4, 5, 8, 10, 9, 3, 15, 20, 7]
        // 前序遍历，从根节点root开始，只要有左子节点，就一直会往左下方走，直到最左下角。
        // 而中序遍历，是从最左下角往上（示例中的4-5-8-9-3）
        // 如果碰到节点有右子节点，则会转向（示例中的8-10）。
        for (int i = 1; preorder.length > i; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            // 用前序数组一直构建左子树
            // 如果碰到了inorder[inorderIndex]，表示到了左下角
            // 那么说明我们在中序遍历中找到了栈顶节点
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                //往上走并处理右子树
                //如果 index 对应的元素恰好等于栈顶节点，那么说明我们在中序遍历中找到了栈顶节点（没有右子树）
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                //有友子树，即找到双亲节点
                node.right = new TreeNode(preorderVal);
                //最后都将当前的节点入栈
                stack.push(node.right);
            }
        }
        return root;
    }


    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < preorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recursion(preorder, 0, 0, preorder.length - 1);
    }

    //递归
    //start 中序遍历开始 end 中序遍历结束
    public TreeNode recursion(int[] preorder, int mid, int start, int end) {
        if (start > end)
            return null;
        TreeNode root = new TreeNode(preorder[mid]);
        //中序遍历中根节点的位置 划分左右子树
        int index = map.get(preorder[mid]);
        root.left = recursion(preorder, mid + 1, start, index - 1);
        //index-start = 左子树元素个数
        root.right = recursion(preorder, mid + 1 + index - start, index + 1, end);
        return root;
    }

    public static void main(String[] args) {
        int[] pre = {3, 9, 20, 15, 7};
        int[] in = {9, 3, 15, 20, 7};
        offer07 solution = new offer07();
        solution.buildTree(pre, in);
    }
}
