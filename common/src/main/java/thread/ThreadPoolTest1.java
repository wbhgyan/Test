package thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPoolTest1 {

        public static void main(String[] args) {
            BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(100);
            ThreadFactory factory = r -> {
                Thread thread = new Thread(r, "test-thread-pool");
                thread.setDaemon(true);
                return thread;
            };
            ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10,
                    1L, TimeUnit.SECONDS, queue, factory, new ThreadPoolExecutor.AbortPolicy());
            System.out.println("活动的线程数"+executor.getPoolSize());
            System.out.println("活动的线程数"+executor.getActiveCount());
            AtomicInteger i=new AtomicInteger(0);
            CountDownLatch count=new CountDownLatch(80);
            while (true) {
                i.incrementAndGet();
                if(i.get()==81)break;
                executor.submit(() -> {
                    try {
                        System.out.println(i);
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //count.countDown();
                });

            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            try {
//                count.await();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            executor.shutdown();
            System.out.println("活动的线程数"+executor.getPoolSize());
            System.out.println("活动的线程数"+executor.getActiveCount());


//            System.out.println(executor.isShutdown());

    }
}
