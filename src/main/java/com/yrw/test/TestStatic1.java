package com.yrw.test;
public class TestStatic1 extends Base{

    static{
        System.out.println("test static");
    }
    
    public TestStatic1(){
        System.out.println("test constructor");
    }
    
    public static void main(String[] args) {
        new TestStatic1();
    }
}

class Base{
    
    static{
        System.out.println("base static");
    }
    
    public Base(){
        System.out.println("base constructor");
    }
}