package com.piyush.joshi.countdownlatch;

public class Master extends Thread{

    String name;

    Master(String name){
        super(name);
        this.name = name;
    }
    public void run(){
        try{
            System.out.println("starting thread " + Thread.currentThread().getName());
            Thread.sleep(5000);
        }catch(InterruptedException ie){

        }
        System.out.println("exiting thread " + Thread.currentThread().getName());

    }
}
