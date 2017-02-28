package com.company.main.main;

import java.util.Random;

public class Main {

    private static final double PROBABILITY_DOCTOR = 0.2;
    private static final double PROBABILITY_VISITOR = 0.5;

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Start");
        Random r = new Random();

        Room room = new Room();
        new Display(room);

        while (true) {
            if (r.nextDouble() < PROBABILITY_VISITOR) {
                new Visitor(room).start();
            }
            if (r.nextDouble() < PROBABILITY_DOCTOR) {
                new Doctor(room).start();
            }
            Thread.sleep(200);
        }
    }
}
