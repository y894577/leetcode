package Algorithms;

public class t61 {
    public static ListNode rotateRight(ListNode head, int k) {
        ListNode rear = head;
        int n = 0;
        if (head == null)
            return null;
        while (rear.next != null) {
            rear = rear.next;
            n++;
        }
        rear.next = head;
        k = k % (n + 1);
        while (n >= k) {
            rear = rear.next;
            n--;
            System.out.println(n);
        }
        ListNode result = rear.next;
        rear.next = null;
        System.out.println(rear.val);

        return result;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode rear = head;
        for (int i = 2; i <= 6; i++) {
            rear.next = new ListNode(i);
            rear = rear.next;
        }
        rear.next = null;

        rotateRight(null, 2);
    }
}
