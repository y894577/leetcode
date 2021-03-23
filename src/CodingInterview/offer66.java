package CodingInterview;

import java.util.Arrays;

public class offer66 {
    static class Solution {
        public int[] constructArr(int[] a) {
            if (a.length == 0)
                return new int[0];
            // leftMul为左边数字的累乘
            // rightMul为右边数字的累乘
            int[] leftMul = new int[a.length];
            int[] rightMul = new int[a.length];
            int[] res = new int[a.length];
            leftMul[0] = 1;
            rightMul[a.length - 1] = 1;

            // 进行累次计算leftMul和rightMul
            for (int i = 1; i < a.length; i++) {
                leftMul[i] = leftMul[i - 1] * a[i - 1];
                rightMul[a.length - i - 1] = rightMul[a.length - i] * a[a.length - i];
            }

            //res[i]为左边的累乘和右边的累乘的乘积
            for (int i = 0; i < a.length; i++) {
                res[i] = leftMul[i] * rightMul[i];
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.constructArr(new int[]{1, 2, 3, 4, 5})));
    }
}
