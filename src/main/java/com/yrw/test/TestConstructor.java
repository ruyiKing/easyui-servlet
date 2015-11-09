package com.yrw.test;

/**
 * Created by fate on 2015/11/5.
 */
public class TestConstructor {
	int i=0;
    TestConstructor tc() {
    	++i;
    	return this;
    }
    
    public static void main(String[] args) {
		TestConstructor testC=new TestConstructor();
		
		System.out.println(testC.tc().tc().tc().i);
	}
}
