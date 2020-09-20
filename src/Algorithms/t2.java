package Algorithms;

//两数相加
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class t2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode list = new ListNode(0);
        ListNode first = list;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int l1v;
            int l2v;

            if (l1 == null)
                l1v = 0;
            else {
                l1v = l1.val;
                l1 = l1.next;
            }

            if (l2 == null)
                l2v = 0;
            else {
                l2v = l2.val;
                l2 = l2.next;
            }

            int sum = l1v + l2v + carry;
            carry = sum / 10;
            sum = sum % 10;
            ListNode newNode = new ListNode(sum);
            list.next = newNode;
            list = list.next;
        }
        return first.next;
    }
}