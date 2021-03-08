package Other;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import com.lmax.disruptor.*;

public class Consumer implements WorkHandler<PCData> {
    @Override
    public void onEvent(PCData pcData) throws Exception {
        System.out.println(Thread.currentThread().getId() + "：Event：--" + pcData.getIntData() * 2 + "--");

    }
}
