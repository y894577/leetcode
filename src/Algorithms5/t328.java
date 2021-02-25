package Algorithms5;


public class t328 {

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        //偶数节点
        ListNode even = new ListNode();
        //基数节点
        ListNode odd = new ListNode();
        even = head;
        odd = head.next;
        ListNode node = even;
        while (odd.next != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = node;
        return head;
    }


    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode head = root;
        for (int i = 2; i < 7; i++) {
            root.next = new ListNode(i);
            root = root.next;
        }
        oddEvenList(root);
        while (head != null) {
            System.out.println(head.val + " ");
            head = head.next;
        }

    }
}
