package com.yrw.test.thread.cnblogs.xrq730;

public class MyThread07 extends Thread
{
    public void run()
    {
        try
        {
            System.out.println("run threadName = " + 
                    this.getName() + " begin");
            Thread.sleep(2000);
            System.out.println("run threadName = " + 
                    this.getName() + " end");
        } 
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        MyThread07 mt = new MyThread07();
        System.out.println("begin = " + System.currentTimeMillis());
        mt.start();
        System.out.println("end = " + System.currentTimeMillis());
    }
}