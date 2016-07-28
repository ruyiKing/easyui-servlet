package com.yrw.test.singleton;

import com.sun.org.apache.xalan.internal.xsltc.trax.SAX2DOM;

public class TestMain {
     public static void main(String [] args){
         TestStream s=TestStream.getTest();
         s.setName("张孝祥1");
         System.out.println(s.getName());
         TestStream s1=TestStream.getTest();
         s1.setName("张孝祥2");
         System.out.println(s1.getName());
         s.getInfo();
         s1.getInfo();
         if(s==s1){
             System.out.println("创建的是同一个实例");
         }else if(s!=s1){
             System.out.println("创建的不是同一个实例");
         }else{
             System.out.println("application error");
         }
     }
 }