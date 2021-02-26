package CodingInterview;

import java.util.Deque;
import java.util.LinkedList;

public class offer09 {
    class CQueue {

        //入队
        Deque<Integer> s1;
        //出队
        Deque<Integer> s2;

        public CQueue() {
            s1 = new LinkedList<>();
            s2 = new LinkedList<>();
        }

        //在队列尾部插入整数
        public void appendTail(int value) {
            s1.push(value);
        }

        //在队列头部删除整数
        public int deleteHead() {
            if (s2.isEmpty())
                while (!s1.isEmpty())
                    s2.push(s1.pop());
            if (s2.isEmpty())
                return -1;
            else
                return s2.pop();

        }
    }
}
