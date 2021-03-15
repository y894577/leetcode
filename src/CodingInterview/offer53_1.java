package CodingInterview;

public class offer53_1 {
    class Solution {
        public int search(int[] nums, int target) {
            if (nums.length == 0)
                return 0;
            return binarySearch(nums, target, 0, nums.length - 1);
        }

        public int binarySearch(int[] nums, int target, int left, int right) {
            if (left >= right)
                return nums[left] == target ? 1 : 0;
            int mid = (left + right) / 2;
            return (nums[mid] >= target ? binarySearch(nums, target, left, mid) : 0)
                    + (nums[mid + 1] <= target ? binarySearch(nums, target, mid + 1, right) : 0);
        }
    }
}
