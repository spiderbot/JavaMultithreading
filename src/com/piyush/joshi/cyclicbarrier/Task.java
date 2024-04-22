package com.piyush.joshi.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Task extends Thread {

    CyclicBarrier cyclicBarrier;

    Task(String name, CyclicBarrier cyclicBarrier) {
        super(name);
        this.cyclicBarrier = cyclicBarrier;
    }

    public void run() {
        System.out.println("starting thread " + Thread.currentThread().getName());
        try {
            cyclicBarrier.await();
            System.out.println("Thread " + Thread.currentThread().getName() + " resumed execution");
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
