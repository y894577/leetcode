package CodingInterview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class offer32_1 {
    class Solution {
        public int[] levelOrder(TreeNode root) {
            if (root == null)
                return new int[0];
            List<Integer> list = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            // Queue使用时要尽量避免Collection的add()和remove()方法
            // 而是要使用offer()来加入元素，使用poll()来获取并移出元素。
            // 它们的优点是通过返回值可以判断成功与否，add()和remove()方法在失败的时候会抛出异常。
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            //将Integer类型list复制为int数组
            return list.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}
