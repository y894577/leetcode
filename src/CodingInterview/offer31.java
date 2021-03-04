package CodingInterview;

import java.util.Deque;
import java.util.LinkedList;

public class offer31 {
    static class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Deque<Integer> stack = new LinkedList<>();
            int p = 0;
            for (int i = 0; i < pushed.length; i++) {
                stack.push(pushed[i]);
                while (!stack.isEmpty() && stack.peek() == popped[p]) {
                    ++p;
                    stack.pop();
                }
            }
            return stack.isEmpty();
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            int[] pushed = new int[]{1, 2, 3, 4, 5};
            int[] popped = new int[]{4, 3, 5, 1, 2};
            System.out.println(solution.validateStackSequences(pushed, popped));
        }
    }
}
