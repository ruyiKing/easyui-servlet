package com.yrw.test.list;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<A1> list = new ArrayList<A1>();
        A1 a1 = new A1(1,"a1");
        A1 a2 = new A1(2,"a2");
        A1 a3 = new A1(3,"a3");
        A1 a4 = new A1(4,"a4");
        A1 a5 = new A1(5,"a5");

        list.add(a1);
        list.add(a2);
        list.add(a3);
        list.add(a4);
        list.add(a5);
         
        list.remove(a2);
         
        System.out.println(list.size());
    }
 
}
 
class A1{
    int id;
    String name;
    public A1(int id,String name){
        this.id = id;
        this.name = name;
    }
     
    public boolean equals(Object obj) {
        return false;
    }
     
}