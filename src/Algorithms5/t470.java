package Algorithms5;

import java.util.Random;

public class t470 {
    class SolBase {
        public int rand7() {
            Random random = new Random();
            return random.nextInt(7);
        }
    }

    class Solution extends SolBase {
        // (rand_X() - 1) × Y + rand_Y() ==> 可以等概率的生成[1, X * Y]范围的随机数
        // 即实现了 rand_XY()
        public int rand10() {
            while (true) {

                // (rand7() - 1) * 7 + rand7() = rand49()
                int num = (rand7() - 1) * 7 + rand7();
                if (num <= 40) return num % 10 + 1;
            }

        }
    }
}
