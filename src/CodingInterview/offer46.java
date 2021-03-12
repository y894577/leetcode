package CodingInterview;

public class offer46 {
    static class Solution {
        public int translateNum(int num) {
            //char[] chars = String.valueOf(num).toCharArray();
            //return back(0,chars,0);

            // dp解法
            String s = String.valueOf(num);
            int[] dp = new int[s.length() + 1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= s.length(); i++) {
                String temp = s.substring(i - 2, i);
                if (temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0)
                    dp[i] = dp[i - 1] + dp[i - 2];
                else
                    dp[i] = dp[i - 1];
            }
            return dp[s.length()];
        }


        // 递归解法
        public int back(int index, char[] num, int count) {
            if (index == num.length)
                return count + 1;
            else if (index == num.length + 1)
                return count;
            else {
                if (num[index] == '1') {
                    return back(index + 1, num, count) + back(index + 2, num, count);
                } else if (num[index] == '2') {
                    if (index + 1 < num.length && num[index + 1] >= '0' && num[index + 1] <= '5')
                        return back(index + 1, num, count) + back(index + 2, num, count);
                    else
                        return back(index + 1, num, count);
                } else {
                    return back(index + 1, num, count);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.translateNum(115));
    }
}
