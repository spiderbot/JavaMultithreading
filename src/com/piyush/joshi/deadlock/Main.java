package com.piyush.joshi.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();
        ServiceA serviceA = new ServiceA(lock1, lock2);
        ServiceB serviceB = new ServiceB(lock1, lock2);
        Task1 thread1 = new Task1(serviceA, "thread1");
        Task2 thread2 = new Task2(serviceB, "thread2");

        thread1.start();
        thread2.start();
    }
}
