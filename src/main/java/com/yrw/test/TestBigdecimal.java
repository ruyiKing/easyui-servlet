package com.yrw.test;

import java.math.BigDecimal;

public class TestBigdecimal {

	public static void main(String[] args) {
		BigDecimal a=new BigDecimal(12.88);
		float b=a.floatValue();
		System.out.println(b==12.88f);//b=12;
		String s1="he";
		String s2="o";
		String str = s1+"ll"+s2;
		System.out.println(str);
	}
}

