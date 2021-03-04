package CodingInterview;

import java.util.*;

public class offer32_3 {
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null)
                return result;
            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            strategy1(queue, result);
            return result;
        }

        // 双队列
        public void strategy1(Deque<TreeNode> queue, List<List<Integer>> result) {
            boolean order = true;
            while (!queue.isEmpty()) {
                LinkedList<Integer> list = new LinkedList<>();
                for (int i = queue.size(); i > 0; i--) {
                    TreeNode node = queue.poll();
                    //奇数层 则添加至 list 尾部
                    if (order)
                        list.addLast(node.val);
                        //偶数层 则添加至 list 头部
                    else
                        list.addFirst(node.val);
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
                order = !order;
                result.add(list);
            }
        }

        // 奇偶层逻辑分离
        public void strategy2(Deque<TreeNode> queue, List<List<Integer>> result) {
            while (!queue.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                //奇数层打印
                for (int i = queue.size(); i > 0; i--) {
                    //从左向右打印
                    TreeNode node = queue.removeFirst();
                    list.add(node.val);
                    //从左向右 加入队列尾部
                    if (node.left != null) queue.addLast(node.left);
                    if (node.right != null) queue.addLast(node.right);
                }

                if (queue.isEmpty())
                    break;

                //偶数层打印
                for (int i = queue.size(); i > 0; i--) {
                    //从右向左打印
                    TreeNode node = queue.removeLast();
                    list.add(node.val);
                    //从右向左 加入队列头部
                    if (node.right != null) queue.addFirst(node.right);
                    if (node.left != null) queue.addFirst(node.left);
                }
                result.add(list);
            }
        }

        // 倒序
        public void strategy3(Deque<TreeNode> queue, List<List<Integer>> result) {
            boolean order = true;
            while (!queue.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                for (int i = queue.size(); i > 0; i--) {
                    TreeNode node = queue.poll();
                    list.add(node.val);
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
                //翻转数组 倒序
                if (!order) Collections.reverse(list);
                order = !order;
                result.add(list);
            }
        }
    }
}
