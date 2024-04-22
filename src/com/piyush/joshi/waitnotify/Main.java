package com.piyush.joshi.waitnotify;



public class Main {
    public static void main(String[] args) throws InterruptedException {
            ResourceManager resourceManager = new ResourceManager();

            Producer producer = new Producer("producer", resourceManager);
            Consumer consumer  = new Consumer("consumer", resourceManager);

            producer.start();

            Thread.sleep(10000);
            consumer.start();

            producer.join();;
            consumer.join();
    }
}
