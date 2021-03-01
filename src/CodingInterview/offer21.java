package CodingInterview;

import java.util.Arrays;

public class offer21 {

    //首位双指针
    static class Solution {
        public int[] exchange(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] % 2 == 0) {
                    if (nums[right] % 2 == 1)
                        swap(nums, left, right);
                    --right;
                } else {
                    left++;
                }
            }
            return nums;
        }

        //快慢双指针
        public int[] exchange2(int[] nums) {
            //slow 的作用是指向下一个奇数应当存放的位置
            int slow = 0;
            //fast 的作用是向前搜索奇数位置，
            int fast = 0;

            while (fast != nums.length) {
                if (nums[fast] % 2 == 1) {
                    swap(nums, slow, fast);
                    ++slow;
                }
                ++fast;
            }
            return nums;
        }

        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4, 8, 3, 4, 2, 9};
        System.out.println(Arrays.toString(solution.exchange(nums)));
    }
}
