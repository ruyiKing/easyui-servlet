package com.yrw.test.proxy.demo1;

public class RealSubject implements Subject
{   
  public void doSomething()   
  {   
    System.out.println( "call doSomething()" );   
  }   
}   