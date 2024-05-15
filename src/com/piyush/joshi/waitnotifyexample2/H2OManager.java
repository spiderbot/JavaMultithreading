package com.piyush.joshi.waitnotifyexample2;

import java.util.Arrays;
import java.util.Collections;

public class H2OManager {
    String[] molecule = new String[3]; // size will be 3 only , as we can have at most 2 hydrogen atoms and 1 oxygen atom and will have to wait elsewise
    Object lock = new Object();

    int count = 0;

    public void addHydrogen() {
        synchronized (lock) {
            if (Collections.frequency(Arrays.asList(molecule), "H") == 2) {
                try {
                    lock.wait();
                } catch (InterruptedException ex) {

                }
            }
            System.out.println(Thread.currentThread().getName() + " adding H");
            molecule[count] = "H";
            count++;
            if (Collections.frequency(Arrays.asList(molecule), "H") == 2 && Collections.frequency(Arrays.asList(molecule), "O") == 1) {
                for (String element : molecule) {
                    System.out.print(element);
                    System.out.println();
                }
            }
            if (count == 3) {
                Arrays.fill(molecule, null);
                count = 0;
            }
            lock.notifyAll();
        }
    }

    public void addOxygen() {
        synchronized (lock) {
            if (Collections.frequency(Arrays.asList(molecule), "O") == 1) {
                try {
                    lock.wait();
                } catch (InterruptedException ex) {

                }
            }
            System.out.println(Thread.currentThread().getName() + " adding O");
            molecule[count] = "O";
            count++;
            if (Collections.frequency(Arrays.asList(molecule), "H") == 2 && Collections.frequency(Arrays.asList(molecule), "O") == 1) {
                for (String element : molecule) {
                    System.out.print(element);
                    System.out.println();
                }
            }
            if (count == 3) {
                Arrays.fill(molecule, null);
                count = 0;
            }
            lock.notifyAll();
        }
    }

}
