package Algorithms3;

public class t152 {
    class Solution {
        public int maxProduct(int[] nums) {
            int imax = 1;
            int imin = 1;
            int res = Integer.MIN_VALUE;
            for (int i = 0; i < nums.length; i++) {
                imax = Math.max(nums[i], imax * nums[i]);
                imin = Math.min(nums[i], imin * nums[i]);
                if (nums[i] < 0) {
                    int temp = imax;
                    imax = imin;
                    imin = temp;
                }
                res = Math.max(res, imax);
            }
            return res;
        }
    }
}
