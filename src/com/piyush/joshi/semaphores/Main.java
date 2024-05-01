package com.piyush.joshi.semaphores;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore = new Semaphore(2);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("acquiring semaphore in thread1");
                try {
                    semaphore.acquire();
                    System.out.println("acquired semaphore in thread1");
                    System.out.println("performing operation in thread1");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }finally{
                    System.out.println("releasing sempahore in thread1");
                    semaphore.release();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("acquiring semaphore in thread2");
                try {
                    semaphore.acquire();
                    System.out.println("acquired semaphore in thread2");
                    System.out.println("performing operation in thread2");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }finally{
                    System.out.println("releasing sempahore in thread2");
                    semaphore.release();
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("acquiring semaphore in thread3");
                try {
                    semaphore.acquire();
                    System.out.println("acquired semaphore in thread3");
                    System.out.println("performing operation in thread3");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }finally{
                    System.out.println("releasing sempahore in thread3");
                    semaphore.release();
                }
            }
        });
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("acquiring semaphore in thread4");
                try {
                    semaphore.acquire();
                    System.out.println("acquired semaphore in thread4");
                    System.out.println("performing operation in thread4");
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }finally{
                    System.out.println("releasing sempahore in thread4");
                    semaphore.release();
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

    }
}
