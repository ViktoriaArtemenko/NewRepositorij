package com.company.main.main;

public class Visitor extends Human {

    private Room room;

    public Visitor(Room room) {
        super(1000);
        this.room = room;
    }

    @Override
    public void enter() throws InterruptedException {
        synchronized (room) {
            while (room.getDoctorCount() > 0 || room.getVisitorCount() >= 4) {
                room.wait();
            }
            room.incVisitorCount(1);
            room.notifyDisplay();
        }
    }

    @Override
    public void exit() {
        synchronized (room) {
            room.incVisitorCount(-1);
            room.notify();
            room.notifyDisplay();
        }
    }
}
