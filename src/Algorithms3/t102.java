package Algorithms3;

import java.util.*;

public class t102 {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, root, 0);

        /*
        解法一：BFS层序遍历
         */
        if (root == null)
            return result;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            Deque<TreeNode> temp = new ArrayDeque<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (flag)
                    list.add(node.val);
                else
                    list.add(0, node.val);
                if (node.left != null)
                    temp.offer(node.left);
                if (node.right != null)
                    temp.offer(node.right);
            }
            flag = !flag;
            result.add(list);
            queue.addAll(temp);
        }
        return result;
    }

    /*
    解法二：DFS深度遍历
     */
    public static void dfs(List<List<Integer>> result, TreeNode root, int level) {
        if (root == null)
            return;
        if (result.size() == level)
            result.add(new ArrayList<>());
        if (level % 2 == 0) {
            result.get(level).add(root.val);
        } else {
            result.get(level).add(0, root.val);
        }
        dfs(result, root.left, level + 1);
        dfs(result, root.right, level + 1);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        List<List<Integer>> lists = zigzagLevelOrder(root);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }
    }
}
