package com.yrw.test.string;

public class TestStringEqual {
	public static void main(String[] args) {
		String s1 = "abcdefg";
		String s2 = "abcdefg";
		System.out.println(s1.equals(s2));
		System.out.println(s1==s2);
		
		String s3 = new String("abcdefg");
		System.out.println(s3.equals(s1));
		System.out.println(s3==s1);
		
		Integer i1 = 1;
		Integer i2 = new Integer(1);
		System.out.println(i1.equals(i2));
		System.out.println(i1==i2);
	}

}
