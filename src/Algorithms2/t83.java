package Algorithms2;

public class t83 {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode start = head;
        while (head != null) {
            ListNode current = head;
            while (current != null && current.val == head.val) {
                current = current.next;
            }
            head.next = current;
            head = head.next;
        }
        return start;
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
