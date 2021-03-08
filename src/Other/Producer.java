package Other;

import com.lmax.disruptor.RingBuffer;

import java.nio.ByteBuffer;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Producer {
    private final RingBuffer<PCData> ringBuffer;

    public Producer(RingBuffer<PCData> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void pushData(ByteBuffer bb) {
        //下一个可用序列号
        int sequence = (int) ringBuffer.next();
        try {
            //取得下一个空闲可用PCData对象
            PCData event = ringBuffer.get(sequence);
            event.setIntData(bb.getInt(0));
        } finally {
            System.out.println("publish data " + bb.getInt(0));
            //数据发布
            ringBuffer.publish(sequence);
        }
    }
}
