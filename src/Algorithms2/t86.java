package Algorithms2;

public class t86 {
    public static ListNode partition(ListNode head, int x) {
        ListNode a = new ListNode(-1);
        ListNode b = new ListNode(-1);
        ListNode a_start = a;
        ListNode b_start = b;
        while (head != null) {
            if (head.val < x) {
                a.next = head;
                a = a.next;
            } else {
                b.next = head;
                b = b.next;
            }
            head = head.next;
        }
        b.next = null;
        a.next = b_start.next;
        return a_start.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4, 3, 5};
        int target = 2;
        ListNode head = new ListNode(nums[0]);
        ListNode start = head;
        for (int i = 1; i < nums.length; i++) {
            head.next = new ListNode(nums[i]);
            head = head.next;
        }
        partition(start, target);
        while (start != null) {
            System.out.print(start.val + " ");
            start = start.next;
        }
    }
}
