package Algorithms3;

public class t153 {
    static class Solution {
        public int findMin(int[] nums) {
            return binarySearch(nums, 0, nums.length - 1);
        }

        public int binarySearch(int[] nums, int left, int right) {
            if (left == right)
                return nums[left];
            int mid = (left + right) / 2;

            if (nums[mid] < nums[right]) {
                // mid 可能为最小值
                return binarySearch(nums, left, mid);
            } else {
                // mid 一定不是最小值
                return binarySearch(nums, mid + 1, right);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        Solution solution = new Solution();
        System.out.println(solution.findMin(nums));
    }
}
