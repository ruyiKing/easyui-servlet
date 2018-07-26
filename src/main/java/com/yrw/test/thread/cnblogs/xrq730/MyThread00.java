package com.yrw.test.thread.cnblogs.xrq730;

public class MyThread00 extends Thread
{        
    public void run()
    {
        for (int i = 0; i < 5; i++)
        {
            System.out.println(Thread.currentThread().getName() + "在运行!");
        }
    }

    public static void main(String[] args)
    {
        MyThread00 mt0 = new MyThread00();
        mt0.start();

        for (int i = 0; i < 5; i++)
        {
            System.out.println(Thread.currentThread().getName() + "在运行！");
        }
    }
}