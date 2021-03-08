package Other;

import java.util.concurrent.*;

public class ReentrantLockImpl {
    static class MyTask implements Runnable {
//        public static ReentrantLock lock = new ReentrantLock();
//        public static Condition condition = lock.newCondition();

        public String name;

        MyTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                System.out.println("Thread " + name + " is going on");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public static void main(String[] args) throws InterruptedException, ExecutionException {
            ThreadPoolExecutor es = new ThreadPoolExecutor(5, 5, 0L,
                    TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<>()) {
                @Override
                protected void beforeExecute(Thread t, Runnable r) {
                    System.out.println("before " + ((MyTask) r).name);
                }

                @Override
                protected void afterExecute(Runnable r, Throwable t) {
                    System.out.println("after " + ((MyTask) r).name);
                }

                @Override
                protected void terminated() {
                    System.out.println("ThreadPool close");
                }
            };


//            ThreadPoolExecutor pools = new ThreadPoolExecutor(0,Integer.MAX_VALUE,0L,TimeUnit.SECONDS,
//                    new SynchronousQueue<Runnable>());
            for (int i = 0; i < 5; i++) {
                MyTask task = new MyTask("NO" + i);
//                FutureTask submit = (FutureTask) es.submit(task);
//                submit.get();
                es.execute(task);
                Thread.sleep(10);
            }
            es.shutdown();
        }
    }
}
