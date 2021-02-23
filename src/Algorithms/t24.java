package Algorithms;

public class t24 {
    public static ListNode swapPairs(ListNode head) {
        ListNode record = new ListNode(0);
        record.next = head;
        ListNode p1 = record;
        //1-----------2-----------3----------------n
        //p1---------p2---------p2.next------p2.next.next
        //p1------p2.next         p2---------p2.next.next
        while (p1.next != null && p1.next.next != null) {
            //第一个节点
            ListNode p2 = p1.next;
            //前一个节点指向第二个节点
            p1.next = p2.next;
            //第一个节点指向第二个节点的后一个节点
            p2.next = p2.next.next;
            //第二个节点指向第一个节点
            p1.next.next = p2;
            //前一个节点等于第一个节点
            p1 = p2;
        }
        return record.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        ListNode start = listNode;
        for (int i = 1; i < 5; i++) {
            listNode.next = new ListNode(i);
            listNode = listNode.next;
        }
        start = swapPairs(start.next);

        while (start != null) {
            System.out.println(start.val);
            start = start.next;
        }
    }
}
