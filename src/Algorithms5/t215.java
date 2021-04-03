package Algorithms5;

public class t215 {
    static class Solution {
        public int findKthLargest(int[] nums, int k) {
            k = nums.length - k;
            int index = nums[0];
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                index = nums[left];
                while (left < right) {
                    while (left < right && nums[right] >= index) {
                        --right;
                    }
                    nums[left] = nums[right];
                    while (left < right && nums[left] <= index) {
                        ++left;
                    }
                    nums[right] = nums[left];
                }
                nums[left] = index;
                if (k == left)
                    return nums[left];
                else if (k > left) {
                    left = left + 1;
                    right = nums.length - 1;
                } else {
                    right = left - 1;
                    left = 0;
                }
            }
            return -1;
        }

        public void swap(int[] nums, int a, int b) {
            int i = nums[a];
            nums[a] = nums[b];
            nums[b] = i;
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 4, 1, 3, 6, 0};
        int k = 4;
        Solution solution = new Solution();
        System.out.println(solution.findKthLargest(nums, k));
    }
}
