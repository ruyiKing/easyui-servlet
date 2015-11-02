package com.yrw.test;
public class TryCatchFinally {
 
    @SuppressWarnings("finally")
    public static final String test() {
        String t = "";
        int a=5,b=0;
        try {
        	//int c = a/b;
            t = "try";
            System.out.println("syso:"+t);
            return t;
        } catch (Exception e) {
            // result = "catch";
            t = "catch";
            System.out.println("syso:"+t);
            return t;
        } finally {
            t = "finally";
            System.out.println("syso:"+t);
            return t;
        }
    }
 
    public static void main(String[] args) {
        System.out.print(TryCatchFinally.test());
    }
 
}