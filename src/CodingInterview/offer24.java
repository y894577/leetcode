package CodingInterview;

public class offer24 {
    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null)
                return head;
            ListNode root = head;
            ListNode slow = head;
            ListNode fast = null;
            ListNode temp = slow;
            while (slow != null) {
                temp = slow.next;
                slow.next = fast;
                fast = slow;
                slow = temp;
            }
            return fast;
        }
    }
}
