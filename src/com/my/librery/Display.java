package com.company.main.main;

import java.util.Observable;
import java.util.Observer;

public class Display implements Observer {

    private Room room;

    public Display(Room room) {
        this.room = room;
        room.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        synchronized (room) {
            System.out.println("Doctors: " + room.getDoctorCount() + " | Visitors: " +
                    room.getVisitorCount());
        }
    }
}
