package Algorithms;

public class t21 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode merge = new ListNode(0);
        ListNode start = merge;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                merge.next = l1;
                l1 = l1.next;
            } else {
                merge.next = l2;
                l2 = l2.next;
            }
            merge = merge.next;
        }
        if (l1 != null)
            merge.next = l1;
        if (l2 != null)
            merge.next = l2;

        return start.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode s1 = l1;
        ListNode l2 = new ListNode(1);
        ListNode s2 = l2;
        for (int i = 2; i <= 5; i++) {
            l1.next = new ListNode(i);
            l1 = l1.next;
        }

        for (int i = 5; i <= 10; i++) {
            l2.next = new ListNode(i);
            l2 = l2.next;
        }

        ListNode listNode = mergeTwoLists(s1, s2);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
