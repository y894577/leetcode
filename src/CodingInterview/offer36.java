package CodingInterview;

public class offer36 {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    class Solution {
        //头结点 尾结点
        Node head, pre;

        public Node treeToDoublyList(Node root) {
            if (root == null) return null;
            inorder(root);
            // 构建循环列表
            // 头结点指向尾结点
            head.left = pre;
            // 尾结点指向头结点
            pre.right = head;
            return head;
        }


        public void inorder(Node cur) {
            if (cur == null)
                return;
            inorder(cur.left);
            // 当pre为空时
            // 代表正在访问链表头节点，记为head
            if (pre == null)
                head = cur;
                // 当pre不为空时
                // 修改双向节点引用，即pre.right = cur，cur.left = pre
            else
                pre.right = cur;
            cur.left = pre;
            // 保存 cur
            // 更新pre = cur，即节点cur是后继节点的pre
            pre = cur;
            inorder(cur.right);
        }
    }
}
