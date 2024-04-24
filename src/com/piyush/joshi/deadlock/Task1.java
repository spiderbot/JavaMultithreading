package com.piyush.joshi.deadlock;

public class Task1 extends Thread{

    ServiceA serviceA;
    Task1(ServiceA serviceA,String name){
        super(name);
        this.serviceA = serviceA;
    }
    @Override
    public void run() {
        serviceA.process();

    }
}
