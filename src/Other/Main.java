package Other;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.SleepingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Executor executor = Executors.newCachedThreadPool();
        PCDataFactory factory = new PCDataFactory();
        int bufferSize = 1024;
        Disruptor<PCData> disruptor = new Disruptor<PCData>(factory,
                bufferSize,
                executor,
                ProducerType.MULTI,
                new SleepingWaitStrategy());
        disruptor.handleEventsWithWorkerPool(new Consumer(), new Consumer(), new Consumer());
        disruptor.start();

        RingBuffer<PCData> ringBuffer = disruptor.getRingBuffer();
        Producer producer = new Producer(ringBuffer);
        ByteBuffer bb = ByteBuffer.allocate(4);
        for (int i = 0; i < 20; i++) {
            bb.putInt(0, i);
            producer.pushData(bb);
            Thread.sleep(100);
            System.out.println("add data " + i);
        }
    }

}
