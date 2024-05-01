package com.piyush.joshi.normalrace;

import java.util.Queue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class NormalRaceParticipant extends Thread {

    String name;
    String countryName;

    ReentrantLock lock;

    Queue<WinnerDetails> winnerDetails;

    CountDownLatch countDownLatch;

    NormalRaceParticipant(String name, String countryName, ReentrantLock lock, Queue<WinnerDetails> winnerDetails, CountDownLatch countDownLatch) {
        super(name);
        this.name = name;
        this.countryName = countryName;
        this.lock = lock;
        this.winnerDetails = winnerDetails;
        this.countDownLatch = countDownLatch;
    }

    public void run() {
        System.out.println(name + " --> started running thread");
        try {
            Thread.sleep(5000); // to simulate the running of thread
//            System.out.println(name + " --> trying to take lock");
            lock.lock();
            System.out.println("participant --> " + name + " and country --> " + countryName + " completed the race");
            winnerDetails.offer(new WinnerDetails(this.name, this.countryName));
            countDownLatch.countDown();
        }catch(Exception e){
            System.out.println("exception " + e.getMessage());
        } finally {
//            System.out.println("unlocking lock " + name);
            lock.unlock();
        }
        System.out.println(name + " --> stopped running");
    }
}
