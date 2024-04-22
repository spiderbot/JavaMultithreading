package com.piyush.joshi.waitnotify;


public class Consumer extends Thread{
    ResourceManager resourceManager;

    Consumer(String name, ResourceManager resourceManager){
        super(name);
        this.resourceManager = resourceManager;
    }

    public void run(){
        while(true){
            resourceManager.consumeData();
        }
    }
}
