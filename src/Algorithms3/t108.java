package Algorithms3;

public class t108 {
    public static TreeNode sortedArrayToBST(int[] nums) {
        int n = nums.length;
        return buildTree(nums, 0, n - 1);
    }

    public static TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right)
            return null;
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, left, mid - 1);
        root.right = buildTree(nums, mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode treeNode = sortedArrayToBST(nums);
    }
}
