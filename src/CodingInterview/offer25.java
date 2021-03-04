package CodingInterview;

public class offer25 {
    class Solution {
        //迭代
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode root = new ListNode(-1);
            ListNode point = root;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    root.next = l1;
                    l1 = l1.next;
                } else {
                    root.next = l2;
                    l2 = l2.next;
                }
                root = root.next;
            }
            if (l1 != null)
                root.next = l1;
            if (l2 != null)
                root.next = l2;
            return point.next;
        }

        //递归
        public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
            if (l1 == null)
                return l2;
            if (l2 == null)
                return l1;
            if (l1.val <= l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
        }
    }
}
