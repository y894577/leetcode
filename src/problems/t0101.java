package problems;

public class t0101 {
    class Solution {
        // 位运算
        public boolean isUnique(String astr) {
            int mark = 0;
            char[] chars = astr.toCharArray();
            // 此处位运算相当于bool数组
            for (char c : chars) {
                if ((mark & 1 << (c - 'a')) == 0)
                    mark |= 1 << (c - 'a');
                else
                    return false;
            }
            return true;
        }
    }
}
