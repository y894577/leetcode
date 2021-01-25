package Algorithms3;


public class t109 {
    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }

    public static TreeNode buildTree(ListNode left, ListNode right) {
        if (left == right)
            return null;
        ListNode mid = findMid(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(left, mid);
        root.right = buildTree(mid.next, right);
        return root;
    }

    public static ListNode findMid(ListNode left, ListNode right) {
        ListNode fast = left;
        ListNode slow = left;
        while (fast != right && fast.next != right) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
