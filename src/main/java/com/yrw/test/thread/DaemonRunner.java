package com.yrw.test.thread;

import java.util.Scanner;

/**
 * Created by fate on 2015/10/21.
 */

public class DaemonRunner implements Runnable {
    public  void run(){
        while (true){
            for(int i=0;i<=3;i++){
                System.out.println("守护线程:"+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args){
        Thread daemonRunner = new Thread(new DaemonRunner());
        daemonRunner.setDaemon(true);
        daemonRunner.start();
        System.out.println("isDaemon = " + daemonRunner.isDaemon());
        Scanner scanner = new Scanner(System.in);
        scanner.next();

        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run(){
                System.out.println("JVM Exit");
            }
        });
    }
}
