package TopInterviewQuestionsEasy.tree;

public class sortedArrayToBST {
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0)
            return null;
        int left = 0;
        int right = nums.length - 1;
        TreeNode root = middleOrder(nums, left, right);
        return root;
    }

    public static TreeNode middleOrder(int[] nums, int left, int right) {
        if (left > right)
            return null;
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = middleOrder(nums, left, mid - 1);
        root.right = middleOrder(nums, mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5};
        TreeNode node = sortedArrayToBST(nums);
    }
}
