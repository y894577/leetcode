package Algorithms3;

import java.util.ArrayList;
import java.util.List;

public class t113 {
    List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>());
        return result;
    }

    public void dfs(TreeNode root, int targetSum, List<Integer> list) {
        if (root == null)
            return;
        targetSum = targetSum - root.val;
        list.add(root.val);
        if (targetSum == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList<>(list));
        } else {
            dfs(root.left, targetSum, list);
            dfs(root.right, targetSum, list);
        }
        list.remove(list.size() - 1);
        targetSum = targetSum + root.val;
    }

    public static void main(String[] args) {

    }
}
