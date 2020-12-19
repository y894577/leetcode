package Algorithms2;

public class t82 {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode a = node;
        ListNode b = node.next;
        while (b != null && b.next != null) {
            if (a.next.val == b.next.val) {
                while (b.next != null && a.next.val == b.next.val) {
                    b = b.next;
                }
                a.next = b.next;
            }else {
                a = a.next;
            }
            b = b.next;
        }
        return node.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 3, 4, 5};
        ListNode head = new ListNode(nums[0]);
        ListNode start = head;
        for (int i = 1; i < nums.length; i++) {
            head.next = new ListNode(nums[i]);
            head = head.next;
        }
        deleteDuplicates(start);
        while (start != null) {
            System.out.print(start.val + " ");
            start = start.next;
        }
    }
}
