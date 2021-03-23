package Algorithms3;

public class t142 {
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            if (head == null || head.next == null)
                return null;
            ListNode slow = head;
            ListNode fast = head;
            // 设链表共有 a+b 个节点
            // 链表头部到链表入口有a个
            // 链表环有b个节点
            // n表示走了几个环
            // f = 2*s (fast是slow的两倍）
            // f = s + n*b (fast比slow多走了n个环)
            // 即得：f = 2*n*b | s = n*b
            // 如果让指针从链表头部一直向前走并统计步数k
            // 那么所有走到链表入口节点时的步数是：k = a + nb
            // 设pre为指向头指针，p与s一起向前，到了环入口：
            // p = a，s = a + n*b
            // 此时s和p都指向环入口，即问题所求解
            while (true) {
                if (fast == null || fast.next == null)
                    return null;
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast)
                    break;
            }
            fast = head;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return fast;
        }
    }
}
