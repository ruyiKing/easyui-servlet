package com.yrw.test.thread;

import java.util.concurrent.TimeUnit;

/**

 *  守护线程

 */

public class Daemons {

 

    /**

     * @param args

     * @throws InterruptedException

     */

    public static void main(String[] args) throws InterruptedException {

        Thread d = new Thread(new Daemon());

        //d.setDaemon(true); //必须在启动线程前调用

        d.start();

        System.out.println("d.isDaemon() = " + d.isDaemon() + ".");


        TimeUnit.MILLISECONDS.sleep(2);
        Runtime.getRuntime().exit(0);

    }

 

}

 

class DaemonSpawn implements Runnable {

 

    public void run() {

        while (true) {

            Thread.yield();

        }

    }

   

}

 

class Daemon implements Runnable {

    private Thread[] t = new Thread[10];

 

    public void run() {

        for (int i=0; i<t.length; i++) {

            t[i] = new Thread(new DaemonSpawn());

            t[i].start();

            System.out.println("DaemonSpawn " + i + " started.");

        }

        for (int i=0; i<t.length; i++) {

            System.out.println("t[" + i + "].isDaemon() = " +

                    t[i].isDaemon() + ".");

        }

        while (true) {

            Thread.yield();

        }



    }

   

}