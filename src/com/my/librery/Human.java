package com.company.main.main;

abstract class Human extends Thread {

    private int timeInside;

    public Human(int timeInside) {
        this.timeInside = timeInside;
    }

    @Override
    public void run() {
        try {
            enter();
            Thread.sleep(timeInside);
            exit();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    abstract void enter() throws InterruptedException;

    abstract void exit() throws InterruptedException;
}

