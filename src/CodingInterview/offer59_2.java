package CodingInterview;

import java.util.Deque;
import java.util.LinkedList;
import java.util.logging.Level;

public class offer59_2 {
    class MaxQueue {
        Deque<Integer> queue;
        Deque<Integer> index;

        public MaxQueue() {
            this.queue = new LinkedList<>();
            this.index = new LinkedList<>();
        }

        // 获取最大值
        public int max_value() {
            if (queue.isEmpty())
                return -1;
            else
                return queue.getFirst();
        }

        // 队尾插入元素
        public void push_back(int value) {

        }

        // 弹出队首元素
        public int pop_front() {
            return 0;
        }
    }
}

