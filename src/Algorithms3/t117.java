package Algorithms3;

import java.util.LinkedList;
import java.util.Queue;

public class t117 {
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
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
        }
        return root;
    }

}
