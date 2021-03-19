package Algorithms5;

public class t1539 {
    static class Solution {
        public int findKthPositive(int[] arr, int k) {
            if (arr[0] > k)
                return k;
            int left = 0;
            int right = arr.length;
            int mid;
            int empty;
            while (left < right) {
                mid = (left + right) / 2;
                empty = arr[mid] - mid - 1;
                if (empty < k)
                    left = mid + 1;
                else
                    right = mid;
            }
            // empty = arr[i] - i - 1 表示目前一共缺的数字个数
            // 当 empty == k 的时候，即找到第k个缺的数字
            // ==> arr[i] - 1 == k + i
            // return  arr[left - 1](左边界下标缺的数字个数) + k - empty(注意是左边界，i = left - 1)
            // 整理可得：return k + left
            return arr[left - 1] + k - (arr[left - 1] - (left - 1) - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;
        int kthPositive = solution.findKthPositive(arr, k);
        System.out.println(kthPositive);
    }
}
