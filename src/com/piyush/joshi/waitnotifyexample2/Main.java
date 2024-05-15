package com.piyush.joshi.waitnotifyexample2;

public class Main {
    public static void main(String[] args) {
        H2OManager h2OManager = new H2OManager();
        AtomGeneratorThread thread1 = new AtomGeneratorThread(h2OManager,"thread1","H");
        AtomGeneratorThread thread2 = new AtomGeneratorThread(h2OManager,"thread2","H");
        AtomGeneratorThread thread3 = new AtomGeneratorThread(h2OManager,"thread3","O");
        AtomGeneratorThread thread4 = new AtomGeneratorThread(h2OManager,"thread4","O");
        AtomGeneratorThread thread5 = new AtomGeneratorThread(h2OManager,"thread5","O");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }
}
