package Algorithms;

import java.util.Stack;

public class t23 {
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        if (lists.length == 1)
            return lists[0];

        //顺序法
//        ListNode temp = mergeTwoLists(lists[0], lists[1]);
//        for (int i = 2; i < lists.length; i++) {
//            temp = mergeTwoLists(temp, lists[i]);
//        }
//        return temp;


        //分治法
        return merge(lists, 0, lists.length - 1);

    }

    public static ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r)
            return lists[l];
        if (r - l == 1)
            return mergeTwoLists(lists[l], lists[r]);
        if (l > r)
            return null;
        int mid = (l + r) / 2;

        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode a = l1;
        ListNode b = l2;
        ListNode merge = head;
        while (a != null && b != null) {
            if (a.val < b.val) {
                merge.next = a;
                a = a.next;
            } else {
                merge.next = b;
                b = b.next;
            }
            merge = merge.next;
        }
        if (a != null)
            merge.next = a;
        if (b != null)
            merge.next = b;

        return head.next;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode s1 = l1;
        ListNode l2 = new ListNode(2);
        ListNode s2 = l2;
        ListNode l3 = new ListNode(3);
        ListNode s3 = l3;
        for (int i = 2; i <= 5; i++) {
            l1.next = new ListNode(i);
            l1 = l1.next;
        }

        for (int i = 5; i <= 10; i++) {
            l2.next = new ListNode(i);
            l2 = l2.next;
        }

        for (int i = 3; i <= 8; i++) {
            l3.next = new ListNode(i);
            l3 = l3.next;
        }

        ListNode[] lists = {s1, s2, s3};
        ListNode listNode = mergeKLists(lists);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
