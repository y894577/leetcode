package CodingInterview;

public class offer52 {
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            // 头节点 headA 到 node 前，共有 a - c 个节点；
            // 头节点 headB 到 node 前，共有 b - c 个节点；
            // 指针 A 先遍历完链表 headA ，再开始遍历链表 headB
            // 当走到 node 时，共走步数为：a + (b - c)
            // 指针 B 先遍历完链表 headB ，再开始遍历链表 headA
            // 当走到 node 时，共走步数为：b + (a - c)
            // 如下式所示，此时指针 A , B 重合，并有两种情况：
            // a + (b - c) = b + (a - c)
            ListNode p = headA;
            ListNode q = headB;
            while (p != q) {
                if (p == null)
                    p = headB;
                else
                    p = p.next;
                if (q == null)
                    q = headA;
                else
                    q = q.next;
            }
            return p;
        }
    }
}
