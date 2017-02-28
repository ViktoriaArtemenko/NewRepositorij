package com.company.main.main;

import java.util.Observable;

public class Room extends Observable {

    private int doctorCount;
    private int visitorCount;


    public synchronized void notifyDisplay() {
        setChanged();
        notifyObservers();
    }

    public int getDoctorCount() {
        return doctorCount;
    }

    public int getVisitorCount() {
        return visitorCount;
    }

    public void incDoctorCount(int newCount) {
        this.doctorCount += newCount;
    }

    public void incVisitorCount(int newCount) {
        this.visitorCount += newCount;
    }

}
