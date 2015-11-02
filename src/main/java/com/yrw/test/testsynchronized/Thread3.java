package com.yrw.test.testsynchronized;
/**
 * 参考有道云笔记
 * synchronized 当它用来修饰一个方法或者一个代码块的时候，能够保证在同一时刻最多只有一个线程执行该段代码。 
 * @author fate
 *
 */
public class Thread3 { 
     class Inner { 
          private void m4t1() { 
               int i = 5; 
               while(i-- > 0) { 
                    System.out.println(Thread.currentThread().getName() + " : Inner.m4t1()=" + i); 
                    try { 
                         Thread.sleep(500); 
                    } catch(InterruptedException ie) { 
                    } 
               } 
          } 
          private synchronized  void m4t2() { 
               int i = 5; 
               while(i-- > 0) { 
                    System.out.println(Thread.currentThread().getName() + " : Inner.m4t2()=" + i); 
                    try { 
                         Thread.sleep(500); 
                    } catch(InterruptedException ie) { 
                    } 
               } 
          } 
     } 
     private void m4t1(Inner inner) { 
          synchronized(inner) { //使用对象锁 
        	  inner.m4t1(); 
          }
     } 
     private void m4t2(Inner inner) { 
          inner.m4t2(); 
     } 
     public static void main(String[] args) { 
          final Thread3 myt3 = new Thread3(); 
          final Inner inner = myt3.new Inner(); 
          Thread t1 = new Thread( new Runnable() {public void run() { myt3.m4t1(inner);} }, "t1"); 
	      Thread t2 = new Thread( new Runnable() {public void run() { myt3.m4t2(inner);} }, "t2"); 
	      t1.start(); 
	      t2.start(); 
  } 
}