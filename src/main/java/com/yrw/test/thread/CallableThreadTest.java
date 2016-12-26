package com.yrw.test.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 3、通过Callable和Future创建线程
 （1）创建Callable接口的实现类，并实现call()方法，该call()方法将作为线程执行体，并且有返回值。
 （2）创建Callable实现类的实例，FutureTask对象封装了该Callable对象的call()方法的返回值。
 （3）使用FutureTask对象作为Thread对象的target创建并启动新线程。
 （4）调用FutureTask对象的get()方法来获得子线程执行结束后的返回值
 */
public class CallableThreadTest implements Callable<Integer> {

    public Integer call() throws Exception {

        System.out.println(Thread.currentThread().getName());

        return 10;
    }

    public static void main(String[] args) {

        CallableThreadTest ctt = new CallableThreadTest();

        FutureTask<Integer> ft = new FutureTask<>(ctt);

        System.out.println(Thread.currentThread().getName());

        new Thread(ft).start();
        try {
            System.out.println("线程的返回值：" + ft.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}