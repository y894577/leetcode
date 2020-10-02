package Algorithms;


public class t19 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = head;
        ListNode end = head;

        for (int i = 0; i < n; i++)
            end = end.next;

        if (end == null)
            return head.next;

        while (end.next != null) {
            start = start.next;
            end = end.next;
        }
        start.next = start.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode start = head;
        for (int i = 2; i <= 2; i++) {
            head.next = new ListNode(i);
            head = head.next;
        }

        ListNode listNode = removeNthFromEnd(start, 2);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }
}
