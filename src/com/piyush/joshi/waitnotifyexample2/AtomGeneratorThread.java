package com.piyush.joshi.waitnotifyexample2;

public class AtomGeneratorThread extends Thread {

    H2OManager h2OManager;
    String type;

    AtomGeneratorThread(H2OManager h2OManager, String name , String type){
        super(name);
        this.h2OManager = h2OManager;
        this.type = type;
    }
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                generateAtom();
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private void generateAtom() {
        if("H".equalsIgnoreCase(this.type)){
            h2OManager.addHydrogen();
        }else{
            h2OManager.addOxygen();
        }
    }
}
