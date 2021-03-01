package CodingInterview;


public class offer18 {
    class Solution {
        public ListNode deleteNode(ListNode head, int val) {
            ListNode before = new ListNode(-1);
            before.next = head;
            ListNode root = before;
            while (before != null) {
                ListNode after = before.next;
                if (after != null && after.val == val) {
                    before.next = after.next;
                    break;
                }
                before = before.next;
            }
            return root.next;
        }
    }
}
