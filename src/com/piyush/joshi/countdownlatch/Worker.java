package com.piyush.joshi.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Worker extends Thread{

    String name;
    CountDownLatch latch;

    Worker(String name, CountDownLatch latch){
        super(name);
        this.name = name;
        this.latch = latch;
    }
    public void run(){
        try{
            System.out.println("starting thread " + Thread.currentThread().getName());
            Thread.sleep(5000);
            latch.countDown();
        }catch(InterruptedException ie){

        }
        System.out.println("exiting thread " + Thread.currentThread().getName());

    }
}
