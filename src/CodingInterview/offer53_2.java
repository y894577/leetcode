package CodingInterview;

public class offer53_2 {
    static class Solution {
        // 异或运算
        public int missingNumber(int[] nums) {
            int res = nums.length;
            // 任何数与0异或等于它本身，即a^0=a
            // 一个数与自己异或结果为0，即a^a=0
            // 令0~n的数与nums中的数异或
            // 运算中除了缺失值只出现一次外，其他数都出现两次等同于与自身异或
            for (int i = 0; i < nums.length; i++) {
                // 相同的数字异或为0
                nums[i] ^= i;
                // 0 1 2 3 4
                // 0 1 3 4 5
                // 5 5 5 5 5
                res ^= nums[i];
            }
            return res;
        }

        // 二分查找
        public int missingNumber2(int[] nums) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == mid)
                    left = mid + 1;
                else
                    right = mid - 1;
            }
            return left;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.missingNumber2(new int[]{0, 1, 2, 3, 4, 5, 7}));
    }
}
