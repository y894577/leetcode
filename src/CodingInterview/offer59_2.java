package CodingInterview;

import java.util.Deque;
import java.util.LinkedList;
import java.util.logging.Level;

public class offer59_2 {
    class MaxQueue {
        Deque<Integer> queue;
        Deque<Integer> deque;

        public MaxQueue() {
            this.queue = new LinkedList<>();
            this.deque = new LinkedList<>();
        }

        // 获取最大值
        public int max_value() {
            if (deque.isEmpty())
                return -1;
            else
                return deque.getFirst();
        }

        // 队尾插入元素
        public void push_back(int value) {
            while (!deque.isEmpty() && value > deque.getLast()) {
                deque.pollLast();
            }
            queue.offerLast(value);
            deque.offerLast(value);
        }

        // 弹出队首元素
        public int pop_front() {
            if (queue.isEmpty())
                return -1;
            if (queue.getFirst().equals(deque.getFirst()))
                deque.pollFirst();
            return queue.pollFirst();
        }
    }
}

