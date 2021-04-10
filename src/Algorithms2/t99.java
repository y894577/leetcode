package Algorithms2;

import java.util.Deque;
import java.util.LinkedList;

public class t99 {
    class Solution {
        // 辅助pre指针，记录上一个节点的值
        TreeNode pre;
        // 用两个变量x，y来记录需要交换的节点
        TreeNode x, y;

        public void recoverTree(TreeNode root) {
            inorder(root);
            int temp = x.val;
            x.val = y.val;
            y.val = temp;
        }

        // 中序遍历二叉搜索树，遍历应该为顺序 pre.val < root.val
        public void inorder(TreeNode root) {
            if (root == null)
                return;
            inorder(root.left);
            // 比较上一个节点(pre)和当前节点的值
            if (pre != null && pre.val > root.val) {
                // 如果pre的值大于当前节点值，则记录下这两个节点
                if (x == null) x = pre;
                y = root;
            }
            pre = root;
            inorder(root.right);
        }

        public void Mirrors(TreeNode root) {
            //用来完成Morris连接的寻找前驱的指针
            TreeNode tmp = null;
            while (root != null) {
                //左子树不为空
                if (root.left != null) {
                    //1、链接root节点的前驱，他的前驱还没访问，所以root不能现在访问,继续访问root左子树
                    tmp = root.left;
                    while (tmp.right != null && tmp.right != root) {
                        tmp = tmp.right;
                    }
                    //2、root节点访问,并且断开root节点的前驱连接，然后访问root的右子树
                    if (tmp.right == root) {
                        //访问
                        if (pre != null && pre.val > root.val) {
                            // 更新x y
                            if (x == null) x = pre;
                            y = root;
                        }
                        tmp.right = root;
                    }
                    root = root.left;
                }


            }
        }
    }
}
