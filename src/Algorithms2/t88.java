package Algorithms2;

import java.util.Arrays;

public class t88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        m = m - 1;
        n = n - 1;
        int length = nums1.length - 1;
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[length] = nums1[m];
                m--;
            } else {
                nums1[length] = nums2[n];
                n--;
            }
            length--;
        }
        System.arraycopy(nums2, 0, nums1, 0, n + 1);
    }

    public static void main(String[] args) {
//        int[] nums1 = {1, 2, 3, 0, 0, 0};
//        int m = 3;
//        int[] nums2 = {2, 5, 6};
//        int n = 3;
        int[] nums1 = {2, 0};
        int m = 1;
        int[] nums2 = {1};
        int n = 1;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
