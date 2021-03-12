package CodingInterview;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class offer41 {
    class MedianFinder {
        Queue<Integer> MaxHeap, MinHeap;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            //大根堆 储存较小的数 返回所有小数里最大的数
            MaxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
            //小根堆 储存较大的数 返回所有大数里的最小数
            MinHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            // 当 m == n（即N为偶数）
            // 需向 MaxHeap 添加一个元素
            // 实现方法：将新元素 num 插入至小根堆MinHeap ，再将 MinHeap 堆顶元素插入至 MaxHeap
            if (MaxHeap.size() == MinHeap.size()) {
                MinHeap.add(num);
                MaxHeap.add(MinHeap.poll());
            }
            // 当 m != n（即N为奇数）
            // 需向 MinHeap 添加一个元素
            // 实现方法：将新元素 num 插入至大根堆MaxHeap ，再将 MaxHeap 堆顶元素插入至 MinHeap
            else {
                MaxHeap.add(num);
                MinHeap.add(MaxHeap.poll());
            }
        }

        public double findMedian() {
            if (MaxHeap.size() == MinHeap.size())
                return (MaxHeap.peek() + MinHeap.peek()) / 2.0;
            else
                return MaxHeap.peek();
        }
    }
}
