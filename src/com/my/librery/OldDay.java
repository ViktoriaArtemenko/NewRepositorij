package com.my.librery;

public class OldDay {


    public OldDay(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    //doSmt("T1");
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    synchronized (locker) {
                        System.out.println("T2 notify");
                        locker.notify();
                    }
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                    }
                }
            }
        });

        t1.setName("T1Name");
        t2.setName("T2Name");

        t1.setPriority(1);
        t2.setPriority(10);

        t1.start();
        t2.start();
    }

    Object locker = new Object();

//    public void doSmt(String info) {
//        synchronized (locker) {
//            System.out.println("doSmt begin " + info + " " + Thread.currentThread().getName());
//            try {
//                locker.wait();
//            } catch (InterruptedException e) {
//            }
//            System.out.println("doSmt end " + info + " " + Thread.currentThread().getName());
//        }
//    }
}
