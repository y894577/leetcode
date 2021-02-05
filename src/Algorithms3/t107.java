package Algorithms3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class t107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> list = new LinkedList<TreeNode>();
        list.offer(root);
        while (!list.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = list.poll();
                level.add(node.val);
                if (node.left != null)
                    list.offer(node.left);
                if (node.right != null)
                    list.offer(node.right);
            }
            result.add(0, level);
        }
        return result;
    }
}
