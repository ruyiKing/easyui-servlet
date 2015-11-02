package com.yrw.test;

public class TestCoverZero {
	public static void main(String[] args) {
		String str = "0050580";
		   
		System.out.println(str.replaceFirst("^0*", ""));
		 

		//补零操作  10表示补零后字符串的长度为10

		String str1 = String.format("%010d", 100);    
		        
		 System.out.println(str1);
	}
}
