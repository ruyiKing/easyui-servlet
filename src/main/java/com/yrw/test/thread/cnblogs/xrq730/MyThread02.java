package com.yrw.test.thread.cnblogs.xrq730;

public class MyThread02 extends Thread
{
    public void run()
    {
        try
        {
            for (int i = 0; i < 3; i++)
            {
                Thread.sleep((int)(Math.random() * 1000));
                System.out.println("run = " + Thread.currentThread().getName());
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        MyThread02 mt = new MyThread02();
        mt.start();

    }
}