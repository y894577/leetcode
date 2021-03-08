package CodingInterview;

import java.util.HashMap;
import java.util.Map;

public class offer35 {
    class Solution {
        //哈希表存储节点 记录每个节点
        public Node copyRandomList(Node head) {
            if (head == null) return null;
            Map<Node, Node> map = new HashMap<>();
            Node cur = head;
            while (cur != null) {
                map.put(cur, new Node(cur.val));
                cur = cur.next;
            }
            Node root = map.get(head);
            while (head != null) {
                Node node = map.get(head);
                node.next = map.get(head.next);
                node.random = map.get(head.random);
                head = head.next;
            }

            return root;
        }

        //拼接 + 拆分
        public Node copyRandomList2(Node head) {
            if (head == null) return null;
            Node cur = head;
            Node pre = head;

            // 复制各节点，构建拼接链表:
            // 设原链表为 node1 -> node2 -> node3 ... ，构建的拼接链表如下所示：
            // node1 -> node1_copy -> node2 -> node2_copy -> ...
            while (cur != null) {
                Node temp = cur.next;
                cur.next = new Node(cur.val);
                cur.next.next = temp;
                cur = cur.next.next;
            }

            // 构建新链表各节点的 random 指向：
            // 当访问原节点 cur 的随机指向节点 cur.random 时
            // 对应新节点 cur.next 的随机指向节点为 cur.random.next（cur.random的复制节点）
            cur = head;
            while (cur != null) {
                if(cur.random != null)
                    cur.next.random = cur.random.next;
                cur = cur.next.next;
            }

            // 拆分原 / 新链表：
            // 设置pre/cur分别指向原/新链表头节点
            // 遍历执行pre.next=pre.next.next和cur.next=cur.next.next将两链表拆分开
            // 返回新链表的头节点 res 即可。
            cur = head.next;
            Node root = head.next;
            while (cur.next != null) {
                pre.next = pre.next.next;
                cur.next = cur.next.next;
                pre = pre.next;
                cur = cur.next;
            }
            // 单独处理原链表尾节点
            pre.next = null;
            return root;
        }
    }
}
