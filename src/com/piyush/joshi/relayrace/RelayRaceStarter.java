package com.piyush.joshi.relayrace;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class RelayRaceStarter {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(9);
        Queue<WinnerDetails> winnerDetails = new LinkedList<>();
        CountDownLatch countDownLatch = new CountDownLatch(9);
        ReentrantLock lock = new ReentrantLock();

        // use builder design pattern

        //indian racers
        RelayRaceParticipant participantIndia3 = new RelayRaceParticipant("piyush","india",null,lock,winnerDetails,countDownLatch);
        RelayRaceParticipant participantIndia2 = new RelayRaceParticipant("priyanka","india",participantIndia3,lock,winnerDetails,countDownLatch);
        RelayRaceParticipant participantIndia1 = new RelayRaceParticipant("prisha","india",participantIndia2,lock,winnerDetails,countDownLatch);

        //usa racers
        RelayRaceParticipant participantUSA3 = new RelayRaceParticipant("tom","usa",null,lock,winnerDetails,countDownLatch);
        RelayRaceParticipant participantUSA2 = new RelayRaceParticipant("john","usa",participantUSA3,lock,winnerDetails,countDownLatch);
        RelayRaceParticipant participantUSA1 = new RelayRaceParticipant("harry","usa",participantUSA2,lock,winnerDetails,countDownLatch);

        //africa racers
        RelayRaceParticipant participantAfrica3 = new RelayRaceParticipant("usain","africa",null,lock,winnerDetails,countDownLatch);
        RelayRaceParticipant participantAfrica2 = new RelayRaceParticipant("rabada","africa",participantAfrica3,lock,winnerDetails,countDownLatch);
        RelayRaceParticipant participantAfrica1 = new RelayRaceParticipant("boucher","africa",participantAfrica2,lock,winnerDetails,countDownLatch);


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
        // print all if you want
        // i am printing just the winner

        System.out.println("Winner participant name --> " + winnerDetails.peek().winnerName );
        System.out.println("Winner participant country --> " + winnerDetails.peek().winnerCountry );


    }
}
