package Algorithms5;

import java.util.LinkedList;
import java.util.Queue;

public class t225 {
    class MyStack {
        Queue<Integer> q1;
        Queue<Integer> q2;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            if (!q1.isEmpty()) {
                q1.add(x);
            } else {
                q2.add(x);
            }
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            if (!q1.isEmpty()) {
                int x;
                while (!q1.isEmpty()) {
                    x = q1.poll();
                    if (q1.isEmpty())
                        return x;
                    q2.add(x);
                }
            } else {
                int x;
                while (!q2.isEmpty()) {
                    x = q2.poll();
                    if (q2.isEmpty())
                        return x;
                    q1.add(x);
                }
            }
            return -1;
        }

        /**
         * Get the top element.
         */
        public int top() {
            int x = -1;
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    x = q1.poll();
                    q2.add(x);
                }
            } else {
                while (!q2.isEmpty()) {
                    x = q2.poll();
                    q1.add(x);
                }
            }
            return x;
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return q1.isEmpty() && q2.isEmpty();
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
}
