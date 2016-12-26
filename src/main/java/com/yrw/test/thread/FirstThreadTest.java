package com.yrw.test.thread;

/**
 * 1、继承Thread类创建线程类
 （1）定义Thread类的子类，并重写该类的run方法，该run方法的方法体就代表了线程要完成的任务。因此把run()方法称为执行体。
 （2）创建Thread子类的实例，即创建了线程对象。
 （3）调用线程对象的start()方法来启动该线程。
 */
public class FirstThreadTest extends Thread {

    // 重写run方法，run方法的方法体就是现场执行体
    public void run() {
        System.out.println(getName());
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        new FirstThreadTest().start();
        new FirstThreadTest().start();
    }
}