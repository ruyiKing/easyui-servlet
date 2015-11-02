package com.yrw.test;
public class TestStatic2 {
    Person1 person = new Person1("Test");
    static{
        System.out.println("test static");
    }
     
    public TestStatic2() {
        System.out.println("test constructor");
    }
     
    public static void main(String[] args) {
        new MyClass();
    }
}
 
class Person1{
    static{
        System.out.println("person static");
    }
    public Person1(String str) {
        System.out.println("person "+str);
    }
}
 
 
class MyClass extends TestStatic2 {
    Person1 person = new Person1("MyClass");
    static{
        System.out.println("myclass static");
    }
     
    public MyClass() {
        System.out.println("myclass constructor");
    }
}