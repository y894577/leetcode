package CodingInterview;

import java.util.Deque;
import java.util.LinkedList;

public class offer30 {
    static class MinStack {

        /**
         * initialize your data structure here.
         */

        // 数据栈
        Deque<Integer> s1;
        // 辅助栈
        Deque<Integer> s2;

        public MinStack() {
            s1 = new LinkedList<>();
            s2 = new LinkedList<>();
        }

        public void push(int x) {
            s1.push(x);
            if (s2.isEmpty() || s2.peek() > x)
                s2.push(x);
            else
                s2.push(s2.peek());
        }

        public void pop() {
            if (s1.size() > 0 && s2.size() > 0) {
                s1.pop();
                s2.pop();
            }
        }

        public int top() {
            return s1.peek();
        }

        public int min() {
            return s2.peek();
        }
    }

    public static void main(String[] args) {
        //Your MinStack object will be instantiated and called as such:
        MinStack obj = new MinStack();
        obj.push(1);
        obj.push(2);
        obj.push(4);
        obj.push(3);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.min();

    }

}
