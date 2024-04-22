package com.piyush.joshi.reentrantlock;


import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ResourceManager resourceManager = new ResourceManager();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Task thread1 = new Task("thread 1", "key1", "value1", resourceManager, 10000l);
        Task thread2 = new Task("thread 2", "key2", "value2", resourceManager, 0l);
        Task thread3 = new Task("thread 3", "key3", "value3", resourceManager, 1000l);
//        thread1.start();
        executorService.submit(thread1);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        thread2.start();
//        thread3.start();
        executorService.submit(thread2);
        executorService.submit(thread3);
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("shutting down executorservice");
        executorService.shutdown();

    }
}
