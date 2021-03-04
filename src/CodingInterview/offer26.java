package CodingInterview;

public class offer26 {
    class Solution {
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if (A == null || B == null)
                return false;
            // 递归遍历A的左右子树
            // || 具有短路性质, 如果在某一步返回 true, 则不需要继续递归
            return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }

        public boolean dfs(TreeNode A, TreeNode B) {
            //B遍历完成 返回true
            if (B == null)
                return true;
            //A为空 B不为空 说明两树不相同 返回false
            if (A == null)
                return false;
            if (A.val == B.val) {
                return dfs(A.left, B.left) && dfs(A.right, B.right);
            } else
                return false;
        }
    }
}
