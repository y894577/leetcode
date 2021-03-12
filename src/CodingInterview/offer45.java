package CodingInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class offer45 {
    class Solution {
        // 若拼接字符串 x + y > y + x ，则 x “大于” y
        // 平均时间复杂度O(NlogN) 最坏情况为O(N^2)
        // 空间复杂度O(N)
        public String minNumber(int[] nums) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++)
                list.add(String.valueOf(nums[i]));
            list.sort((o1, o2) -> (o1 + o2).compareTo(o2 + o1));
            StringBuffer buffer = new StringBuffer();
            for (String s : list)
                buffer.append(s);
            return buffer.toString();
        }
    }
}
