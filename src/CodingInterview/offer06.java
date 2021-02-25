package CodingInterview;

import java.util.ArrayList;
import java.util.List;

public class offer06 {
    public int[] reversePrint(ListNode head) {
        if (head == null || head.next == null)
            return new int[]{head.val};
        List<Integer> list = new ArrayList<>();
        reserve(list,head);
        int[]result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public void reserve(List<Integer> arr,ListNode node) {
        if (node == null)
            return;
        reserve(arr, node.next);
        arr.add(node.val);
    }

    public static void main(String[] args) {
        offer06 solution = new offer06();
    }
}
