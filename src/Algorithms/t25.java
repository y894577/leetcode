package Algorithms;

import java.util.ArrayList;
import java.util.List;

public class t25 {
    public static ListNode reverseKGroup(ListNode head, int k) {
        List<ListNode> split = split(head, k);
        List<ListNode> list = new ArrayList<>();

        for (int i = 0; i < split.size() - 1; i++) {
            ListNode node = split.get(i);
            node = reverse(node);
            list.add(node);
        }

        //最后一个列表是否小于k
        ListNode last = split.get(split.size() - 1);
        int count = 0;
        while (last != null) {
            last = last.next;
            count++;
        }
        if (count == k) {
            list.add(reverse(split.get(split.size() - 1)));
        } else {
            list.add(split.get(split.size() - 1));
        }

        ListNode record = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            ListNode listNode = list.get(i);
            ListNode front = listNode;
            while (listNode != null) {
                System.out.println(listNode.val);
                front = listNode;
                listNode = listNode.next;
            }
            if (i != list.size() - 1)
                front.next = list.get(i + 1);
        }
        return record;
    }

    public static List<ListNode> split(ListNode head, int k) {
        List<ListNode> list = new ArrayList<>();
        int count = 1;
        list.add(head);
        ListNode last;
        while (head != null) {
            last = head;
            if (count % k == 0) {
                head = head.next;
                list.add(head);
                last.next = null;
            } else {
                head = head.next;
            }
            ++count;
        }
        return list;
    }

    public static ListNode reverse(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        if (head.next.next == null) {
            ListNode record = head.next;
            head.next.next = head;
            head.next.next.next = null;
            return record;
        }
        //1<-----2<------3      4----->5
        //              p1------p2-----p3
        ListNode record = new ListNode(0);
        record.next = head;
        //前一个节点
        ListNode p1 = head;
        //第一个节点
        ListNode p2 = head.next;
        p1.next = null;
        while (p2 != null && p2.next != null) {
            //第二个节点
            ListNode p3 = p2.next;
            //第一个节点的下一个节点指向前一个节点
            p2.next = p1;
            //record记录下第二个节点的下一个节点
            record = p3.next;
            //第二个节点的下一个节点指向第一个节点
            p3.next = p2;
            p1 = p3;
            p2 = record;
        }
        if (p2 != null) {
            record.next = p1;
            return record;
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        ListNode start = listNode;
        for (int i = 1; i <= 4; i++) {
            listNode.next = new ListNode(i);
            listNode = listNode.next;
        }

        reverseKGroup(start.next, 4);
    }
}