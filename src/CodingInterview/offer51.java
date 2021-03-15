package CodingInterview;

import java.lang.reflect.Array;
import java.util.Arrays;

public class offer51 {
    static class Solution {

        //
        public int reversePairs(int[] nums) {
            return mergeSort(0, nums.length - 1, nums, new int[nums.length]);
        }

        // 归并排序
        // l和r分别指向元素的首尾
        public int mergeSort(int l, int r, int[] nums, int[] sorted) {
            if (l >= r) return 0;
            // 划分数组
            int m = (l + r) / 2;
            int res = mergeSort(l, m, nums, sorted) + mergeSort(m + 1, r, nums, sorted);

            int i = l, j = m + 1;
            // 合并数组
            int index = l;
            // 辅助数组tmp，暂存nums数组
            for (int k = l; k <= r; k++) {
                sorted[k] = nums[k];
            }
            while (index <= r) {
                if (i == m + 1)
                    nums[index++] = sorted[j++];
                else if (j == r + 1) {
                    nums[index++] = sorted[i++];
                } else {
                    if ((sorted[i] > sorted[j])) {
                        // 如果右边数组的当前元素小于左边数组的当前元素
                        // 则左边数组余下的数都比右边数组当前数大
                        // 因此res需要加上左边数组余下的数的个数
                        res += m - i + 1;
                        nums[index++] = sorted[j++];
                    } else {
                        nums[index++] = sorted[i++];
                    }
                }
            }
            return res;
        }

        // 离散化树状数组
        // 假设a = {5,5,2,3,6}，那么遍历这个序列得到的桶是这样的：
        // index  ->  1 2 3 4 5 6 7 8 9
        // value  ->  0 1 1 0 2 1 0 0 0
        // 说明：index是元素，value是元素出现的次数
        public int reversePairs2(int[] nums) {
            int n = nums.length;
            // nums为原数组 tmp为辅助数组
            int[] tmp = new int[n];
            System.arraycopy(nums, 0, tmp, 0, n);
            // 离散化数组
            // 离散化的目的是让原来分布零散的值聚集到一起，减少空间浪费
            // 离散化一个序列的前提是我们只关心这个序列里面元素的相对大小，而不关心绝对大小
            // 我们可以对原序列排序后去重，对于每一个nums[i]
            // 通过二分查找的方式计算排名作为离散化之后的值。
            Arrays.sort(tmp);
            for (int i = 0; i < n; i++) {
                // 二分查找 找到tmp的索引值+1
                // 返回的是已经排序的tmp数组的索引值，即返回nums[i]在数组的排名
                nums[i] = Arrays.binarySearch(tmp, nums[i]) + 1;
            }
            // 离散化之后nums的值为原数组nums[i]在原数组中出现的排名（即相对排名）
            // 我们只需要nums的相对排名，原本的数值不影响计算结果，故直接覆盖

            // 统计树状数组的逆序对
            BIT bit = new BIT(n);
            int ans = 0;
            // 那么我们可以从后往前遍历序列nums，记当前遍历到的元素为nums[i]
            // 我们把nums[i]对应的桶的值自增 1，把i−1位置的前缀和加入到答案中算贡献
            for (int i = n - 1; i >= 0; i--) {
                // 先查询 nums[i-1] 的前缀和
                // 第 i-1 位的前缀和表示「有多少个数比 i 小」
                ans += bit.query(nums[i] - 1);

                //
                bit.update(nums[i]);
            }
            return ans;
        }

        static class BIT {
            // 前缀和
            private int[] tree;
            private int n;

            public BIT(int n) {
                this.n = n;
                this.tree = new int[n + 1];
            }

            // 将两边的数转换为二进制位，然后运算最终值
            // 运算规则：1&1=1 , 1&0=0 , 0&1=0 , 0&0=0
            // 所输入十进制数转化成二进制数后第一个不为零的位置所代表的大小
            public static int lowbit(int x) {
                return x & (-x);
            }

            // 区间查询
            // 查询序列[1...i]区间的区间和，即i位置的前缀和
            // 后半部部分已经遍历过（已入桶），前半部分是待遍历的（未入桶）
            // 那么我们求到的 i−1 位置的前缀和就是「已入桶」的元素中比 i 小的元素的个数总和
            public int query(int x) {
                int ret = 0;
                while (x != 0) {
                    ret += tree[x];
                    x -= lowbit(x);
                }
                return ret;
            }

            // 单点更新
            // 把序列 x 位置以及后面的数字加上1
            // 后面的前缀和+1表示
            public void update(int x) {
                while (x <= n) {
                    ++tree[x];
                    x += lowbit(x);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reversePairs(new int[]{7, 5, 6, 4}));
    }
}
