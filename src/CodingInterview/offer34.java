package CodingInterview;

import java.util.ArrayList;
import java.util.List;

public class offer34 {
    static class Solution {
        TreeNode root;
        int sum;
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            this.root = root;
            this.sum = sum;
            back(new ArrayList<>(), root, sum);
            return result;
        }

        public void back(List<Integer> list, TreeNode root, int total) {
            if (root == null)
                return;
            list.add(root.val);
            if (total - root.val == 0 && root.left == null && root.right == null)
                result.add(new ArrayList<>(list));
            else {
                back(list, root.left, total - root.val);
                back(list, root.right, total - root.val);
            }
            list.remove(list.size() - 1);

        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 4, 8, 11, -1, 13, 4, 7, 2, -1, -1, 5, 1};
        Solution solution = new Solution();
    }
}
