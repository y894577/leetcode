package CodingInterview;

public class offer11 {
    //二分查找 时间复杂度 O(log2n)
    public static int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        int middle;
        while (left < right) {
            middle = left + (right - left) / 2;
            //旋转点一定在右边
            if (numbers[middle] > numbers[right])
                left = middle + 1;
                //旋转点一定在左边
            else if (numbers[middle] < numbers[right])
                right = middle;
                // 旋转点无法判断 右边有：情况1 --- 情况2 -v-
                // 实际上，当出现 nums[m] = nums[j] 时
                // 一定有区间 [i, m] 内所有元素相等 或 区间 [m, j] 内所有元素相等（或两者皆满足）
                // 对于寻找此类数组的最小值问题，可直接放弃二分查找，而使用线性查找替代。
            else {
                int i = left;
                for (int j = left + 1; j < right; j++) {
                    if (numbers[j] < numbers[i])
                        i = j;
                }
                return numbers[i];
            }
        }
        return numbers[left];
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(minArray(nums));
    }
}
