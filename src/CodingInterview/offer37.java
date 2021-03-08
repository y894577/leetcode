package CodingInterview;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class offer37 {
    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null)
                return "[]";
            Deque<TreeNode> deque = new LinkedList<>();
            StringBuffer buffer = new StringBuffer("[");
            deque.offerLast(root);
            while (!deque.isEmpty()) {
                for (int i = deque.size(); i >= 0; i--) {
                    TreeNode node = deque.pollFirst();
                    if (node == null)
                        buffer.append("null,");
                    else {
                        buffer.append(node.val).append(",");
                        deque.offerLast(node.left == null ? null : node.left);
                        deque.offerLast(node.right == null ? null : node.right);
                    }
                }
            }
            buffer.deleteCharAt(buffer.length() - 1);
            buffer.append("]");
            return buffer.toString();

        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.equals("[]")) return null;
            String[] str = data.substring(1, data.length() - 1).split(",");
            Queue<TreeNode> nodeQueue = new LinkedList<>();
            TreeNode root = new TreeNode(Integer.parseInt(str[0]));
            int i = 1;
            nodeQueue.offer(root);
            while (!nodeQueue.isEmpty()) {
                TreeNode node = nodeQueue.poll();
                if (!str[i].equals("null")) {
                    node.left = new TreeNode(Integer.parseInt(str[i]));
                    nodeQueue.offer(node.left);
                }
                i++;
                if (!str[i].equals("null")) {
                    node.right = new TreeNode(Integer.parseInt(str[i]));
                    nodeQueue.offer(node.right);
                }
                i++;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode node = codec.deserialize("[]");
//        System.out.println(node.val);
    }
}
