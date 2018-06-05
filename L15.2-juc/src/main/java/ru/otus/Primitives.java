package ru.otus;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class Primitives {
    public static final Logger log = LoggerFactory.getLogger(Primitives.class);

    public static void main(String[] args)  throws Exception {
//        _countDownLatch();
        _semaphore();
    }

    public static final int PERMITS = 2;

    static void _semaphore() throws Exception {
        Semaphore s = new Semaphore(PERMITS);

        Runnable rRunnable = () -> {
            try {
                log.info("Acquiring...");
                s.acquire(PERMITS); // lock

                Thread.sleep(TimeUnit.MILLISECONDS.toMillis(3000));
                log.info("Acquired");

                s.release(); // unlock
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        Thread t1 = new Thread(rRunnable);
        Thread t2 = new Thread(rRunnable);
        Thread t3 = new Thread(rRunnable);
        t1.start();
        t2.start();
        t3.start();
    }

    static void _countDownLatch() {
        CountDownLatch latch = new CountDownLatch(3);

        Runnable r = () -> {
            latch.countDown();
            log.info("Count down");


            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("Continue");

        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();


        try {
            Thread.sleep(1000);
            System.out.println("Start!");
            latch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
