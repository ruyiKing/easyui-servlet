package com.yrw.test;

public class TestStatic {
	 
	static {
        _i = 20;
        System.out.println("20");
    }
	public static int _i = 10;
    
    public static void main(String[] args) {
        System.out.println(_i);
    }
}
