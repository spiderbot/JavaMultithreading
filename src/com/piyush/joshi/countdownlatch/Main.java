package com.piyush.joshi.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);
        Worker thread1 = new Worker("worker1",latch);
        Worker thread2 = new Worker("worker2",latch);

        thread1.start();
        thread2.start();
        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("thread " + Thread.currentThread().getName() + " resumed operation");
        Master masterThread = new Master("master");
        masterThread.start();
    }
}