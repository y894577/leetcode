package TopInterviewQuestionsEasy.array;

import java.util.Arrays;

public class rotate {
    public static void rotate(int[] nums, int k) {
        int n = nums.length - 1;
        k = k % nums.length - 1;
        reverse(nums, 0, n);
        reverse(nums, 0, k);
        reverse(nums, k + 1, n);
    }

    public static void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            ++l;
            --r;
        }
    }

    public static void rotate2(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        //求最大公约数
        int m = rem(n, k);
        int count = 0;
        for (int i = 0; i < m; i++) {
            int start = i;
            int flag = nums[start];
            do {
                int end = (start + k) % n;
                int temp = nums[end];
                nums[end] = flag;
                flag = temp;
                start = end;
            } while (start != i);
        }
    }

    public static int rem(int m, int n) {
        int rem;
        while (n > 0) {
            rem = m % n;
            m = n;
            n = rem;
        }
        return m;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        rotate2(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
