package CodingInterview;

public class offer22 {
    class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {
            ListNode slow = head;
            ListNode fast = head;
            while (k > 0) {
                fast = fast.next;
                --k;
            }
            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
    }
}
