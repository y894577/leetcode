package Algorithms3;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class t116 {
    public Node connect(Node root) {
        if (root == null)
            return root;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                //poll() 取出队首并移动
                Node node = queue.poll();
                //依次取出队首元素连接
                if (i < size - 1)
                    //peek() 取出队首但是不移动
                    node.next = queue.peek();
                //满二叉树不做null判断
                if (node.left != null) {
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }

    public Node connect2(Node root) {
        if (root == null) {
            return root;
        }

        // 从根节点开始
        Node leftmost = root;

        while (leftmost.left != null) {

            // 遍历这一层节点组织成的链表，为下一层的节点更新 next 指针
            Node head = leftmost;

            while (head != null) {

                // CONNECTION 1
                head.left.next = head.right;

                // CONNECTION 2
                if (head.next != null) {
                    head.right.next = head.next.left;
                }

                // 指针向后移动
                head = head.next;
            }

            // 去下一层的最左的节点
            leftmost = leftmost.left;
        }

        return root;
    }
}
