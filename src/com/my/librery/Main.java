package com.my.librery;

import java.util.Random;

import java.util.Random;

public class Main {

    private static int[] mas;
    private static int n;
    private static Random random = new Random();
    private static int n1, n2, n3, n4;

    public static void main(String[] args) throws InterruptedException {

        n = 10;//random.nextInt(100) + 4;
        mas = new int[n];

        for (int i = 0; i < mas.length; i++) {
            mas[i] = random.nextInt(100);
        }

        n1 = n2 = n3 = mas.length / 4;
        n4 = mas.length - (n1 * 3);

        printMas(mas);

        System.out.println();
        System.out.println(n1 + "  " + n2 + "  " + n3 + "  " + n4);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < n1; i++) {
                    System.out.print("t1 " + mas[i] + " ");
                }
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = n1; i < n2 * 2; i++) {
                    System.out.print("t2 " + mas[i] + " ");
                }
            }
        });


        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = n2 * 2; i < n3 * 3; i++) {
                    System.out.print("t3 " + mas[i] + " ");
                }
            }
        });

        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = n3 * 3; i < mas.length; i++) {
                    System.out.print("t4 " + mas[i] + " ");
                }
            }
        });

        Thread t5 = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t5.wait();
        t5.wait();
        t5.wait();
        t5.wait();

    }

    public static void printMas(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static int getMaxInt(int start, int end) {
        int max = 0;
        for (int i = start; i < end; i++) {
            if (mas[i] > max) max = mas[i];

        }
        return max;
    }

    public static void myThread(Thread t){
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                getMaxInt(n3 * 3,  mas.length);
            }
        });
    }
}

