package com.company.main.main;

public class Doctor extends Human {

    private Room room;

    public Doctor(Room room) {
        super(1000);
        this.room = room;
    }

    @Override
    public void enter() throws InterruptedException {
        synchronized (room) {
            while (room.getDoctorCount() > 0 || room.getVisitorCount() >= 4) {
                room.wait();
            }
            room.incDoctorCount(1);
            room.notifyDisplay();
        }
    }

    @Override
    public void exit() {
        synchronized (room) {
            room.incDoctorCount(-1);
            room.notify();
            room.notifyDisplay();
        }
    }

}
