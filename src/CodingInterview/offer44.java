package CodingInterview;

public class offer44 {
    /* 数字范围           数量         位数         占多少位count
        1-9              9            1            9
        10-99            90           2            180
        100-999          900          3            2700
        1000-9999        9000         4            36000  ...
        start-end       9*digit      digit       9*start*digit
        例如 2901 = 9 + 180 + 2700 + 12 即一定是4位数,第12位   n = 12;
        数据为 = 1000 + (12 - 1)/ 4  = 1000 + 2 = 1002
        定位1002中的位置 = (n - 1) %  4 = 3    s.charAt(3) = 2;
    */
    static class Solution {
        public int findNthDigit(int n) {
            int digit = 1;
            long start = 1;
            long count = 9;
            while (count < n) {
                n -= count;
                digit += 1;
                start *= 10;
                count = 9 * start * digit;
            }
            // 确定所求数位所在的数字(start为第0个数字)
            long num = start + (n - 1) / digit;
            // 确定所求数位在 num 的哪一数位
            return Long.toString(num).charAt((n - 1) % digit) - '0';
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findNthDigit(5);
    }
}
