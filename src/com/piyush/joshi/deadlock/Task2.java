package com.piyush.joshi.deadlock;

public class Task2 extends Thread{

    ServiceB serviceB;
    Task2( ServiceB serviceB,String name){
        super(name);
        this.serviceB = serviceB;
    }
    @Override
    public void run() {
        serviceB.process();
    }
}
