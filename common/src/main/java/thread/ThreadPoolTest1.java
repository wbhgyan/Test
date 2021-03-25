package thread;

import java.util.concurrent.*;

public class ThreadPoolTest1 {

        public static void main(String[] args) {
            BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(100);
            ThreadFactory factory = r -> new Thread(r, "test-thread-pool");
            ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10,
                    3L, TimeUnit.SECONDS, queue, factory, new ThreadPoolExecutor.AbortPolicy());
            int i=0;
            while (true) {
                i++;
                executor.submit(() -> {
                    try {
                        System.out.println(queue.size());
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                if(i==80)break;
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("活动的线程数"+executor.getPoolSize());
            System.out.println("活动的线程数"+executor.getActiveCount());
            executor.shutdownNow();
            System.out.println(executor.isShutdown());

    }
}
