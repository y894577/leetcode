package Algorithms3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class t139 {
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            boolean[] dp = new boolean[s.length() + 1];
            Set<String> set = new HashSet<>(wordDict);
            dp[0] = true;
            // dp[i] 表示 s 中以 i - 1 结尾的字符串是否可被 wordDict 拆分
            for (int i = 1; i < s.length(); i++) {
                for (int j = 0; j < i; j++) {
                    if (dp[j] && set.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[s.length()];
        }
    }
}
