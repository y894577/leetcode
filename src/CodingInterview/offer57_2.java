package CodingInterview;

import java.util.*;

public class offer57_2 {
    static class Solution {

        // 双指针 时间O(target)
        public int[][] findContinuousSequence(int target) {
            Deque<int[]> res = new LinkedList<>();
            int length = 2;
            int left = target / 2;
            int right = (target / 2) + 1;
            while (left > 0) {
                int result = (left + right) * (length / 2) + (length % 2 == 1 ? (left + right) / 2 : 0);
                if (result < target)
                    left--;
                else if (result > target)
                    right--;
                else {
                    int[] arr = new int[length];
                    int index = 0;
                    for (int i = left; i <= right; i++)
                        arr[index++] = i;
                    res.addFirst(arr);
                    right--;
                    left = right - length;
                }


                length = right - left + 1;
            }
            return res.toArray(new int[res.size()][]);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = solution.findContinuousSequence(9);
        for (int[] ints : arr) {
            System.out.println(Arrays.deepToString(arr));
        }
    }
}
