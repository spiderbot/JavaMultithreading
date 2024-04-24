package com.piyush.joshi.deadlockfree;

public class Task1 extends Thread{

    ServiceA serviceA;
    Task1(ServiceA serviceA, String name){
        super(name);
        this.serviceA = serviceA;
    }
    @Override
    public void run() {
        try {
            serviceA.process();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
