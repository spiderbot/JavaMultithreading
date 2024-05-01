package com.piyush.joshi.normalrace;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class RaceStarter {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(9);
        Queue<WinnerDetails> winnerDetails = new LinkedList<>();
        CountDownLatch countDownLatch = new CountDownLatch(9);
        ReentrantLock lock = new ReentrantLock();

        // use builder design pattern

        //indian racers
        NormalRaceParticipant participantIndia3 = new NormalRaceParticipant("piyush","india",lock,winnerDetails,countDownLatch);
        NormalRaceParticipant participantIndia2 = new NormalRaceParticipant("priyanka","india",lock,winnerDetails,countDownLatch);
        NormalRaceParticipant participantIndia1 = new NormalRaceParticipant("prisha","india",lock,winnerDetails,countDownLatch);

        //usa racers
        NormalRaceParticipant participantUSA3 = new NormalRaceParticipant("tom","usa",lock,winnerDetails,countDownLatch);
        NormalRaceParticipant participantUSA2 = new NormalRaceParticipant("john","usa",lock,winnerDetails,countDownLatch);
        NormalRaceParticipant participantUSA1 = new NormalRaceParticipant("harry","usa",lock,winnerDetails,countDownLatch);

        //africa racers
        NormalRaceParticipant participantAfrica3 = new NormalRaceParticipant("usain","africa",lock,winnerDetails,countDownLatch);
        NormalRaceParticipant participantAfrica2 = new NormalRaceParticipant("rabada","africa",lock,winnerDetails,countDownLatch);
        NormalRaceParticipant participantAfrica1 = new NormalRaceParticipant("boucher","africa",lock,winnerDetails,countDownLatch);


        executorService.submit(participantAfrica1);
        executorService.submit(participantAfrica2);
        executorService.submit(participantAfrica3);

        executorService.submit(participantUSA1);
        executorService.submit(participantUSA2);
        executorService.submit(participantUSA3);

        executorService.submit(participantIndia1);
        executorService.submit(participantIndia2);
        executorService.submit(participantIndia3);

        countDownLatch.await();
        System.out.println("proceeding to executorservice shutdown");
        executorService.shutdown();  // can we use completable future instead of executorservice ??


        int i = 1;
        // print all if you want by iterating the queue

        // i am printing just the winner
        System.out.println("Winner participant name --> " + winnerDetails.peek().winnerName );
        System.out.println("Winner participant country --> " + winnerDetails.peek().winnerCountry );


    }
}
