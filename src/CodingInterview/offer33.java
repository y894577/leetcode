package CodingInterview;

public class offer33 {
    class Solution {
        public boolean verifyPostorder(int[] postorder) {
            return recursive(postorder, 0, postorder.length - 1);
        }

        public boolean recursive(int[] postorder, int start, int end) {
            if (start >= end)
                return true;
            int head = postorder[end];
            //划分左右子树 左子树的值都比root小，右子树的值都比root大
            int i = start;
            while (postorder[i] < head)
                i++;

            int j = i;
            //当遍历到postorder[end]时由于相等会自动跳出循环
            while (postorder[i] > head)
                i++;

            return i == end && recursive(postorder, start, j - 1) && recursive(postorder, j, end - 1);
        }
    }
}
