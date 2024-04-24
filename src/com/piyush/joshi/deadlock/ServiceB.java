package com.piyush.joshi.deadlock;

import java.util.concurrent.locks.Lock;

public class ServiceB {
    Lock lock1;
    Lock lock2;
    ServiceB(Lock lock1, Lock lock2){
        this.lock1 = lock1;
        this.lock2 = lock2;
    }
    public void process(){
        System.out.println("going to acquire lock2 by serviceB");
        lock2.lock();
        System.out.println("acquired lock2 by serviceB");
        System.out.println("thread going to sleep");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("going to acquire lock1 by serviceB");
        lock1.lock();
        System.out.println("acquired lock1 by serviceB");
        System.out.println("going to release lock1 by serviceB");
        lock1.unlock();
        System.out.println("lock1 released by serviceB");
        System.out.println("going to release lock2 by serviceB");
        lock2.unlock();
        System.out.println("lock2 released by serviceB");
    }
}
