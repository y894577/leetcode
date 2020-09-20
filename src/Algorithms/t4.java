package Algorithms;

public class t4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        //让num1<num2 折半时不会发生数组越界
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int k = (length + 1) / 2;
        int left = 0;
        int right = nums1.length;
        int x, y;
        // 折半查找 当left==right时已经查找完毕（对num1）
        while (left < right) {
            //x（num1）折半
            x = left + (right - left + 1) / 2;
            //下标y根据中位数定义通过x获得
            y = k - x;
            //左边永远小于右边，如果不成立则移动游标
            if (nums1[x - 1] > nums2[y]) {
                right = x - 1;
            } else {
                left = left + (right - left + 1) / 2;
            }
        }
        x = left;
        y = k - left;

        int nums1L = (x == 0 ? Integer.MIN_VALUE : nums1[x - 1]);
        int nums1R = (x == nums1.length ? Integer.MAX_VALUE : nums1[x]);
        int nums2L = (y == 0 ? Integer.MIN_VALUE : nums2[y - 1]);
        int nums2R = (y == nums2.length ? Integer.MAX_VALUE : nums2[y]);


//        System.out.println(nums1L + " " + nums1R);
//        System.out.println(nums2L + " " + nums2R);

        double mid;
        if (length % 2 == 0) {
            mid = (Math.max(nums1L, nums2L) + Math.min(nums1R, nums2R)) / 2.0;
        } else {
            mid = Math.max(nums1L, nums2L);
        }
        return mid;
    }

    public static void main(String[] args) {
        int[] num1 = {1, 2};
        int[] num2 = {3, 4};
        findMedianSortedArrays(num1, num2);
    }
}
