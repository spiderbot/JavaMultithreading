package com.piyush.joshi.deadlock;

import java.util.concurrent.locks.Lock;

public class ServiceA {

    Lock lock1;
    Lock lock2;
    ServiceA(Lock lock1, Lock lock2){
        this.lock1 = lock1;
        this.lock2 = lock2;
    }
    public void process(){
        System.out.println("going to acquire lock1 by serviceA");
        lock1.lock();
        System.out.println("acquired lock1 by serviceA");
        System.out.println("thread going to sleep");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("going to acquire lock2 by serviceA");
        lock2.lock();
        System.out.println("acquired lock2 by serviceA");
        System.out.println("going to release lock2 by serviceA");
        lock2.unlock();
        System.out.println("lock2 released by serviceA");
        System.out.println("going to release lock1 by serviceA");
        lock1.unlock();
        System.out.println("lock1 released by serviceA");
    }

}
