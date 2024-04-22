package com.piyush.joshi.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class ResourceManager {

    Resource resource;
    ReentrantLock lock = new ReentrantLock();


    ResourceManager(){
        this.resource = new Resource();
    }

    public void putData(String key, String value,Long sleepDuration){
        System.out.println("thread trying to acquire lock " + Thread.currentThread().getName());
        lock.lock();

        try{
            System.out.println("thread acquired lock " + Thread.currentThread().getName());
            resource.putData(key,value);
            Thread.sleep(sleepDuration);
        }catch(Exception e){
            System.out.println("exception caught");
        }finally{
            System.out.println("thread released lock " + Thread.currentThread().getName());
            lock.unlock();
        }
    }

    public void printData(){
        resource.printData();
    }
}
