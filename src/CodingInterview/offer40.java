package CodingInterview;

import java.util.*;

public class offer40 {
    static class Solution {

        // 快速排序 时间O(N) 空间O(1)
        public int[] getLeastNumbers(int[] arr, int k) {
            quick(arr, k, 0, arr.length - 1);
            return Arrays.copyOf(arr, k);
        }

        public void quick(int[] nums, int k, int start, int end) {
            if (start > end)
                return;
            int stand = nums[start];
            int i = start, j = end;
            while (i < j) {
                while (i < j && nums[j] >= stand)
                    j--;
                while (i < j && nums[i] <= stand)
                    i++;
                swap(nums, i, j);
            }
            swap(nums, start, i);
            if (i > k) quick(nums, k, start, i - 1);
            else if (i < k) quick(nums, k, i + 1, end);
        }

        public void swap(int[] arr, int i, int j) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

        // 大根堆 时间O(NlogK) 空间O(K)
        public int[] getLeastNumbers2(int[] arr, int k) {
            if (k == 0 || arr.length == 0) {
                return new int[0];
            }

            // 默认是小根堆，实现大根堆需要重写一下比较器。
            // new Comparator<Integer>(){
            //      @Override
            //      public int compare（Integer o1,Integer o2）{ return o2 - o1; }
            // }
            Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);


            // 保持堆的大小为K，然后遍历数组中的数字，遍历的时候做如下判断：
            // 1. 若目前堆的大小小于K，将当前数字放入堆中。
            // 2. 否则判断当前数字与大根堆堆顶元素的大小关系，如果当前数字比大根堆堆顶还大，这个数就直接跳过；
            //    反之如果当前数字比大根堆堆顶小，先poll掉堆顶，再将该数字放入堆中。
            for (int num : arr) {
                if (pq.size() < k) {
                    pq.offer(num);
                } else if (num < pq.peek()) {
                    pq.poll();
                    pq.offer(num);
                }
            }

            // 返回堆中的元素
            int[] nums = new int[pq.size()];
            for (int i = 0; i < pq.size(); i++) {
                nums[i] = pq.poll();
            }
            return nums;
        }

        // 二叉搜索树 时间O(NlogK) 空间O(K)
        public int[] getLeastNumbers3(int[] arr, int k) {
            if (k == 0 || arr.length == 0) {
                return new int[0];
            }
            // TreeMap的key是数字, value是该数字的个数。
            // cnt表示当前map总共存了多少个数字。
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int cnt = 0;
            for (int num: arr) {
                // 1. 遍历数组，若当前map中的数字个数小于k，则map中当前数字对应个数+1
                if (cnt < k) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                    cnt++;
                    continue;
                }
                // 2. 否则，取出map中最大的Key（即最大的数字), 判断当前数字与map中最大数字的大小关系：
                //    若当前数字比map中最大的数字还大，就直接忽略；
                //    若当前数字比map中最大的数字小，则将当前数字加入map中，并将map中的最大数字的个数-1。
                Map.Entry<Integer, Integer> entry = map.lastEntry();
                if (entry.getKey() > num) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                    if (entry.getValue() == 1) {
                        map.pollLastEntry();
                    } else {
                        map.put(entry.getKey(), entry.getValue() - 1);
                    }
                }

            }

            // 最后返回map中的元素
            int[] res = new int[k];
            int idx = 0;
            for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
                int freq = entry.getValue();
                while (freq-- > 0) {
                    res[idx++] = entry.getKey();
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.getLeastNumbers(new int[]{3, 2, 0}, 2)));
    }
}
