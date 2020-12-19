package Algorithms2;

public class t81 {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid])
                return true;
            if (nums[mid] < nums[right]) {
                //右边有序
                if (nums[mid] < target && nums[right] >= target)
                    left = mid + 1;
                else
                    right = mid;
            } else if (nums[mid] > nums[left]) {
                //左边有序
                if (nums[left] <= target && nums[mid] >= target)
                    right = mid;
                else
                    left = mid + 1;
            }
            else if (nums[mid] == nums[left])
                left++;
            else if(nums[mid] == nums[right])
                right--;
        }
        return false;
    }


    public static void main(String[] args) {
        t81 solution = new t81();
//        int[] nums = {2, 5, 6, 7, 0, 1, 2};
//        int[] nums = {1};
        int[] nums = {3, 5, 1};
        System.out.println(solution.search(nums, 1));
    }
}
