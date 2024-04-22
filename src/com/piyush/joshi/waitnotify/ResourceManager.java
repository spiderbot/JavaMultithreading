package com.piyush.joshi.waitnotify;

import java.util.concurrent.locks.ReentrantLock;

public class ResourceManager {

    Resource resource = new Resource();

    ReentrantLock lock = new ReentrantLock();

    public void putData(String data) {

        try{
            while(true){
                lock.lock();
                if(resource.stack.size() >= 10){
                    System.out.println("stack size is max, thread going in waiting state");
                    lock.wait();
                }else{
                    System.out.println("pushing entry -> " + data);
                    resource.pushEntry(data);
                    Thread.sleep(1000);
                    lock.notify();
                }
            }
        }catch(Exception ie ){

        }finally{
            lock.unlock();
        }

    }

    public void consumeData() {

        try{
            while(true){
                lock.lock();
                if(resource.stack.size() == 0){
                    System.out.println("stack size is zero, consumer thread going in waiting state ");
                    lock.wait();
                }else{
                    System.out.println("reading entry -> " + resource.stack.pop());
                    Thread.sleep(1000);
                    lock.notify();
                }
            }
        }catch(Exception ie ){

        }finally{
            lock.unlock();
        }

    }
}
