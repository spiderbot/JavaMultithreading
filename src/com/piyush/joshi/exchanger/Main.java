package com.piyush.joshi.exchanger;

import java.util.concurrent.Exchanger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Exchanger<String> exchanger = new Exchanger<String>();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("starting thread1");
                System.out.println("stopping thread1");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("starting thread2");
                System.out.println("stopping thread2");
            }
        });

        t1.start();
        t2.start();

//        exchanger.
    }
}
