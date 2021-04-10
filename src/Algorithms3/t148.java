package Algorithms3;

import java.util.List;

public class t148 {
    class Solution {
        // 归并排序
        public ListNode sortList(ListNode head) {
            return sort(head);
        }

        public ListNode merge(ListNode a, ListNode b) {
            ListNode dummy = new ListNode();
            ListNode head = dummy;
            while (a != null && b != null) {
                if (a.val > b.val) {
                    dummy.next = a;
                    a = a.next;
                } else {
                    dummy.next = b;
                    b = b.next;
                }
                dummy = dummy.next;
            }
            if (a != null)
                dummy.next = a;
            else
                dummy.next = b;
            return head.next;
        }

        public ListNode sort(ListNode node) {
            if (node == null)
                return null;
            if (node.next == null)
                return node;
            ListNode fast = node;
            ListNode slow = node;
            ListNode pre = node;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                pre = slow;
                slow = slow.next;
            }
            pre.next = null;
            ListNode left = sort(node);
            ListNode right = sort(slow);
            return merge(left, right);
        }
    }
}
