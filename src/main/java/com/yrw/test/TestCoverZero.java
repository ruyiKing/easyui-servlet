package com.yrw.test;

public class TestCoverZero {
	public static void main(String[] args) {
		String str = "0050580";
		   
		System.out.println(str.replaceFirst("^0*", ""));
		 

		//�������  10��ʾ������ַ����ĳ���Ϊ10

		String str1 = String.format("%010d", 100);    
		        
		 System.out.println(str1);
	}
}
