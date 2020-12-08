package TopInterviewQuestionsEasy.tree;

import java.util.*;

public class levelOrder {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20));
        root.left = new TreeNode(9, null, null);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        List<List<Integer>> lists = levelOrder(root);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }
    }
}
