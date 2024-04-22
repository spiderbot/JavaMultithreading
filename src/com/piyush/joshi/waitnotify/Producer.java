package com.piyush.joshi.waitnotify;

public class Producer extends Thread{

    ResourceManager resourceManager;

    Producer(String name, ResourceManager resourceManager){
        super(name);
        this.resourceManager = resourceManager;
    }

    public void run(){
        for(int i=0;i<1000;i++){
            resourceManager.putData(i + "");
        }
    }

}
