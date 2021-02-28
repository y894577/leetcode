package CodingInterview;


public class offer17 {

    static class Solution {
        int n;

        //每一层当前的数字
        //eg：int [] num = {1,0,3} ==> 通过String.valueOf ==> String num = "103"
        char[] num;

        //设数字各位中 9 的数量为 nine
        //所有位都为9：n - start = nine
        int nine = 0;

        // start 规定字符串的左边界
        int start;

        public String printNumbers(int n) {
            this.n = n;
            this.num = new char[n];
            this.start = n - 1;
            StringBuilder builder = new StringBuilder();
            dfs(builder, 0);
            return builder.toString();
        }

        public void dfs(StringBuilder res, int layer) {
            if (layer == n) {
                //截取字符串，从start开始，截取掉前面的0
                String s = String.valueOf(num).substring(start);
                res.append(s + " ");
                //全都是9，需要进位，start边界左移
                if (nine == n - start)
                    --start;
                return;
            }

            for (int i = 0; i <= 9; i++) {
                if (i == 9) ++nine;
                num[layer] = (char) (i + '0');
                dfs(res, layer + 1);
            }
            --nine;
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(solution.printNumbers(3));
        }
    }

}
