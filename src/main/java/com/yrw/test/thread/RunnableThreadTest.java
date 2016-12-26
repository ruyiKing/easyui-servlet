package com.yrw.test.thread;

/**
 * 2、通过Runnable接口创建线程类
 （1）定义runnable接口的实现类，并重写该接口的run()方法，该run()方法的方法体同样是该线程的线程执行体。
 （2）创建 Runnable实现类的实例，并依此实例作为Thread的target来创建Thread对象，该Thread对象才是真正的线程对象。
 （3）调用线程对象的start()方法来启动该线程。
 */
public class RunnableThreadTest implements Runnable {

    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        RunnableThreadTest rtt = new RunnableThreadTest();
        new Thread(rtt, "新线程1").start();
        new Thread(rtt, "新线程2").start();
    }

}