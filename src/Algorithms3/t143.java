package Algorithms3;

import java.util.List;

public class t143 {
    class Solution {
        public void reorderList(ListNode head) {
            if (head == null || head.next == null)
                return;
            ListNode fast = head;
            ListNode slow = head;
            // 寻找中点
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            ListNode mid = slow.next;
            slow.next = null;
            if (mid == null)
                return;

            // 链表反转
            ListNode pre = mid;
            ListNode cur = pre.next;
            pre.next = null;
            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            ListNode dummy = head;
            while (pre != null && head != null) {
                ListNode headNext = head.next;
                ListNode preNext = pre.next;
                head.next = pre;
                pre.next = headNext;
                head = headNext;
                pre = preNext;
            }
        }
    }
}
