package com.piyush.joshi.deadlockfree;

public class Task2 extends Thread{

    ServiceB serviceB;
    Task2(ServiceB serviceB, String name){
        super(name);
        this.serviceB = serviceB;
    }
    @Override
    public void run() {
        try {
            serviceB.process();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
