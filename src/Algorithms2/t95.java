package Algorithms2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class t95 {

    public List<TreeNode> generateTrees(int n) {
        if (n == 0)
            return new ArrayList<>();
        return back(1, n);
    }

    public List<TreeNode> back(int left, int right) {
        List<TreeNode> list = new ArrayList<>();
        if (left > right) {
            list.add(null);
            return list;
        }
        if (left == right) {
            list.add(new TreeNode(left));
            return list;
        }
        for (int i = left; i <= right; i++) {
            TreeNode root = new TreeNode(i, new TreeNode(), new TreeNode());
            //左边递归
            List<TreeNode> leftList = back(left, i - 1);
            //右边递归
            List<TreeNode> rightList = back(i + 1, right);

            for (TreeNode leftNode : leftList) {
                for (TreeNode rightNode : rightList) {
                    TreeNode node = new TreeNode(i, leftNode, rightNode);
                    list.add(node);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        t95 solution = new t95();
        List<TreeNode> treeNodes = solution.generateTrees(3);
        System.out.println(treeNodes.size());
    }
}
