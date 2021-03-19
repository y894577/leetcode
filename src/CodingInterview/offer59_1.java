package CodingInterview;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class offer59_1 {
    static class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int[] arr = new int[nums.length - k + 1];
            if (nums.length >= k && k >= 1) {
                Deque<Integer> queue = new LinkedList<>();
                for (int i = 0; i < nums.length; i++) {
                    // 如果队尾元素小于目前元素，则队尾元素不可能成为最大元素
                    // 因此队尾元素出队列
                    while (!queue.isEmpty() && nums[queue.getLast()] <= nums[i])
                        queue.pollLast();

                    if (i < k - 1) {
                        // 还没到滑动窗口
                        // 向队尾添加元素
                        queue.offerLast(i);
                    } else {
                        // 窗口开始滑动
                        // 判断队首元素是否出队列
                        if (!queue.isEmpty() && i - k == queue.getFirst())
                            queue.pollFirst();
                        // 向队尾添加元素
                        queue.offerLast(i);
                        // 向数组填充当前窗口最大值，即队首元素
                        arr[i - k + 1] = nums[queue.getFirst()];
                    }
                }
            }
            return arr;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-7, -8, 7, 5, 7, 1, 6, 0};
        int[] ints = solution.maxSlidingWindow(nums, 4);
        System.out.println(Arrays.toString(ints));
    }
}