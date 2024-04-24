package com.piyush.joshi.deadlockfree;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class ServiceB {
    Lock lock1;
    Lock lock2;
    ServiceB(Lock lock1, Lock lock2){
        this.lock1 = lock1;
        this.lock2 = lock2;
    }
    public void process() throws InterruptedException {
        System.out.println("going to acquire lock2 by serviceB");
        if(lock2.tryLock())
        {
            System.out.println("acquired lock2 by serviceB");
            System.out.println("thread going to sleep");
            try{
                Thread.sleep(1000);
                System.out.println("going to acquire lock1 by serviceB");
                if(lock1.tryLock()){
                    try{
                        System.out.println("acquired lock1 by serviceB");
                        System.out.println("going to release lock1 by serviceB");
                        lock1.unlock();
                        System.out.println("lock1 released by serviceB");
                        System.out.println("going to release lock2 by serviceB");
                        lock2.unlock();
                        System.out.println("lock2 released by serviceB");
                    }finally{
//                        lock1.unlock();
                    }
                }else{
                    System.out.println("unable to acquire lock1 by serviceB");
                }
            }catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally{
//                lock2.unlock();
            }
        }else{
            System.out.println("unable to acquire lock2 by serviceB");
        }





    }
}
