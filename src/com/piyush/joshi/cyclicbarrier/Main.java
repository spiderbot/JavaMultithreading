package com.piyush.joshi.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("all threads resumed");
            }
        });
        Task task1 = new Task("task1", barrier);
        Task task2 = new Task("task2", barrier);

        task1.start();
        task2.start();
    }
}
