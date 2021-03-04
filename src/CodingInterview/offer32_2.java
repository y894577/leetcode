package CodingInterview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class offer32_2 {
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null)
                return result;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()){
                List<Integer> list = new ArrayList<>();
                // 可以有效防止queue的长度改变而造成循环次数改变
                // 逆向遍历，可以减少重新int的存储开销
                // sdl tql orz
                for(int i = queue.size(); i > 0; i--) {
                    TreeNode node = queue.poll();
                    list.add(node.val);
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
                result.add(list);
            }
            return result;
        }
    }
}
