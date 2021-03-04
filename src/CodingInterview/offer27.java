package CodingInterview;

import java.util.Deque;
import java.util.LinkedList;

public class offer27 {
    static class Solution {
        //深度遍历 递归
        public TreeNode mirrorTree(TreeNode root) {
            if (root == null)
                return null;
            //暂存left节点，因为root.left之后left节点改变
            TreeNode temp = root.left;
            root.left = mirrorTree(root.right);
            root.right = mirrorTree(temp);
            return root;
        }

        //辅助栈（队列）
        //利用栈（或队列）遍历树的所有节点 node ，并交换每个 node 的左 / 右子节点。
        public TreeNode mirrorTree2(TreeNode root) {
            if (root == null) return null;
            Deque<TreeNode> queue = new LinkedList<>();
            queue.push(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.pop();
                //添加子节点： 将 nodenode 左和右子节点入栈
                if (node.left != null)
                    queue.push(node.left);
                if (node.right != null)
                    queue.push(node.right);
                //交换节点
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
            }
            return root;
        }


        public static void main(String[] args) {
            Solution solution = new Solution();
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            solution.mirrorTree(root);
        }
    }
}
