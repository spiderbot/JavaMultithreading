package com.piyush.joshi.reentrantlock;

public class Task extends Thread{

    String key;
    String value;

    ResourceManager resourceManager;
    Long sleepDuration;
    Task(String name , String key , String value, ResourceManager resourceManager,Long sleepDuration){
        super(name);
        this.key = key;
        this.value = value;
        this.resourceManager = resourceManager;
        this.sleepDuration = sleepDuration;
    }

    public void run(){
            try{
                    this.resourceManager.putData(key,value,this.sleepDuration);
            }catch(Exception ie){

            }
            System.out.println("thread execution ended " + Thread.currentThread().getName() );
    }
}
